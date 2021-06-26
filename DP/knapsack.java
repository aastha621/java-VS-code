package DP;

public class knapsack {

    public static int knapSack(int W, int wt[], int val[], int n) 
    { 
        if(n==0 || W<0 )return 0;
        
        if(wt[n-1]>W)
        return knapSack(W, wt, val, n-1);
        
        int include= val[n-1]+knapSack(W-wt[n-1], wt, val, n-1);
        int exclude= knapSack(W, wt, val, n-1);
        
        
        return Math.max(include, exclude);
         
         
        
    } 


    static int knapSackDP(int W, int wt[], int val[], int n) 
    { 



        int[][] dp= new int[n+1][W+1];

        //each cell represents the max val items till i can make given the max wt limit is j

        dp[0][0]=0;

        for(int i=0; i<=n ;i++){
            for(int j=0; j<=W; j++){

                if(i==0)
                dp[i][j]=0;
                else if(j==0)
                dp[i][j]=0;

                else if(wt[i-1]<=j){
                    int include=dp[i-1][j-wt[i-1]];
                    int exclude= dp[i-1][j];

                    dp[i][j]=Math.max(include, exclude);

                }

                else{
                    dp[i][j]=dp[i-1][j];
                }



            }

        }

        return dp[n][W];
       
         
         
        
    } 




    
    
}
