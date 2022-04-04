import java.util.ArrayList;

public class Detect_cycle_undirected_graph {
    public static void addEdge(ArrayList<ArrayList<Integer>> al ,int s,int e){
        al.get(s).add(e);
        al.get(e).add(s);
    }

    public static boolean dfs_detect(ArrayList<ArrayList<Integer>> al,int s,boolean visit[],int parent){
        visit[s]=true;

        for(int i=0;i<al.get(s).size();i++){
            if(visit[al.get(s).get(i)]==false){
                if(dfs_detect(al,al.get(s).get(i), visit, s)==true){
                    return true;
                }
                else if(al.get(s).get(i)!=parent){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean function_detect_cycle(ArrayList<ArrayList<Integer>> al){
        boolean visit[]=new boolean[al.size()];

        for(int i=0;i<al.size();i++){
            if(visit[i]==false){
                if(dfs_detect(al,i,visit,-1)==true){
                    return true;
                }
            }
        }
        return false;


    }

    public static void main(String args[]){
        int v=4;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        for(int i=0;i<v;i++){
            al.add(new ArrayList<>());
        }

        addEdge(al, 0, 1);
        addEdge(al, 1, 2);
        addEdge(al, 0, 3);
        addEdge(al, 1, 3);
        addEdge(al, 3, 2);
        

        int count=0;
        for(ArrayList<Integer> x :al){
            System.out.println(count+" : "+x);
        }

        System.out.print("ques : Is cycle in graph ? \nAnswer : "+function_detect_cycle(al));

    }
}
