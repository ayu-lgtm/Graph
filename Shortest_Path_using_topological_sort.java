
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

public class Shortest_Path_using_topological_sort {

    public static void function_for_shortest_path(Graph g, int vertex) {

        Topological_sort(g, vertex);

    }

    public static void Topological_sort(Graph g, int vertex) {
        int[] dist = new int[vertex];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;

        boolean visit[] = new boolean[vertex];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < vertex; i++) {
            if (visit[i] == false) {
                dfs_topological(g, visit, i, st);
            }
        }

        while (st.isEmpty() == false) {
            int val = st.pop();
            for (Edge e : g.al.get(val)) {
                if (dist[e.destination] > dist[e.source] + e.weight) {
                    dist[e.destination] = dist[e.source] + e.weight;
                }
            }

        }

        System.out.print(Arrays.toString(dist));
    }

    public static void dfs_topological(Graph g, boolean visit[], int source, Stack<Integer> st) {
        visit[source] = true;
        for (Edge e : g.al.get(source)) {
            if (visit[e.destination] == false) {
                dfs_topological(g, visit, e.destination, st);
            }
        }
        st.push(source);
    }

    public static void main(String args[]) {
        int vertex = 6;
        Graph g = new Graph(vertex);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 4, 1);
        g.addEdge(1, 2, 3);
        g.addEdge(4, 2, 2);
        g.addEdge(2, 3, 6);
        g.addEdge(4, 5, 4);
        g.addEdge(5, 3, 1);

        g.printGraph();

        function_for_shortest_path(g, vertex);
    }
}
