package DP;

public class LRS {

    //longest repeating subsequence
    //the idea is to find lcs of the string with the string itself, and while checking the equality of characters, 
    //ensure that their index is not same.

    public int LRS_tabulation(String x)
    {
        int n=x.length();

        int[][] dp= new int[n+1][n+1];


        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){

                if(i==0&& j==0){
                    dp[i][j]=0;
                }else if(i==0){
                    dp[i][j]=0;
                }
                else if(j==0){
                    dp[i][j]=0;
                }else{

                    if(x.charAt(i-1)==x.charAt(j-1) && i!=j){
                        dp[i][j]=1+ dp[i-1][j-1];
                    }
                    else{
                        dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);

                    }
                }
            }
        }


        return dp[n][n];



    }


    
}
