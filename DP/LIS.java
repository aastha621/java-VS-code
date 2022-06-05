package DP;

import java.util.LinkedList;
import java.util.Queue;

public class LIS {

    public static int LIS_dp(int[] arr){
        int n=arr.length;

        int[] dp= new int[n];

        dp[0]=1;

        int longest=0;

        for(int i=1; i<n; i++)
        {
            int max=0;

            for(int j=0; j<i; j++){

                if(arr[j]<arr[i] && dp[j]>max){
                    max=arr[j];
                }

            }

            dp[i]=max+1;

            if(dp[i]>longest){
                longest=dp[i];
            }

        }


        return longest;

    }


    public static int longest_bitonic(int[] arr){

        int n=arr.length;

        int[] dp1= new int[n];

        dp1[0]=1;

        for(int i=1; i<n; i++)
        {
            int max=0;

            for(int j=0; j<i; j++){

                if(arr[j]<arr[i] && arr[j]>max){
                    max=arr[j];
                }

            }

            dp1[i]=max+1;

        }

        int[] dp2=new int[n];
        dp2[n-1]=1;





        for(int i=n-2; i>=0; i--){

            int max=0;

            for(int j=n-1; j>i; j--){

                if(arr[j]>arr[i] && arr[i]>max){
                    max=arr[i];
                }
            }


            dp2[i]=max+1;

        }

        int ans=0;

        for(int i=0; i<n; i++){

            ans=Math.max(ans, dp1[i]+dp2[i]);

        }

        return ans;


        
    }

    public static class pair{
        int i; //index
        int val; //dp val
        String ans; //psf

        pair(int x, int y, String s){
            i=x;
            val=y;
            ans=s;

        }



    }


    public static void print_LIS(int[] arr){


        int n=arr.length;

        int[] dp= new int[n];

        dp[0]=1;
        int longest=0;
        int index=0;

        for(int i=1; i<n; i++)
        {
            int max=0;

            for(int j=0; j<i; j++){

                if(arr[j]<arr[i] && dp[j]>max){
                    max=dp[j];

                }

            }

            dp[i]=max+1;

            if(dp[i]>longest){
                longest=dp[i];
                index=i;
            }

        
        }

        

        // System.out.print(longest);



        Queue<pair> q= new LinkedList<>();

        pair p= new pair(index, dp[index], ""+arr[index]);
        q.add(p);

        while(!q.isEmpty())
        {
            pair rem=q.remove();

            int ele=arr[rem.i];
            int len=rem.val;
            String psf=rem.ans;

            if(len==1){
                System.out.println(psf);
            }

            for(int j=0; j<rem.i; j++){

                if(dp[j]==len-1 && arr[j]<ele){
                    pair g= new pair(j, dp[j], arr[j]+" "+psf);

                    q.add(g);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr= new int[]{3, 10, 2, 1, 20};

        print_LIS(arr);
    }






    
    
}
