package DP;

public class catalan {

    public static int catalanDP(int n)
    {
        int[] dp= new int[n+1];

        dp[0]=1;

        for(int i=1; i<n+1; i++)
        {
            for(int j=0; j<i; j++)
            {
                dp[i]+=dp[j]*dp[i-j-1];

            }
        }


        return dp[n];
    }

    public static void main(String[] args) 
    {

        System.out.println(catalanDP(7));

        
    }
    
}
