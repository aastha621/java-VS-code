package Array;

public class kadanes {

    int maxSubarraySum(int arr[], int n){
        
        int curr_sum=0;
        
        int max=Integer.MIN_VALUE;
        
        
        for(int i=0; i<n; i++){
            
            curr_sum+= arr[i];
            
            if(max<curr_sum){
                max=curr_sum;
            }
            
            
            if(curr_sum<0)
            {
                curr_sum=0;
            }
            
            
        }
        
        
        return max;
    } 
    
}
