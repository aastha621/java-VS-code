public class coinChange {

    public static int CoinChangeRec(int[] denom, int m, int sum){

        if(sum==0) //we found one way
        return 1;

        if(sum<0) //galat raasta, yeh waala coin nahi choose karna tha, iski value zyada hai
        return 0;

        if(sum>0 && m<=0) //galat raasta, yeh coin choose karke bhi sum poora nahi ho paya
        return 0;

        return CoinChangeRec(denom, m, sum-denom[m-1]) + CoinChangeRec(denom, m-1, sum);
    }


    public static void CoinChangeDP(int[] denom, int m, int sum)
    {

        int[] dp= new int[sum+1];
        dp[0]=1;

        //for combination, we will see effect of one denomination at a time on entire array

        for(int i=0; i<denom.length; i++){

            for(int j=denom[i]; j<dp.length; j++){
                dp[j]+=dp[j-denom[i]];
            }
        }

        System.out.println("Total ways for Coin Change combination are->  " +dp[sum] );



        int[] dp1= new int[sum+1];
        dp1[0]=1;

        //for permutation, we will see effect of all denominations on each cell

        for(int i=0; i<dp1.length; i++){
            for(int j=0; j<denom.length; j++){

                if(denom[j]<=i){
                    dp1[i]+=dp1[i-denom[j]];
                }

            }
        }


        System.out.println("Total ways for Coin Change permutations are->  " +dp1[sum] );
    }




    public static void main(String[] args) 
    {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        int n = 4;
        System.out.println(CoinChangeRec(arr, m, n));
        CoinChangeDP(arr, m, n);
    }
    
}
