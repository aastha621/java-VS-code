package DP;

public class smallestSubSum {


    public static int smallestSubarraySum(int[] arr){
        int min=Integer.MAX_VALUE;
        int curr=0;


        for(int i=0; i<arr.length; i++)
        {

            if(curr>0) //if we include this ele and the sum>0, then it is better to start a new subarray 
                curr=arr[i];
            
            else curr+=arr[i]; 


            min=Math.min(min, curr);

        }



        return min;
    }


    public static int largestSubarraySum(int[] arr){
        int max=Integer.MIN_VALUE;
        int curr=0;


        for(int i=0; i<arr.length; i++)
        {
            curr+=arr[i];

            if(curr>max)
            max=curr; 
            
            if(curr<0)
            curr=0;
        }



        return max;
    }




    
}
