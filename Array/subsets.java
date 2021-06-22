package Array;

import java.util.ArrayList;
import java.util.List;

public class subsets {

    public List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subset(int[] nums)
    {
        ArrayList<Integer> ans= new ArrayList<>();
        
        subset_helper(nums, ans,0);
        
        return result;
        
        
        
    }
      
   
    
    
     public void subset_helper(int[] nums, ArrayList<Integer> arr, int i)    {
         
         if(i==nums.length)
         {
             result.add(new ArrayList<Integer>(arr));
             return;
             
         }
         
         //exclude  
         subset_helper(nums, new ArrayList<>(arr), i+1); 
         
         //include
         arr.add(nums[i]);
         subset_helper(nums, new ArrayList<>(arr), i+1);
         
         
        }



    
}
