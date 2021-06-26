package DP;

public class LCS {

    public static int LCS_recursive(String x, String y, int n, int m){

        if(m==0 || n==0){
            return 0;
        }
        
        if(x.charAt(n-1)==y.charAt(m-1))
        return 1+LCS_recursive(x, y, n-1, m-1);

        else{
            return Math.max(LCS_recursive(x, y, n-1, m), LCS_recursive(x, y, n, m-1));
        }
    }


    //memoization->converting recursion to dp

    public static int LCS_memo(String x, String y, int n, int m, int[][] dp)
    {

        if(m==0 || n==0){
            return 0;
        }

        if(dp[n][m]!=0)
        return dp[n][m];

        if(x.charAt(n-1)==y.charAt(m-1))
        dp[n][m]= 1+LCS_recursive(x, y, n-1, m-1);

        else{
            dp[n][m]= Math.max(LCS_recursive(x, y, n-1, m), LCS_recursive(x, y, n, m-1));
        }




        return dp[n][m];
    }


    public static String printLCS(String x, String y, int m, int n, int[][] dp){

        int i=m;
        int j=n;

        StringBuilder sb= new StringBuilder();

        while(i>0 && j>0){

            if(x.charAt(i-1)==y.charAt(j-1))
            {
                sb.append(x.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }
                else{
                    j--;
                }
            }
        }

        sb.reverse();

        String ans= sb.toString();

        return ans;



        
    }


    public static void main(String[] args) {

        String x = "AGGTAB";
        String y = "GXTXAYB";
        int m = x.length();
        int n = y.length();

        int dp[][] = new int[m+1][n+1];

        int num=LCS_memo(x, y, m, n, dp);

        String ans= printLCS(x, y, m, n, dp);

        System.out.print(num);
        System.out.print(ans);
        
    }



    
}
