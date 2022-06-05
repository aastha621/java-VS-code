package Recursion;
import java.util.*;

public class RatInMaze {
    //rat in a maze with obstacles, give all paths
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        // Write your code here.
        
        ArrayList<ArrayList<Integer>> answers= new ArrayList<>();
        
        int[][] ans= new int[n][n];
        
        helper(maze, ans, 0, 0, answers);
        
        return answers;
        
        
        
        
    }
    
    public static void helper(int[][] m, int[][] a, int r, int c, ArrayList<ArrayList<Integer>> answers){
       
        if(r==m.length-1 && c==m.length-1)
        {
            a[r][c]=1;
            ArrayList<Integer> arr= new ArrayList<>();
            
            for(int i=0; i<m.length; i++){
                for(int j=0; j<m.length; j++){
                    arr.add(a[i][j]);
                    
                }
            }
            
            answers.add(arr);
            a[r][c]=0;
            return;
            
         }
        
         if(r<0 || c<0 ||r>=m.length || c>=m.length)
            return;
        
        if(m[r][c]==0 || a[r][c]==1)
            return;
        
        a[r][c]=1;
        
        
        
        
        //left
        
        helper(m, a, r, c-1, answers);
       
        //right
       
        helper(m, a, r, c+1, answers);
        
        //up
        
        helper(m, a, r-1, c, answers);
      
        //down
       
         helper(m, a, r+1, c, answers);
        
        
        a[r][c]=0;
       
        
        
        
        
    }
    
}
