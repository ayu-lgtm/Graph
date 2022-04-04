
import java.util.*;

public class DFS_Disconnected_graph {
    public static void addEdge(ArrayList<ArrayList<Integer>> al, int from, int to) {
        al.get(from).add(to);
        al.get(to).add(from);// undirected graph
    }

    public static void main(String args[]) {
        int v = 7;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            al.add(new ArrayList<>());
        }
        addEdge(al, 0, 1);
        addEdge(al, 1, 2);
        addEdge(al, 2, 3);
        addEdge(al, 4, 5);
        addEdge(al, 5, 6);
        addEdge(al, 4, 6);

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
        for (int i = 0; i < al.size(); i++) {
            if (visit[i] == false) {
                function_DFS(al, i, visit);
                System.out.println();

            }
        }

    }
}
