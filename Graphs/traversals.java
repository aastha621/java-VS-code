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

        for(Edge edge: adjEdges){
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

   

    public static void main(String[] args) {

        // ArrayList<Edge>[] graph= new ArrayList [6]; this representation is giving errors

        // graph[0].add(new Edge(1, 2));

        // ArrayList<ArrayList<Edge>> graph= new ArrayList<>();

        for(int i=0; i<6; i++){
            graph.add(i,new ArrayList<Edge>());
        }


        addEdge(graph, 0, 1, 1);
        addEdge(graph, 1, 2, 1);
        addEdge(graph, 2, 3, 1);
        addEdge(graph, 3, 4, 1);
        addEdge(graph, 4, 5, 1);
        addEdge(graph, 5, 3, 1);
        

        boolean[] visited= new boolean[6];

        // System.out.println(hasPath(graph, 0, 2, visited));

        // DFS(0,visited);
        BFS(2, visited);

        // printAllPaths(0, 5, visited, 0+"");



        
        
        
        

        
    }

    

    


    
}
