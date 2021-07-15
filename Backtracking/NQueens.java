package Backtracking;

public class NQueens {

    //using combinations method
    public static void NQueensPrint(int cq, int tq, int lc, boolean[][] chess){

        if(cq==tq){

            for(int i=0; i<chess.length; i++){
                for(int j=0; j<chess.length; j++){
                    if(chess[i][j]){

                        System.out.print("Q");
                    }
                    else{
                        System.out.print("-");

                    }
                }

                System.out.println();
            }

            return;
        }



        for(int i=lc+1; i<chess.length*chess.length; i++)
        {
            int row=i/chess.length;
            int col=i%chess.length;

            if(chess[row][col]==false && isSafe(chess, row, col))
            {
                chess[row][col]=true;

                int cell= row*chess.length + col;

                NQueensPrint(cq+1, tq, cell, chess);

                chess[row][col]=false;
            }
            


        }

    }


     
    public static boolean isSafe(boolean[][] grid, int row, int col){
        //upper column
        for(int i=0; i<row; i++){
            if(grid[i][col])
                return false;
        }
        
        //upper left diagonal
        int left= Math.min(row, col);
        
        for(int i=1; i<=left; i++){
            if(grid[row-i][col-i])
                return false;
        }
        
        //upper right diagonal
        int right= Math.min(row, grid.length-1-col);
        
        for(int i=1; i<=right; i++)
        {
            if(grid[row-i][col+i])
                return false;
        }
        
        return true;
        
        
        
        
    }


    public static void main(String[] args) {
        boolean[][] chess= new boolean[4][4];
        NQueensPrint(1, 4, -1, chess);
    }


    
}
