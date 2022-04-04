import java.util.Arrays;

public class Minimum_spanning_tree {
    public static void main(String args[]){
        int arr[][]={{0,5,8,0},{5,0,10,15},{8,10,0,20},{0,15,20,0}};

        int res=0;
        int key[]=new int[arr[0].length];
        boolean mset[]=new boolean[arr[0].length];

        Arrays.fill(key,Integer.MAX_VALUE);

        key[0]=0;


        for(int i=0;i<arr.length;i++){
            int u=-1;
            for(int j=0;j<arr.length;j++){
                if(!mset[j] && (u==-1 ||key[j]<key[u] )){
                    u=j;
                }
            }

            mset[u]=true;
            res=res+key[u];

            for(int v=0;v<arr.length;v++){
                if(!mset[v] && arr[u][v]!=0 && arr[u][v]<key[v]){
                    key[v]=arr[u][v];
                }
            }

            //System.out.print("U : "+u+"      ");
            System.out.println(Arrays.toString(key)+"      Res : "+res);

        }

        System.out.print("Minimum_cost :"+res);

    }
}
