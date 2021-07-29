package DP;

public class BurstBalloons {


    public int maxCoins(int[] nums) {
        
        int n=nums.length;
        
        int[][] dp= new int[n][n];
        
        for(int g=0; g<n; g++)
        {
            for(int i=0, j=g; j<n && i<n; j++, i++){
                
                int max=Integer.MIN_VALUE;
                
                for(int k=i; k<=j; k++){
                    
                    int left= i==k? 0: dp[i][k-1];
                    int right= j==k? 0: dp[k+1][j];
                    
                    int val= nums[k]*(i==0?1:nums[i-1])*(j==n-1? 1:nums[j+1]);
                    
                    int total=left+val+right;
                    
                    max=Math.max(max, total);
                    
                    
                }
                
                
                dp[i][j]=max;
                
                
            }
        }
        
        
        return dp[0][n-1];
        
    
        
                



        
        
    }
    
}
