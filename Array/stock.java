package Array;

public class stock {

    public static int oneTransaction_maxProfit(int[] price)
    {

        int n=price.length;
        int curr_min=Integer.MAX_VALUE;
        int profit=0;
        
       for(int i=0; i<n; i++){
           if(price[i]<curr_min){
               curr_min=price[i];
           }
           
           
           profit=Math.max(profit, price[i]-curr_min);
           
       }
        
        return profit;
        


    }


    public int two_transaction_maxProfit(int[] price)
    {
        int n=price.length;
        
        
        //consider every point a sell point
        int[] dpl=new int[n];
        
        int least=price[0];
        
        int profit=0;
        
        for(int i=1; i<n; i++){
            if(price[i]<least){
                least=price[i];
            }
            
            profit=price[i]-least;
            
            if(dpl[i-1]<profit){
                dpl[i]=profit;
            }else{
                dpl[i]=dpl[i-1];
                
            }
            
            
            
        }
        
        //consider every point a buy point
        int[] dpr= new int[n];
        
        int max_so_far=price[n-1];
        
        int profit2= 0;
        
        for(int i=n-2; i>=0; i--){
            if(max_so_far<price[i]){
                max_so_far=price[i];
            }
            
            profit2=max_so_far-price[i];
            
            if(dpr[i+1]<profit2){
                dpr[i]=profit2;
                
            }
            else{
                dpr[i]=dpr[i+1];
                
                
            }
            
            
            
        }
        
        int ans=0;
        
        //dpl[i]+dpr[i] will store the profit- with one transaction on the left side and one on the right, so max value of dpl[i]+dpr[i] will be the answer
        for(int i=0; i<n; i++){
            
            ans=Math.max(ans, dpr[i]+dpl[i] );
            
        }
        
        return ans;
        
        
        
    }


    public static int buy_sell_stock_infinite(int[] arr){
        int profit=0;
        int sell=0;
        int buy=0;


        for(int i=1; i<arr.length; i++){
            //accumulate profit over every upstroke
            if(arr[i]>=arr[i-1]){
                sell++;
            }

            //on reaching the peak, sell and then move the sell and buy days to the starting point of next upstroke
            else{
                profit+=arr[sell]-arr[buy];

                //sell and buy will keep incrementing until they reach the starting point of next upstroke
                sell=buy=i;
            }
            

        }


        //to handle the last upstroke
        profit+=arr[sell]-arr[buy];



        return profit;
    }


    public static int buySellStock_fees(int[] arr, int fee){

        int obuy=-arr[0];
        int osell=0;

        //here sell state is like our cash for buy state.


        for(int i=1; i<arr.length; i++){
            int nbuy=0;
            int nsell=0;

            //sell
            if(obuy+arr[i]-fee>osell){
                nsell=obuy+arr[i]-fee;

            }else{
                nsell=osell;
            }


            //buy
            if(osell-arr[i]>obuy){
                nbuy=osell-arr[i];

            }else{
                nbuy=obuy;
            }


            osell=nsell;
            obuy=nbuy;
        }


        return osell;


    }


    public int bullSell_cooldown(int[] price){

        int osell=0;
        int obuy=-price[0];
        int ocdwn=0;


        for(int i=1; i<price.length; i++){
            int nsell=0;
            int nbuy=0;
            int ncdwn=0;

            //here cooldown state is like our cash for buy state.

            //buy state
            if(ocdwn-price[i]>obuy){
                nbuy=ocdwn-price[i];
            }else {
                nbuy=obuy;
            }

            //sell state
            if(obuy+price[i]>osell){
                nsell=obuy+price[i];

            }else{
                nsell=osell;
            }

            //cool down state
            if(osell>ocdwn){
                ncdwn=osell;
            }
            else{
                ncdwn=ocdwn;
            }


            osell=nsell;
            obuy=nbuy;
            ocdwn=ncdwn;
        }

        return osell;
    }


}
