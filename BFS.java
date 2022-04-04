import java.util.*;

public class BFS {
    public static void addEdge(ArrayList<ArrayList<Integer>> al, int from, int to) {
        al.get(from).add(to);
        al.get(to).add(from);// undirected graph
    }

    public static void main(String args[]) {
        int v = 5;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            al.add(new ArrayList<>());
        }
        addEdge(al, 0, 1);
        addEdge(al, 0, 2);
        addEdge(al, 2, 1);
        addEdge(al, 3, 1);
        addEdge(al, 3, 2);
        addEdge(al, 4, 2);
        addEdge(al, 4, 3);

        int count = 0;
        for (ArrayList<Integer> e : al) {
            System.out.println(count + " : " + e);
            count++;
        }

        function_BFS(al, 3);
    }

    public static void function_BFS(ArrayList<ArrayList<Integer>> al, int source) {
        Queue<Integer> q = new LinkedList<>();
        boolean visit[] = new boolean[al.size()];
        visit[source] = true;
        q.add(source);

        System.out.print("BFS_TRAVERSE : ");

        while (q.isEmpty() == false) {

            int u = q.poll();
            System.out.print(u + " ");
            for (int i = 0; i < al.get(u).size(); i++) {
                if (visit[al.get(u).get(i)] == false) {
                    visit[al.get(u).get(i)] = true;
                    q.add(al.get(u).get(i));

                }

            }

        }

    }
}
