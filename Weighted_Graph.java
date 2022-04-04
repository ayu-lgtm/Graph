import java.util.*;

class Edge{
    int source;
    int destination;
    int weight;
    Edge(int x,int y,int z){
        source=x;
        destination=y;
        weight=z;
    }
}

class Graph{
    int vertex;
    ArrayList<LinkedList<Edge>> al;
    Graph(int v){
        vertex=v;
        al = new ArrayList<>(v);
        for(int i=0;i<v;i++){
            al.add(new LinkedList<>());
        }
    }

    public void addEdge(int x,int y,int z){
        Edge e=new Edge(x,y,z);
        al.get(x).add(e);

    }

    public void printGraph(){
        for(int i=0;i<vertex;i++){
            LinkedList<Edge> l = al.get(i);
            for(int j=0;j<l.size();j++){
                System.out.println(i+" to "+l.get(j).destination+"__"+l.get(j).weight);
            }
        }
    }

}


public class Weighted_Graph {
    public static void main(String args[]){
        Graph g =new Graph(6);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 2);
        g.addEdge(1, 2, 5);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, 2);
        g.addEdge(4, 0, 4);
        g.addEdge(4, 1, 4);
        g.addEdge(4, 5, 6);
        g.printGraph();
    }
}
