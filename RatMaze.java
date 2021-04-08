import java.util.ArrayList;

public class RatMaze {

    public static ArrayList<String> paths= new ArrayList<>();
    
    public static ArrayList<String> findPath(int[][] m, int n) 
    {
         
         String ans="";
         
         paths.clear();
         
         helper(m, n, 0, 0, ans);
          
         // Collections.sort(paths);
          
          return paths;
     }
     
     public static void helper(int[][] m,int n, int row, int col, String ans){
         
         if(row==n-1 && col==n-1)
         {
             if(!paths.contains(ans))
             {paths.add(ans);}
             
             
             
             return;
         }
         
         m[row][col]=0;
         
         //down
         if(row+1<n && m[row+1][col]!=0)
         helper(m, n, row+1, col, ans+"D");
         
         //left
         if(col-1>=0 && m[row][col-1]!=0)
         helper(m, n, row, col-1, ans+"L");
         
         //right
         if(col+1<n && m[row][col+1]!=0)
         helper(m, n, row, col+1, ans+"R");
         
         
         //up
         if(row-1>=0 && m[row-1][col]!=0)
         helper(m, n, row-1, col, ans+"U");
         
         
         m[row][col]=1;
         
         return;
         
         
         
     }

    public static void main(String[] args) {

        int m[][] = { { 1, 0, 0, 0, 0 },
                  { 1, 1, 1, 1, 1 },
                  { 1, 1, 1, 0, 1 },
                  { 0, 0, 0, 0, 1 },
                  { 0, 0, 0, 0, 1 } };
    int n = m.length;
    
    ArrayList<String> ans= findPath(m, n);

    for(String s:ans){
        System.out.println(s);
    }
        
    }
    
}
