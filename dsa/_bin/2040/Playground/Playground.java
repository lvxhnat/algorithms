import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Name : Loh Yi Kuang
 * Matric. No : A0238627W
 */
public class Playground {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int noPlaygrounds = io.getInt();
        int noTunnels = io.getInt();
        int noFriends = io.getInt();

        int startPlaygroundId = io.getInt();
        int g = io.getInt(); // The dude must end up here
        int h = io.getInt(); // The dude will be transferred here

        Graph graph = new Graph(noPlaygrounds);
        HashMap<Integer, Integer> checker = new HashMap<>();
        LinkedList<Integer> friendsToCheck = new LinkedList<>();

        for (int i = 0; i < noTunnels; i++) {
            int source = io.getInt();
            int dest = io.getInt();
            graph.addEdge(source, dest, io.getInt());
            checker.put(source, dest);
        }

        for (int i = 0; i < noFriends; i++) {
            friendsToCheck.addLast(io.getInt());
        }

        graph.getShortestPath(startPlaygroundId, g, h, friendsToCheck);
    }

    static class Pair<K, V> {

        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return this.key;
        };

        V getValue() {
            return this.value;
        }
    }

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Edge>[] adjacencylist;
        LinkedList<Integer> friendsToCheck;
        boolean[] validTraversal;

        Graph(int vertices) {
            this.vertices = vertices;
            this.validTraversal = new boolean[vertices];
            adjacencylist = new LinkedList[vertices];
            // initialize adjacency lists for all the vertices
            for (int i = 0; i < vertices; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination, int weight) {
            source = source - 1;
            destination = destination - 1;
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge);

            edge = new Edge(destination, source, weight);
            adjacencylist[destination].addFirst(edge); // for undirected graph
        }

        public void getShortestPath(int sourceVertex, int g, int h, LinkedList<Integer> friendsToCheck) {
            this.friendsToCheck = friendsToCheck;

            boolean[] SPT = new boolean[vertices];
            // distance used to store the distance of vertex from a source
            int[] distance = new int[vertices];

            // Initialize all the distance to infinity
            for (int i = 0; i < vertices; i++) {
                distance[i] = Integer.MAX_VALUE;
            }
            // Initialize priority queue
            // override the comparator to do the sorting based keys
            PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(vertices,
                    new Comparator<Pair<Integer, Integer>>() {
                        @Override
                        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                            // sort using distance values
                            int key1 = p1.getKey();
                            int key2 = p2.getKey();
                            return key1 - key2;
                        }
                    });
            // create the pair for for the first index, 0 distance 0 index
            distance[0] = 0;
            Pair<Integer, Integer> p0 = new Pair<>(distance[0], 0);
            // add it to pq
            pq.offer(p0);

            // while priority queue is not empty
            while (!pq.isEmpty()) {

                Pair<Integer, Integer> extractedPair = pq.poll();
                int extractedVertex = extractedPair.getValue();

                if (SPT[extractedVertex] == false) {
                    SPT[extractedVertex] = true;

                    // iterate through all the adjacent vertices and update the keys
                    LinkedList<Edge> list = adjacencylist[extractedVertex];

                    for (int i = 0; i < list.size(); i++) {
                        Edge edge = list.get(i);

                        int destination = edge.destination;
                        // only if edge destination is not present in mst
                        if (SPT[destination] == false) {
                            /// check if distance needs an update or not
                            // means check total weight from source to vertex_V is less than
                            // the current distance value, if yes then update the distance
                            int newKey = distance[extractedVertex] + edge.weight;
                            int currentKey = distance[destination];
                            if (currentKey > newKey) {
                                Pair<Integer, Integer> p = new Pair<>(newKey, destination);
                                pq.offer(p);
                                distance[destination] = newKey;
                                if ((edge.destination == g - 1 && edge.source == h - 1)
                                        || (edge.source == g - 1 && edge.destination == h - 1)
                                        || validTraversal[edge.source])
                                    validTraversal[edge.destination] = true;
                            }
                        }
                    }
                }
            }
            // print Shortest Path Tree
            printDijkstra(distance, sourceVertex);
        }

        public void printDijkstra(int[] distance, int sourceVertex) {

            List<Integer> validFriends = new ArrayList<>();

            while (!friendsToCheck.isEmpty()) {
                int friendId = friendsToCheck.poll() - 1;
                if (validTraversal[friendId]) {
                    validFriends.add(friendId);
                }
            }

            Collections.sort(validFriends);
            for (int i = 0; i < validFriends.size(); i++) {
                if (i == validFriends.size() - 1) {
                    System.out.print(validFriends.get(i) + 1);
                } else {
                    System.out.print((validFriends.get(i) + 1) + " ");
                }
            }
            System.out.println("");
        }
    }
}