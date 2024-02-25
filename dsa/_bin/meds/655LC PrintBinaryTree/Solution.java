import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public int findDepth(TreeNode root) {
        // Find the max of either left or right
        if (root == null)
            return 0;
        else
            return 1 + Math.max(findDepth(root.left), findDepth(root.right));
    }

    public List<List<String>> printTree(TreeNode root) {

        int depth = findDepth(root);
        int width = (int) Math.pow(2, depth + 1) - 1;

        List<List<String>> l = new ArrayList<>();

        for (int i = 0; i < depth; i++) {
            l.add(i, new ArrayList<>());
            for (int j = 0; j < width; j++) {
                List<String> a = l.get(i);
                a.add(j, "");
                l.add(i, a);
            }
        }

        l = parseNode(root, 0, 0, width - 1, l);

        return l;
    }

    public List<List<String>> parseNode(TreeNode node, int depth, int left, int right, List<List<String>> l) {
        if (node == null) {
            return l;
        }

        int mid = (int) (left + right) / 2;

        List<String> a = l.get(depth);
        a.add(mid, String.valueOf(node.val));
        l.add(depth, a);

        parseNode(node.left, depth + 1, left, mid, l);
        parseNode(node.right, depth + 1, mid + 1, right, l);

        return l;
    }
}