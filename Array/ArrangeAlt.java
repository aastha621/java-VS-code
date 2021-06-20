package Array;

public class ArrangeAlt {

    //Q)Arrange positive and negative alternatively by maintaining the order in O(1)

    public static void rotateRight(int[] arr, int from, int to){
        int temp=arr[to];

        for(int i=to; i>from; i--){
            arr[i]=arr[i-1];
        }

        arr[from]=temp;
    }

    public static void ReArrange(int[] arr){
        int wrong=-1;

        for(int i=0; i<arr.length; i++)
        {

            if(wrong>=0){

                if((arr[wrong]>=0 && arr[i]<0) || (arr[wrong]<0 && arr[i]>0))

                {
                    rotateRight(arr, wrong, i);

                    if(i-wrong>=2)
                    wrong+=2;

                    else wrong=-1;
                }
                
                
            }


            if(wrong==-1)
            {
               if ((arr[i]>=0 && i%2==0) || (arr[i]<0 && i%2==1))
                wrong=i;

            }
        }
    }


    public static void rightrotate(int arr[], int n, int outofplace,
                     int cur)
    {
        int tmp = arr[cur];
        for (int i = cur; i > outofplace; i--)
            arr[i] = arr[i - 1];
        arr[outofplace] = tmp;
    }
 
    public static void rearrange(int arr[], int n)
    {
        int outofplace = -1;
 
        for (int index = 0; index < n; index++)
        {
            if (outofplace >= 0)
            {
                
                if ((arr[index] >= 0
                     && arr[outofplace] < 0)
                    || (arr[index] < 0
                        && arr[outofplace] >= 0)) 
                        {
                    rightrotate(arr, n, outofplace, index);
 
                    // the new out-of-place entry is now 2
                    // steps ahead
                    if (index - outofplace >= 2)
                        outofplace = outofplace + 2;
                    else
                        outofplace = -1;
                }
            }
 
            // if no entry has been flagged out-of-place
            if (outofplace == -1)
            {
                // check if current entry is out-of-place
                if ((arr[index] >= 0 && index %2 == 0)  || (arr[index] < 0 && index%2 == 1))
                    outofplace = index;
            }
        }
    }



    public static void main(String[] args) 
    {
        int[] arr= new int[]{ 1, 2, 3, -4, -1, 4};

        ReArrange(arr);

        // rearrange(arr, 6);

        

        for(int x:arr)
        System.out.print(x+" ");
    }


    
}
