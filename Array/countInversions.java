package Array;


public class countInversions {

    //using mergesort

    public static int count=0;

    public static int simpleCount(int[] a){
        int cnt=0;

        for(int i=0; i<a.length; i++){
            for(int j=i+1; j<a.length; j++){
                if(a[j]<a[i])
                cnt++;
            }
        }

        return cnt;
    }

    public static int giveInversions(int[] arr){

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
            if(left[i]<right[j]){
                ans[k++]=left[i++];
            }

            else{
                count+=left.length-i;
                ans[k++]=right[j++];

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

    public static void main(String[] args) {
        int[] arr= {2, 4, 1, 3, 5};
        int[] b=new int[-5];

        System.out.print(giveInversions(arr));
    }


    
}
