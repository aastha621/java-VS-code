

public class sorting {

    public static void swap(int[] arr, int i, int j){

        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;

    }

    public static  int[] bubbleSort(int[] arr) //for ascending
    {
        /*
        number of swaps for an element= number of elements on right side which are smaller than it.
        Total swaps= sum of count of swaps for each element!
        */

        for(int i=0; i<arr.length-1; i++){
            for(int j=1; j<arr.length-i; j++)
            {
               if(arr[j-1]>arr[j])
               swap(arr, j-1, j);

            }

        }

        return arr;

    }

   public static int swaps=0;

    public static int[] insertionSort (int[] arr){


        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j>0; j--)
            {
                if(arr[j]<arr[j-1])
                {
                    swap(arr, j, j-1);
                    swaps++;
                }
            }

        }

        return arr;
    }

    public static int[] selectionSort(int[] arr)
    {

        for(int i=0; i<arr.length-1; i++){
            int minIndex=i;

            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[j]<arr[minIndex])
                {
                    minIndex=j;
                }

            }

            swap(arr, i, minIndex);
        }

        return arr;

    }




    public static void main(String[] args) {
        int[] arr= {3,1,4,2,9,5,6};

       int[] sorted= selectionSort(arr);

       for(int x:sorted){
           System.out.print(x+" ");
       }



    }


    
}
