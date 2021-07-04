package DP;

public class maxRodSeg {

    //Function to find the maximum number of cuts.
    //    public static int maximizeCuts(int n, int x, int y, int z)
    //    {
           
    //        int[] dp = new int[n+1];
           
    //        int[] cuts=new int[]{x,y,z};
           
    //        Arrays.sort(cuts);
           
    //     //each cell of dp represents the max cuts for length i
           
    //     for (int i = 1; i < n + 1; i++)
    //     dp[i] = -1;
        

    //     dp[0]=0;

    //        for(int j:cuts)
    //        {
    //                for(int i=0; i<=n; i++)
    //                {
                       
    //                if(i-j>=0)
    //                {
    //                    if(dp[i-j]>dp[i])

    //                    dp[i]= 1+dp[i-j];
    //                }
                   
                   
                   
    //                }
                   
    //        }
               
               
    //        return dp[n];
                   
                   
                   
    //    }


    public static int maximizeCuts(int l, int p, int q, int r)
    { // Array to store the
        // cut at each length
        int dp[] = new int[l + 1];
 
        // All values with -1
        for (int i = 0; i < l + 1; i++)
            dp[i] = -1;
 
        // if length of rod is 0
        // then total cuts will
        // be 0 so, initialize
        // the dp[0] with 0
        dp[0] = 0;
 
        for (int i = 0; i <= l; i++) {
 
            // if certain length
            // is not possible
            if (dp[i] == -1)
                continue;
 
            // if a segment of
            // p is possible
            if (i + p <= l)
                dp[i + p] = Math.max(dp[i + p], dp[i] + 1);
 
            // if a segment of
            // q is possible
            if (i + q <= l)
                dp[i + q] = Math.max(dp[i + q], dp[i] + 1);
 
            // if a segment of
            // r is possible
            if (i + r <= l)
                dp[i + r] = Math.max(dp[i + r], dp[i] + 1);
        }
 
        // if no segment can be cut then return 0
        if (dp[l] == -1) {
            dp[l] = 0;
        }
        // return value corresponding
        // to length l
        return dp[l];
                
    }


    //(Q) To find max profit by cutting rod into segments

    public static void maxProfitRodCut(int[] price, int len)
    {

        //method 1: cut combination method
        int[] dp= new int[len+1];

        dp[0]=0;

        //each cell represents the max profit that can be gained if the length of rod was i units.

        for(int i=1; i<=len; i++){

            dp[i]=price[i-1];


            for(int j=1; j<=i; j++)
            {
                if(price[j-1]+dp[i-j]>dp[i]){
                    dp[i]=price[j-1]+dp[i-j];

                }



            }
        }


        System.out.println("By cut combination method, max profit:"+ dp[len]);


        //method 2: two parts method

        //here we divide the rod into 2 parts and then check which combination gives maximum profit
        //for eg: for length 5:
        // we choose between: 5, 1+4, 2+3-> whichever gives the max profit


        int[] dp2= new int[len+1];

        dp[0]=0;

        for(int i=1; i<=len; i++){

            dp2[i]=price[i-1]; //if we consider the entire rod of length i

            int left=1; 
            int right=i-1;


            while(left<=right){

                if(dp2[left]+dp2[right]>dp2[i])
                dp2[i]=dp2[left]+dp2[right];

                left++;
                right--;

            }
        }


        System.out.println("By 2 parts method, max profit:"+ dp2[len]);
    
    }


       public static void main(String[] args) {

        // int x= maximizeCuts(4, 2, 1, 1);

        // System.out.println(x);


        int[] prices= new int[]{1,5,8,9,10,17,17,20};

        maxProfitRodCut(prices, 8);
           
       }
    
}
