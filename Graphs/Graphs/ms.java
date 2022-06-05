package Graphs.Graphs;

public class ms {

    public static int dis;


    public static void dfs(char[][] grid, int i, int j, int len){

        if( i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='W' || grid[i][j]=='v' )
        return;

        if(grid[i][j]=='O')
        len++;
        
        if(grid[i][j]=='G')
       {
           if(len<dis)
           dis=len;
           
           return;
       }
        
        

        grid[i][j]='v';

        dfs(grid, i-1, j, len);
        dfs(grid, i+1, j, len);
        dfs(grid, i, j-1, len);
        dfs(grid, i, j+1, len);

        grid[i][j]='O';
        len=0;

        


        // return Math.min(Math.min(left, right), Math.min(up, down));




    }


    public static int[][] minD(char[][] grid){
        dis=1000000;

        int[][] ans= new int[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                if(grid[i][j]=='O'){
                    dfs(grid, i, j, 0 );

                    ans[i][j]=dis;

                    dis=100000;
                }

                else if(grid[i][j]=='W'){
                   ans[i][j]=-1;
                }

                else
                ans[i][j]=0;
            }
        }

        return ans;
    }


    public static void main(String[] args) 
    {
        char[][] g= {{'O', 'O', 'O', 'O'},
                    {'W', 'O', 'O', 'G'},
                    {'O', 'O', 'G', 'O'}};

        int[][] a= minD(g);

        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){

                System.out.print(a[i][j]+ " ");

              
            }

            System.out.println();
        }



        
    }


    
}
