package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class traversals {

    public static class Edge
    {
        int v;
        int w;

        Edge(int a, int b){
            v=a;
            w=b;
        }
        

    } 
    
    //A graph is collection of connected edges
    // static ArrayList<Edge>[] graph= new ArrayList<>[8];

    public static ArrayList<ArrayList<Edge>> graph= new ArrayList<>();


    public static void addEdge(ArrayList<ArrayList<Edge>> graph, int u, int v, int w) 
    {
        graph.get(u).add( new Edge(v, w));
        graph.get(v).add( new Edge(u, w));
    }

    public static boolean hasPath(ArrayList<ArrayList<Edge>> gr, int src, int des, boolean[] visited)
    {
        if(src==des)return true;

        ArrayList<Edge> adjEdges= gr.get(src);
        visited[src]=true;

        for(Edge edge: adjEdges)
        {
            int nbr=edge.v;

            if(!visited[nbr]){
                boolean nbrPath=hasPath(gr, nbr, des, visited);

                if(nbrPath)return true;
            }

        }

        return false;

    }



    public static void DFS(int src, boolean[] vis)
    //time complexity-> O(V+E)
    //space complexity-> O(V) {for visited boolean array}
    {
        System.out.print(src+" ");

        vis[src]=true;

        ArrayList<Edge> nbrs= graph.get(src);

        for(Edge e: nbrs)
        {
            int nbr= e.v;

            if(!vis[nbr])
            {
                DFS(nbr, vis);
            }
        }

    }

    public static void BFS(int src, boolean[] vis){
        
        Queue<Integer> qu= new LinkedList<Integer>();

        qu.add(src);
        vis[src]=true;

        while(!qu.isEmpty())
        {
            int e=qu.poll();
            System.out.print(e+" ");

            ArrayList<Edge> adj= graph.get(e);

            for(Edge ed:adj){
                int nbr=ed.v;

                if(!vis[nbr])
                {   vis[nbr]=true;
                    qu.add(nbr);
                }
            }

        }


    }


    public static void printAllPaths(int src, int des, boolean[] vis, String psf) //time complexity?
    {
        if(src==des)
        {
            System.out.println(psf);
            return;
        }

        vis[src]=true;
        
        ArrayList<Edge> adj = graph.get(src);

        for(Edge e:adj)
        {
            int nbr=e.v;

            if(!vis[nbr])
            {
                printAllPaths(nbr, des, vis, psf+nbr);
            }
        }

        vis[src]=false;



    }


    public static void dijsktra(ArrayList<ArrayList<Edge>> graph)
    {

        int v=graph.size();
        boolean[] vis= new boolean[v];
        int[] dist= new int[v];

        dist[0]=0;

        for(int i=1; i<v; i++)
        {
            dist[i]=Integer.MAX_VALUE;
        }



        for(int i=0; i<v-1; i++)
        {

            int src= findMinimumDistanceNode(dist, vis);

            vis[src]=true;

            ArrayList<Edge> nbrs=graph.get(src);

            for(Edge e:nbrs)
            {
                int nbr=e.v;
                int wt=e.w;

                if(vis[nbr])continue;

                if(dist[nbr]>dist[src]+wt && dist[src]!=Integer.MAX_VALUE) 
                //why do we check for max value here
                dist[nbr]=dist[src]+wt;

            }
            
        }


        //print
        for(int i=0; i<v; i++){
            System.out.println(i+"  "+dist[i]);
        }


    }
    

   

    private static int findMinimumDistanceNode(int[] dist, boolean[] vis) {

        int minIndex=-1;

        for(int i=0; i<dist.length; i++){
            if(!vis[i] && (minIndex==-1 || dist[i]<dist[minIndex]))
            {
                minIndex=i;
            }

        }
        return  minIndex;
    }

    public static void main(String[] args) {

        // ArrayList<Edge>[] graph= new ArrayList [6]; this representation is giving errors

        // graph[0].add(new Edge(1, 2));

        // ArrayList<ArrayList<Edge>> graph= new ArrayList<>();

        for(int i=0; i<5; i++){
            graph.add(i,new ArrayList<Edge>());
        }


        addEdge(graph, 0, 1, 4);
        addEdge(graph, 0, 2, 8);
        addEdge(graph, 1, 3, 5);
        addEdge(graph, 1, 2, 2);
        addEdge(graph, 2, 3, 5);
        addEdge(graph, 2, 4, 9);
        addEdge(graph, 3, 4, 4);

        

        //boolean[] visited= new boolean[6];

        // System.out.println(hasPath(graph, 0, 2, visited));

        // DFS(0,visited);
        // BFS(2, visited);

        // printAllPaths(0, 5, visited, 0+"");

        dijsktra(graph);
    }

    

    


    
}
