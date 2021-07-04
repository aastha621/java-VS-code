package Array;

public class searchRotated {


    public static int searchRotated1 (int[] arr, int target){

        //we use binary search and for using that we need to find which subarray is strictly increasing

        int lo=0; 
        int hi=arr.length;

        while(lo<=hi){

            int mid= lo+(hi-lo)/2;

            if(arr[mid]==target)
            return mid;

            else if(arr[mid]>arr[lo]) //left subarray is sorted
            {
                if(target>=arr[lo] && target<=arr[mid])
                {
                    hi=mid-1;
                } //target falls in left subarray
                else
                {
                    lo=mid+1; //target does not fall un left subarray, look for a sorted subarray in right half
                }



            }


            else if(arr[mid]<arr[hi]) //right subarray is sorted
            {
                if(target>=arr[mid] && target<=arr[hi]) //target falls in right subarray
                {
                   lo=mid+1;
                }
                else //target does not fall un left subarray, look for a sorted subarray in right half
                {
                    hi=mid-1; 
                }
            }
        }


        return -1;
    }



    public static boolean searchRotated2 (int[] nums, int target){

        int left = 0;
        int right = nums.length-1;
        
        
        
        while(right>0 && nums[left]==nums[right])
            {
                --right;
            } 
            
        
        while(left <= right){
            
           
            int mid = (left+right)/2;
            
            
            
            if(nums[mid] == target){
                return true;
            }
            
            else if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target <nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            
            else{
                
                if(target> nums[mid] && target<= nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
                
            }
            
        }  
        return false;
        
        
    }
    






    
}
