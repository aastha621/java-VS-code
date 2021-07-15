package DP;

public class editDistance {

    //insert: m, n-1
    //remove: m-1, n
    //replace: m-1, n-1



    public static int editD_recursive(String a, String b, int i, int j){

        if(i==a.length() && j==b.length())return 0;

        if(i==a.length()) //if a gets empty, to make it equal we must add all remaining chars in b
        return b.length()-j;


        if(j==b.length()) //if b becomes empty, to make equal all the remaining chars in a must be removed
        return a.length()-i;
        
        if(a.charAt(i)==b.charAt(j))
        return editD_recursive(a, b, i+1, j+1);


        int insert = editD_recursive(a, b, i, j+1);
        int remove = editD_recursive(a, b, i+1, j);
        int replace = editD_recursive(a, b, i+1, j+1);


        return Math.min(insert, Math.min(remove, replace));



    }


    public static int editDistance_DP(String str1, String str2) 
    {
        int m=str1.length();
        int n=str2.length();
        
        
        
         // Create a table to store results of subproblems
        int dp[][] = new int[m + 1][n + 1];

        // Fill d[][] in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                
                // If first string is empty, only option is
                // to insert all characters of second string
                if (i == 0)
                    dp[i][j] = j; // Min. operations = j

                // If second string is empty, only option is
                // to remove all characters of second string
                else if (j == 0)
                    dp[i][j] = i; // Min. operations = i

                // If last characters are same, ignore last
                // char and recur for remaining string
                else if (str1.charAt(i - 1)
                         == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                // If the last character is different,
                // consider all possibilities and find the
                // minimum
                else
                    dp[i][j] = 1
                               + Math.min(dp[i][j - 1], 
                               
                               // Insert
                               
                               Math.min( dp[i - 1][j], // Remove
                                     dp[i - 1]
                                       [j - 1])
                                    ); // Replace
            }
        }

        return dp[m][n];
        // Code here
    }



    


    
}
