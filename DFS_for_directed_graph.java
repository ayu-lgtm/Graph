
import java.util.ArrayList;

public class DFS_for_directed_graph {
    public static void addEdge(ArrayList<ArrayList<Integer>> al, int s, int e) {
        al.get(s).add(e);
    }

    public static void dfs_detect(ArrayList<ArrayList<Integer>> al, int s, boolean visit[]) {
        visit[s] = true;

        System.out.print(s + " ");
        for (int i = 0; i < al.get(s).size(); i++) {
            if (visit[al.get(s).get(i)] == false) {
                dfs_detect(al, al.get(s).get(i), visit);
            }
        }
    }

    public static void dfs_directed_graph(ArrayList<ArrayList<Integer>> al) {
        boolean visit[] = new boolean[al.size()];

        for (int i = 0; i < al.size(); i++) {
            if (visit[i] == false) {
                dfs_detect(al, i, visit);
                System.out.print("\n");  

            }
        }
    }

    public static void main(String args[]) {
        int v = 6;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            al.add(new ArrayList<>());
        }

        addEdge(al, 0, 1);
        addEdge(al, 2, 1);
        addEdge(al, 2, 3);
        addEdge(al, 3, 4);
        addEdge(al, 4, 5);
        addEdge(al, 5, 3);

        int count = 0;
        for (ArrayList<Integer> x : al) {
            System.out.println(count + " : " + x);
        }

       dfs_directed_graph(al);

    }
}
