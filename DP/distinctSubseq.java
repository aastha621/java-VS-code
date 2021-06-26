package DP;

import java.util.HashMap;

public class distinctSubseq {

    public static int countDistinctSubseq(String arr){
        int n=arr.length();

        int[] dp= new int[n+1];

        HashMap<Character, Integer> map= new HashMap<>();

        dp[0]=1;

        for(int i=1; i<=n; i++)
        {

            if(map.containsKey(arr.charAt(i-1)))
            {
                int index=map.get(arr.charAt(i-1));

                dp[i]=2*dp[i-1]-dp[index-1];
            }

            else{
                dp[i]=2*dp[i-1];

                map.put(arr.charAt(i-1), i);
            }


        }


        return dp[n];


    }
    
}
