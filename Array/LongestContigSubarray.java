package Array;

import java.util.HashSet;

public class LongestContigSubarray {


    static int findLength(int arr[])
    {
        int n = arr.length;
        int max_len = 1; // Initialize result
 
        // One by one fix the starting points
        for (int i=0; i<n-1; i++)
        {
            // Create an empty hash set and add i'th element
            // to it.
            HashSet<Integer> set = new HashSet<>();
            set.add(arr[i]);
 
            // Initialize max and min in current subarray
            int mn = arr[i], mx = arr[i];
 
            // One by one fix ending points
            for (int j=i+1; j<n; j++)
            {
                // If current element is already in hash set, then
                // this subarray cannot contain contiguous elements
                if (set.contains(arr[j]))
                    break;
 
                // Else add curremt element to hash set and update
                // min, max if required.
                set.add(arr[j]);
                mn = Math.min(mn, arr[j]);
                mx = Math.max(mx, arr[j]);
 
                // We have already checked for duplicates, now check
                // for other property and update max_len if needed
                if (mx-mn == j-i)
                    max_len = Math.max(max_len, mx-mn+1);
            }
        }
        return max_len; // Return result
    }
    
}
