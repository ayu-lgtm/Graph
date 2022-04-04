

import java.util.ArrayList;
import java.util.Stack;

class Topological_Sort_using_DFS {
    public static void addEdge(ArrayList<ArrayList<Integer>> al, int s, int e) {
        al.get(s).add(e);
    }

    public static void dfs_detect(ArrayList<ArrayList<Integer>> al, int s, boolean visit[], Stack<Integer> st) {
        visit[s] = true;

        for (int i = 0; i < al.get(s).size(); i++) {
            if (visit[al.get(s).get(i)] == false){
                dfs_detect(al, al.get(s).get(i), visit,st);
            } 
            
        }
        st.push(s);
    }

    public static void dfs_directed_graph(ArrayList<ArrayList<Integer>> al) {
        boolean visit[] = new boolean[al.size()];

        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < al.size(); i++) {
            if (visit[i] == false) {
                dfs_detect(al, i, visit,st);

            }
        }
        while(st.isEmpty()==false){
            System.out.print(st.pop()+" ");
        }
        
    }

    public static void main(String args[]) {
        int v = 6;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            al.add(new ArrayList<>());
        }

        addEdge(al, 0, 1);
        addEdge(al, 0, 2);
        addEdge(al, 1, 3);
        addEdge(al, 2, 3);
        addEdge(al, 3, 4);
        addEdge(al, 3, 5);
     

        int count = 0;
        for (ArrayList<Integer> x : al) {
            System.out.println(count + " : " + x);
        }

        dfs_directed_graph(al);

    }
}

