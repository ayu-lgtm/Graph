
import java.util.*;

public class DFS__undirected_and_connected_graph {
    public static void addEdge(ArrayList<ArrayList<Integer>> al, int from, int to) {
        al.get(from).add(to);
        al.get(to).add(from);// undirected graph
    }

    public static void main(String args[]) {
        int v = 6;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            al.add(new ArrayList<>());
        }
        addEdge(al, 0, 1);
        addEdge(al, 0, 2);
        addEdge(al, 2, 3);
        addEdge(al, 3, 1);
        addEdge(al, 4, 1);
        addEdge(al, 4, 5);

        int count = 0;
        for (ArrayList<Integer> e : al) {
            System.out.println(count + " : " + e);
            count++;
        }

        dfs(al, 0);
    }

    public static void function_DFS(ArrayList<ArrayList<Integer>> al, int source, boolean visit[]) {

        visit[source] = true;

        System.out.print(source + " ");

        for (int i = 0; i < al.get(source).size(); i++) {
            if (visit[al.get(source).get(i)] == false) {
                function_DFS(al, al.get(source).get(i), visit);
            }

        }

    }

    public static void dfs(ArrayList<ArrayList<Integer>> al, int s) {
        boolean visit[] = new boolean[al.size()];
        function_DFS(al, s, visit);
    }
}
