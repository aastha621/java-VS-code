package DP;
import java.util.HashMap;

public class ArithmeticSlices {


    //(Q)Given an integer array nums, return the number of arithmetic subarrays of nums.


    public int numberOfArithmeticSlices(int[] nums) 
    {
        if(nums.length<3)
            return 0;
        
        int[] dp = new int[nums.length];
        dp[0]=0;
        dp[1]=0;        
        
        //every cell in dp donates the number of AP subarrays ending with that element
        
        for(int i=2; i<nums.length; i++){
            
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                dp[i]=dp[i-1]+1;
                
            }
            
        }
        
        int ans=0;
        
        
        for(int x:dp){
            ans+=x;
            
        }
        
        return ans;
    }



    //(Q)Given an integer array nums, return the number of all the arithmetic subsequences of nums.



    public int numberOfArithmeticSlices2(int[] nums) {
        
        HashMap<Integer, Integer> maps[]= new HashMap[nums.length];
        
        //every cell of this dp will store a hashmap which stores (cd->count)
        //that means count of AP subseq of length <=2 which end at that particular element
        
        for(int i=0; i<nums.length; i++){
            maps[i]= new HashMap<>();
        }
        
        int count=0;
        
        for(int i=1; i<nums.length; i++)
        {
            for(int j=0; j<i; j++){
                long cd=(long)nums[i]-(long)nums[j];
                
                //edge case-> when cd crosses int value
                
                if(cd>=Integer.MAX_VALUE || cd<=Integer.MIN_VALUE){
                    continue;
                }
                
                
                
                int ap_j= maps[j].getOrDefault((int)cd,0);
                int ap_i= maps[i].getOrDefault((int)cd,0);
                
                count+=ap_j; //if we find an AP of length>=3
                
                maps[i].put((int)cd, ap_j+ap_i+1);
            }
            
            
        }
        
        
        return count;
        
     
        
        
        
    }
    
}
