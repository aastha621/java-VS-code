package Graphs;
import java.util.*;
import Graphs.traversals.Edge;

public class MST 
{
    public static class EdgePair implements Comparable<EdgePair>
    {
        int u;
        int v;
        int w;

        EdgePair(int a, int b, int c)
        {
            u=a;
            v=b;
            w=c;

        }

        @Override
        public int compareTo(EdgePair o) {
            
            return this.w-o.w;
        }

        
    }

    //making a class that will store the vertex value, parent and wt for each vertex
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

        graphNode(int v,int p, int k)
        {
            ver=v;
            parent=p;
            key=k; 
        }

    }
    

    public static ArrayList<EdgePair> giveEdgeList(ArrayList<ArrayList<Edge>> graph)
    {

        ArrayList<EdgePair> edgeList = new ArrayList<>();
        
        for(int i=0; i<graph.size(); i++)
        {
            ArrayList<Edge> adj= graph.get(i);

            for(Edge e: adj)
            {
                int nbr=e.v; 
                int wt=e.w;

                if(i<=nbr){
                    edgeList.add(new EdgePair(i, nbr, wt));
                }
            }

        }

        return edgeList;


    }
    
    public static void PrimsBFS(ArrayList<ArrayList<Edge>> graph)
    {
        int v=graph.size();

        boolean[] visited= new boolean[v];

        PriorityQueue <graphNode> pq= new PriorityQueue<>();

        //adding src node to pq
        pq.add(new graphNode(0,-1,0));

        //heading
        System.out.println("The Minimum spanning tree for this graph using Prims is");
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

    public static int findParent(int[] parent, int i)
    {
        if(parent[i]==i)
        return i;

        return findParent(parent, parent[i]);
    }



    public static boolean isCyclic_UnionFind(ArrayList<ArrayList<Edge>> graph) //not working
    {
        int v= graph.size();
        int[] parent= new int[v];

        for(int i=0; i<v; i++)
        {
            parent[i]=i;
        }

        //making the edge list
        ArrayList<EdgePair> edgeList = giveEdgeList(graph);
    
        for(EdgePair ep:edgeList)
        {
            int p1= findParent(parent, ep.u);
            int p2= findParent(parent, ep.v);

            if(p1==p2){
                return true;
                
            }else{
                parent[ep.u]=ep.v;
            }

        }

        return false;
    }


    public static void kruskalMST(ArrayList<ArrayList<Edge>> graph)
    {

        int v= graph.size();
        
        int[] parent= new int[v];

        for(int i=0; i<v; i++)
        {
            parent[i]=i;
        }

       //making the edge list
       ArrayList<EdgePair> edgeList = giveEdgeList(graph);
       Collections.sort(edgeList);

        int count=0;
        int i=0;

        ArrayList<EdgePair> mst= new ArrayList<>();

        while(count<v-1)
        {
            EdgePair ep=edgeList.get(i++);

            int p1= findParent(parent, ep.u);
            int p2= findParent(parent, ep.v);

            if(p1!=p2)
            {
                mst.add(ep);
                count++;
                parent[ep.u]=ep.v;
            }

            // i++;


        }

        System.out.println("The Minimum spanning tree for this graph using Kruskal is");
        System.out.println("EDGE" +"    "+ "WEIGHT");


        for(EdgePair ep: mst)
        {
            System.out.println(ep.u+" -> "+ep.v+"   "+ ep.w);
        }

    }

    public static void main(String[] args) 
    {
        ArrayList<ArrayList<Edge>> graph= new ArrayList<>();

        Scanner s= new Scanner(System.in);

        System.out.println("Enter number of verices in graph-  ");

        int v=s.nextInt();

        for(int i=0; i<v; i++)
        {
            graph.add(i,new ArrayList<Edge>());
        }
        s.close();

        // traversals.addEdge(graph, 0, 1, 4);
        // traversals.addEdge(graph, 0, 7, 8);
        // traversals.addEdge(graph, 1, 2, 8);
        // traversals.addEdge(graph, 1, 7, 11);
        // traversals.addEdge(graph, 2, 3, 7);
        // traversals.addEdge(graph, 2, 8, 2);
        // traversals.addEdge(graph, 2, 5, 4);
        // traversals.addEdge(graph, 3, 4, 9);
        // traversals.addEdge(graph, 3, 5, 14);
        // traversals.addEdge(graph, 4, 5, 10);
        // traversals.addEdge(graph, 5, 6, 2);
        // traversals.addEdge(graph, 6, 7, 1);
        // traversals.addEdge(graph, 6, 8, 6);
        // traversals.addEdge(graph, 7, 8, 7);

        traversals.addEdge(graph, 0, 1, 10);
        traversals.addEdge(graph, 0, 2, 6);
        traversals.addEdge(graph, 0, 3, 5);
        traversals.addEdge(graph, 1, 3, 15);
        traversals.addEdge(graph, 2, 3, 4);


        // traversals.addEdge(graph, 0, 1, 1);
        // traversals.addEdge(graph, 1, 2, 1);
        // traversals.addEdge(graph, 2, 3, 1);
        // traversals.addEdge(graph, 3, 4, 1);
        // traversals.addEdge(graph, 4, 5, 1);
        // traversals.addEdge(graph, 5, 3, 1);


        PrimsBFS(graph);

        System.out.println();

        // System.out.println(isCyclic_UnionFind(graph));

        kruskalMST(graph);

        
    }



    
}
