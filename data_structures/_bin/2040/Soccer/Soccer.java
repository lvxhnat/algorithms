import java.util.HashMap;
import java.util.Map;

/**
 * Name: Loh Yi Kuang Matric. No: A0238627W
 */

public class Soccer {

  private static class AVLTree<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
      private final Key key;
      private Value val;
      private int height;
      private int size;
      private Node left;
      private Node right;

      public Node(Key key, Value val, int height, int size) {
        this.key = key;
        this.val = val;
        this.size = size;
        this.height = height;
      }
    }

    public int size() {
      return size(root);
    }

    private int size(Node x) {
      if (x == null)
        return 0;
      return x.size;
    }

    private int height(Node x) {
      if (x == null)
        return -1;
      return x.height;
    }

    public Value get(Key key) {
      Node x = get(root, key);
      if (x == null)
        return null;
      return x.val;
    }

    public int getRank(Key key) {
      return 1 + size() - getNodeRank(root, key);
    }

    private int getNodeRank(Node node, Key x) {
      if (node == null)
        return 0;
      if (node.key.compareTo(x) <= 0) {
        if (node.left == null)
          return 1 + getNodeRank(node.right, x);
        else
          return 1 + node.left.size + getNodeRank(node.right, x);
      } else
        return getNodeRank(node.left, x);
    }

    private Node get(Node x, Key key) {
      if (x == null)
        return null;
      int cmp = key.compareTo(x.key);
      if (cmp < 0)
        return get(x.left, key);
      else if (cmp > 0)
        return get(x.right, key);
      else
        return x;
    }

    public boolean contains(Key key) {
      return get(key) != null;
    }

    public void put(Key key, Value val) {
      if (val == null) {
        delete(key);
        return;
      }
      root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
      if (x == null)
        return new Node(key, val, 0, 1);
      int cmp = key.compareTo(x.key);
      if (cmp < 0) {
        x.left = put(x.left, key, val);
      } else if (cmp > 0) {
        x.right = put(x.right, key, val);
      } else {
        x.val = val;
        return x;
      }
      x.size = 1 + size(x.left) + size(x.right);
      x.height = 1 + Math.max(height(x.left), height(x.right));
      return balance(x);
    }

    private Node balance(Node x) {
      if (balanceFactor(x) < -1) {
        if (balanceFactor(x.right) > 0) {
          x.right = rotateRight(x.right);
        }
        x = rotateLeft(x);
      } else if (balanceFactor(x) > 1) {
        if (balanceFactor(x.left) < 0) {
          x.left = rotateLeft(x.left);
        }
        x = rotateRight(x);
      }
      return x;
    }

    private int balanceFactor(Node x) {
      return height(x.left) - height(x.right);
    }

    private Node rotateRight(Node x) {
      Node y = x.left;
      x.left = y.right;
      y.right = x;
      y.size = x.size;
      x.size = 1 + size(x.left) + size(x.right);
      x.height = 1 + Math.max(height(x.left), height(x.right));
      y.height = 1 + Math.max(height(y.left), height(y.right));
      return y;
    }

    private Node rotateLeft(Node x) {
      Node y = x.right;
      x.right = y.left;
      y.left = x;
      y.size = x.size;
      x.size = 1 + size(x.left) + size(x.right);
      x.height = 1 + Math.max(height(x.left), height(x.right));
      y.height = 1 + Math.max(height(y.left), height(y.right));
      return y;
    }

    public void delete(Key key) {
      if (!contains(key))
        return;
      root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
      int cmp = key.compareTo(x.key);
      if (cmp < 0) {
        x.left = delete(x.left, key);
      } else if (cmp > 0) {
        x.right = delete(x.right, key);
      } else {
        if (x.left == null) {
          return x.right;
        } else if (x.right == null) {
          return x.left;
        } else {
          Node y = x;
          x = min(y.right);
          x.right = deleteMin(y.right);
          x.left = y.left;
        }
      }
      x.size = 1 + size(x.left) + size(x.right);
      x.height = 1 + Math.max(height(x.left), height(x.right));
      return balance(x);
    }

    private Node deleteMin(Node x) {
      if (x.left == null)
        return x.right;
      x.left = deleteMin(x.left);
      x.size = 1 + size(x.left) + size(x.right);
      x.height = 1 + Math.max(height(x.left), height(x.right));
      return balance(x);
    }

    private Node min(Node x) {
      if (x.left == null)
        return x;
      return min(x.left);
    }
  }

  static class Pair implements Comparable<Pair> {
    Long first;
    Integer second;

    Pair(Long first, Integer second) // constructor
    {
      this.first = first;
      this.second = second;
    }

    public int compareTo(Pair other) {
      if (this.first > other.first) {
        return 1;
      }
      if (this.first < other.first) {
        return -1;
      }
      if (this.second < other.second) { // Reverse since we want to favor the ones that first got added
        return 1;
      }
      if (this.second > other.second) {
        return -1;
      }
      return 0;
    }
  }

  public static void main(String args[]) {

    Kattio io = new Kattio(System.in);
    int n = io.getInt();

    Map<String, Pair> pointAccumulator = new HashMap<>();
    AVLTree<Pair, String> pointTree = new AVLTree<>();
    int sequenceAdded = 1;

    for (int i = 0; i < n; i++) {

      String command = io.getWord();

      if (command.equals("ADD")) {

        String X = io.getWord();
        long P = io.getLong();

        Pair key = new Pair(P, sequenceAdded);

        pointTree.put(key, X);
        sequenceAdded++;
        pointAccumulator.put(X, key);

      } else if (command.equals("MATCH")) {

        String X = io.getWord();
        String Y = io.getWord();
        long A = io.getLong();
        long B = io.getLong();

        Pair currentXValue = pointAccumulator.get(X);
        Pair currentYValue = pointAccumulator.get(Y);

        pointTree.delete(currentXValue);
        pointTree.delete(currentYValue);

        if (A > B) {

          Pair newXValue = new Pair(currentXValue.first + (A - B), currentXValue.second);
          Pair newYValue = new Pair(currentYValue.first - (A - B), currentYValue.second);

          // update tree
          if (newXValue.first > 0) {
            pointTree.put(newXValue, X);
          }
          if (newYValue.first > 0) {
            pointTree.put(newYValue, Y);
          }
          pointAccumulator.replace(X, newXValue);
          pointAccumulator.replace(Y, newYValue);

        } else if (A < B) {
          Pair newXValue = new Pair(currentXValue.first - (B - A), currentXValue.second);
          Pair newYValue = new Pair(currentYValue.first + (B - A), currentYValue.second);

          // update tree
          if (newXValue.first > 0) {
            pointTree.put(newXValue, X);
          }
          if (newYValue.first > 0) {
            pointTree.put(newYValue, Y);
          }

          pointAccumulator.replace(X, newXValue);
          pointAccumulator.replace(Y, newYValue);
        }

      } else if (command.equals("QUERY")) {

        String X = io.getWord();
        long points = pointAccumulator.get(X).first;
        int rank = pointTree.getRank(pointAccumulator.get(X));

        if (points < 0) {
          System.out.println("Team " + X + " is ELIMINATED");
        } else {
          System.out.println("Team " + X + ": " + points + " points, rank " + rank);
        }
      }
    }

  }
}
