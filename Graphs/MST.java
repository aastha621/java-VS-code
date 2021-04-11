package Graphs;
import java.util.*;
import Graphs.traversals.Edge;

public class MST 
{
    //making a class that will store the certex value, parent and wt for each vertex
    public static class graphNode implements Comparable<graphNode>
    {
        int ver;
        int parent;
        int key;

        @Override
        public int compareTo(graphNode o) 
        {
            
            return this.key-o.key;
        }

        graphNode(int v,int p,  int k)
        {
            ver=v;
            parent=p;
            key=k;
        }

    }
    
    public static void PrimsBFS(ArrayList<ArrayList<Edge>> graph)
    {
        int v=graph.size();

        boolean[] visited= new boolean[v];

        PriorityQueue <graphNode> pq= new PriorityQueue<>();

        //adding src node to pq
        pq.add(new graphNode(0,-1,0));

        //heading
        System.out.println("The Minimum spanning tree for this graph is");
        System.out.println("EDGE" +"    "+ "WEIGHT" );

        while(!pq.isEmpty())
        {
            graphNode node= pq.poll();

            int vertex=node.ver;

            if(visited[vertex])
            continue;

            visited[vertex]=true;

            ArrayList<Edge> nbrs= graph.get(vertex);

            if(node.parent!=-1)
            System.out.println(node.parent+ " -> " + vertex +"    "+ node.key );

            //adding all unvisited the adjacent nodes in the pq, which will get sorted by weight
            for(Edge edge: nbrs)
            {
                int nbr=edge.v;
                int wt=edge.w;

                if(!visited[nbr])
                {
                    pq.add(new graphNode(nbr,node.ver, wt));
                }
            }


        }





        



    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Edge>> graph= new ArrayList<>();

        for(int i=0; i<9; i++){
            graph.add(i,new ArrayList<Edge>());
        }

        traversals.addEdge(graph, 0, 1, 4);
        traversals.addEdge(graph, 0, 7, 8);
        traversals.addEdge(graph, 1, 2, 8);
        traversals.addEdge(graph, 1, 7, 11);
        traversals.addEdge(graph, 2, 3, 7);
        traversals.addEdge(graph, 2, 8, 2);
        traversals.addEdge(graph, 2, 5, 4);
        traversals.addEdge(graph, 3, 4, 9);
        traversals.addEdge(graph, 3, 5, 14);
        traversals.addEdge(graph, 4, 5, 10);
        traversals.addEdge(graph, 5, 6, 2);
        traversals.addEdge(graph, 6, 7, 1);
        traversals.addEdge(graph, 6, 8, 6);
        traversals.addEdge(graph, 7, 8, 7);


        // traversals.addEdge(graph, 0, 1, 1);
        // traversals.addEdge(graph, 1, 2, 1);
        // traversals.addEdge(graph, 2, 3, 1);
        // traversals.addEdge(graph, 3, 4, 1);
        // traversals.addEdge(graph, 4, 5, 1);
        // traversals.addEdge(graph, 5, 3, 1);


        PrimsBFS(graph);
        
    }



    
}
