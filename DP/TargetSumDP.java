package DP;

public class TargetSumDP {

    public boolean targetSumSubsets(int[] arr, int target){

        int size=arr.length;

        boolean[][] dp= new boolean[size+1][target+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++)
            {

                if(i==0&&j==0) dp[i][j]=true;
                else if(i==0) dp[i][j]=false;
                else if(j==0) dp[i][j]=true; 
                
                else{
                     if(arr[i-1]>=j)
                     {
                         //check if it is possible to make sum either by including or not including element
                        dp[i][j]= dp[i-1][j] || dp[i-1][j-arr[i-1]];
                     }
                     
                    else
                    dp[i][j]=dp[i-1][j];


                }
            
            }
        }
    
    
            return dp[size][target];

    }

    public static void main(String[] args) {
        
    }
    
}
