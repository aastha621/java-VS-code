package Array;

public class reversePairs {

    //using mergesort

    public static int count=0;

    public static int giveReversePairs(int[] arr){

        mergeSort(arr, 0, arr.length-1);
        return count;

    }

   

    private static int[] mergeSort(int[] arr, int l, int r) {
        
        if(l==r){
            int[] narr= new int[1];
            narr[0]=arr[l];
            return narr;
        }
       
        int m=(l+r)/2;

       

        int[] left= mergeSort(arr, l, m);
        int [] right=mergeSort(arr, m+1, r);

        return merge(left, right);



        
    }



    private static int[] merge(int[] left, int[] right) {

        int[] ans= new int[left.length+right.length];

        int i=0;
        int j=0;
        int k=0;

        while(i<left.length && j<right.length){

            if(left[i]>2*right[j]){
                count+=left.length-i;
                ans[k++]=right[j++];

            } 
            
            else if(left[i]<right[j])
            {
                ans[k++]=left[i++];
            }
        }


        while(i<left.length){
            ans[k++]=left[i++];
        }

        while(j<right.length){
            ans[k++]=right[j++];
        }

        return ans;


    }
    
}
