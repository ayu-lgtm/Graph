
import java.util.*;

class Edge {
    int source;
    int destination;
    int weight;

    Edge(int x, int y, int z) {
        source = x;
        destination = y;
        weight = z;
    }
}

class Graph {
    int vertex;
    ArrayList<LinkedList<Edge>> al;

    Graph(int v) {
        vertex = v;
        al = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            al.add(new LinkedList<>());
        }
    }

    public void addEdge(int x, int y, int z) {
        Edge e = new Edge(x, y, z);
        al.get(x).add(e);

    }

    public void printGraph() {
        for (int i = 0; i < vertex; i++) {
            LinkedList<Edge> l = al.get(i);
            for (int j = 0; j < l.size(); j++) {
                System.out.println(i + " to " + l.get(j).destination + "__" + l.get(j).weight);
            }
        }
    }

}

public class Dijkstra_algo {
    public static void function_dijkstra(Graph g, int vertex) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int dist[] = new int[vertex];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        pq.add(0);

        while (pq.isEmpty() == false) {

            int u = pq.poll();
            // System.out.println(u);

            for (Edge e : g.al.get(u)) {
                if (pq.contains(u) == false) {
                    // System.out.println(dist[e.destination]+" "+(dist[u] + e.weight));
                    if (dist[e.destination] > dist[u] + e.weight) {
                        dist[e.destination] = dist[u] + e.weight;

                    }
                    pq.add(e.destination);

                } else if (pq.contains(e.destination) == false) {
                    if (dist[e.destination] > dist[u] + e.weight) {
                        dist[e.destination] = dist[u] + e.weight;

                    }
                    pq.add(e.destination);
                }

            }
            // System.out.println(Arrays.toString(dist)+" "+pq);
        }

        System.out.print(Arrays.toString(dist));
    }

    public static void main(String args[]) {
        int vertex = 9;
        Graph g = new Graph(vertex);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 8);
        g.addEdge(1, 2, 11);
        g.addEdge(1, 3, 8);
        g.addEdge(2, 4, 7);
        g.addEdge(3, 4, 2);
        g.addEdge(2, 5, 1);
        g.addEdge(4, 5, 6);
        g.addEdge(3, 6, 7);
        g.addEdge(3, 7, 4);
        g.addEdge(5, 7, 2);
        g.addEdge(6, 7, 14);
        g.addEdge(6, 8, 9);
        g.addEdge(7, 8, 10);

        // g.printGraph();
        function_dijkstra(g, vertex);

    }
}
