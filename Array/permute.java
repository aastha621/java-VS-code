package Array;

public class permute {

    public static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    public static void permute_swap(int[] arr, int l, int r){

        if(l==r){
            for(int x:arr){
                System.out.print(x+" ");
            }
            System.out.println();


            return;
        }


        for(int i=l; i<=r; i++){
            swap(arr, l, i);

            permute_swap(arr, l+1,r);

            swap(arr, l, i);

        }



    }


    public static void main(String[] args) 
    {
        int[] arr= new int[]{1,2,3};

        permute_swap(arr, 0, arr.length-1);
        
    }
    
}
