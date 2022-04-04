
import java.util.*;

public class Detect_cycle_using_topological_sort {
    public static void addEdge(ArrayList<ArrayList<Integer>> al, int s, int e) {
        al.get(s).add(e);
    }

    public static void main(String args[])

    {
        int v = 6;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            al.add(new ArrayList<>());
        }

        addEdge(al, 0, 1);
        addEdge(al, 0, 2);
        addEdge(al, 2, 3);
        addEdge(al, 1, 3);
        addEdge(al, 3, 4);
        addEdge(al, 4, 1);
        addEdge(al, 3, 5);


        int count = 0;
        for (ArrayList<Integer> x : al) {
            System.out.println(count + " : " + x);
        }

        System.out.print("Cycle : "+TopologicalSort_detect(al));
    }

    public static boolean TopologicalSort_detect(ArrayList<ArrayList<Integer>> al) {
        int indegree[] = new int[al.size()];

        for (ArrayList<Integer> x : al) {
            for (int y : x) {
                indegree[y]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count=0;
        while (q.isEmpty() == false) {
            int data = q.poll();
            System.out.print(data + " ");
            for (int x : al.get(data)) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    q.add(x);
                }
            }
            count++;
        }

        return (count!=al.size());
    }

}

