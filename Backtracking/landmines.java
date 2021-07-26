package Backtracking;

import java.util.Arrays;

public class landmines {

    //(Q)Find shortest safe route in a path with landmines

    public static int min;

    public static void markUnsafe(int[][] mat)
    {
        int R=mat.length;
        int C=mat[0].length;

        for(int i = 0; i < R; i++)
        {
        for(int j = 0; j < C; j++)
        {
             
            // If a landmines is found
            if (mat[i][j] == 0)
            {
                for(int k=0; k<4; k++){

                    int x=i+xd[k];
                    int y=j+yd[k];

                    
                    if(x>=0 && y>=0 && x<mat.length && y<mat[0].length){
                        mat[x][y]=-1;
        
                    }
        
                }
                   
            }
        }
    }
 
    // Mark all found adjacent cells as unsafe
    for(int i = 0; i < R; i++)
    {
        for(int j = 0; j < C; j++)
        {
            if (mat[i][j] == -1)
                mat[i][j] = 0;
        }
    }


    }

    public static boolean isSafe(int[][] mat, boolean[][] visited,
                      int x, int y)
{
    if (mat[x][y] == 0 || visited[x][y])
        return false;
 
    return true;
}



    private static void findShortestPath(int[][] mat) {

        markUnsafe(mat);

        int dist=0;
        min=Integer.MAX_VALUE;

        int n=mat.length;
        int m=mat[0].length;

        boolean[][] vis= new boolean[n][m];

        for(int i=0; i<n; i++){
            if(mat[i][0]==1){

                for(int j=0; j<n; j++){
                    Arrays.fill(vis[j], false);

                }

                util(mat, i, 0, vis, dist);

                if(min==m-1)
                break;
            }

        }




    }

    public static int[] xd= new int[]{1, -1, 0, 0};
    public static int[] yd= new int[]{0, 0, 1, -1};


    public static void util(int[][] mat, int i, int j, boolean[][] vis, int dist)
    {
        if(dist<min){
            min=dist;
        }

        if(dist>min)
        return;

        vis[i][j] = true;

        for(int k=0; k<4; k++){

            int x=i+xd[k];
            int y=j+yd[k];

            if(x>=0 && y>=0 && x<mat.length && y<mat[0].length){
                if(isSafe(mat, vis, x, y)){
                    util(mat, x, y, vis, dist+1);
                }
            }

        }

        vis[i][j]=false;


    }

    public static void main(String[] args)
{
     
    // Input matrix with landmines shown with number 0
    int[][] mat = {
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
        { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };
 
    // Find shortest path
    findShortestPath(mat);
}

    
    
}
