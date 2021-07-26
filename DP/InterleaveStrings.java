package DP;

public class InterleaveStrings {

    public static boolean interleaveStringsTabulation(String s1, String s2, String s3){

        int n=s1.length();
        int m= s2.length();

        boolean[][] dp = new boolean[n][m];

        //each cell of dp represents whether s1(0->i-1) & s2(0->j-1) can interleave to form s3(0-> i+j-1)

        //s1 will be on the rows
        //s2 will be on the columns

        //A="a abc"
        //B="d bbca"
        //C="aa dbbcbcac"

        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){

                //handling edge cases

                if(i==0 && j==0)
                dp[i][j]=true;

                int k=i+j-1;

                if(i==0){
                    
                    dp[i][j]= s3.charAt(k)==s2.charAt(j-1)?dp[i][j-1]:false;

                }
                if(j==0){

                    dp[i][j]=s3.charAt(k)==s1.charAt(i-1)?dp[i-1][j]:false;
                }


                if(s3.charAt(k)==s1.charAt(i-1)){
                    //exclude the last char of s1 and check if s1 & s2 can interleave to form s3
                    dp[i][j]=dp[i-1][j];
                }

                else if(s3.charAt(k)==s2.charAt(j-1)){
                    //exclude the last char of s2 and check if s1 & s2 can interleave to form s3
                    dp[i][j]=dp[i][j-1];
                }




            }

        }




        return dp[n][m];

    }


    
}
