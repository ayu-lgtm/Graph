
import java.util.ArrayList;

class Detect_cycle__directed_graph {
    public static void addEdge(ArrayList<ArrayList<Integer>> al, int s, int e) {
        al.get(s).add(e);
    }

    public static boolean dfs_detect(ArrayList<ArrayList<Integer>> al, int s, boolean visit[], boolean rec[]) {
        visit[s] = true;
        rec[s] = true;

        for (int i = 0; i < al.get(s).size(); i++) {
            if (visit[al.get(s).get(i)] == false && dfs_detect(al, al.get(s).get(i), visit, rec)) {
                return true;
            } else if (rec[al.get(s).get(i)] == true) {
                return true;
            }
        }
        rec[s] = false;
        return false;
    }

    public static boolean dfs_directed_graph(ArrayList<ArrayList<Integer>> al) {
        boolean visit[] = new boolean[al.size()];
        boolean rec[] = new boolean[al.size()];

        for (int i = 0; i < al.size(); i++) {
            if (visit[i] == false) {
                if (dfs_detect(al, i, visit, rec) == true) {
                    return true;
                }

            }
        }
        return false;
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

        System.out.print(dfs_directed_graph(al));

    }
}
