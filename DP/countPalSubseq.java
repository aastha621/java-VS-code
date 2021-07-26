package DP;

public class countPalSubseq {

    //GAP METHOD V IMP 

    public static int palindromicSubseq(String s)
    {

        int n=s.length();

        int[][] dp= new int[n][n];

        for(int g=0; g<n; g++){
            for(int i=0, j=g; j<n && i<n; j++, i++) 
            //this loop will traverse thru diagonals 
            //g=0 -> first diagonal, g->1 second and so on...
            {

                if(g==0)
                dp[i][j]=1;

                if(g==1) //substr of length 2
                {
                    dp[i][j]= (s.charAt(i)==s.charAt(j))? 3:2;
                }

                else{

                    if(s.charAt(i)==s.charAt(j))
                    {
                        dp[i][j]=dp[i+1][j]+dp[i][j-1]+1;

                    }
                    else{
                        dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];

                    }
                }

            }
        }


        return dp[0][s.length()-1];
    }







    
}
