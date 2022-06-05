package Array;

public class microQ2 {
    public int solution(int[] arr, int k, int l) {
        // write your code in Java SE 8

        int len=arr.length;

        if(k+l>len)return -1;

        int max=Integer.MIN_VALUE;
        int sumk=0;
        int suml=0;

        int[] prefixSum=prefix(arr);

        for(int i=0; i+k-1<len-l; i++)
        {
            //  sumk=rangeSum(arr, i, i+k);

            sumk=prefixSum[i+k-1]-prefixSum[i-1];

            for(int j=i+1; j+l-1<len; j++){

                // suml=rangeSum(arr, j, j+l); 

                suml=prefixSum[j+l-1]-prefixSum[j-1];


            }

            max=Math.max(max, sumk+suml);
        }


        return max;

        
    }

    public int[] prefix(int[] arr){
        int[] p= new int[arr.length];
        p[0]=arr[0];

        for(int i=1; i<arr.length; i++){
            p[i]=p[i-1]+arr[i];

        }
        return p;
    }

    public int rangeSum(int[] a, int l, int r){
        int sum=0;

        for(int i=l; i<r; i++){
            sum+=a[i];
        }

        return sum;

    }

    
    
}
