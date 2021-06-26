package DP;

public class largestSquare1 {

    static int maxSquare(int n, int m, int mat[][])
    {

        int[][] dp =new int[n][m];

        //each cell represents the side of the largest square that can be formed if each cell
        //was the bottom right corner of the square submatrix
        
        int ans=-1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m ;j++)
            {
                if(i==0)
                dp[i][j]=mat[i][j];

                else if(j==0)
                dp[i][j]=mat[i][j];

                else if(mat[i][j]==1) {

                    dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                }


                ans=Math.max(ans, dp[i][j]);



            }


        }


        return dp[n][m];


        
    }
    
}
