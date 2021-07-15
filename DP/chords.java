package DP;

public class chords {

    public static int nonIntersectingChords(int n)
    {
        //n->no.of points
        int chords=n/2;
        int[] dp= new int[chords+1];

        //base cases

        dp[0]=1;
        dp[1]=1;

        
        for(int i=2; i<dp.length; i++){

            //choose one chord

            int left= 0;   //chords on left
            int right=i-1; //chords on right

            while(left<=i-1){
                dp[i]+=dp[left]*dp[right];
                left++;
                right--;
            }
        }
        
        return dp[chords];

    }
    


    public static void main(String[] args) 
    {

        int n=nonIntersectingChords(6);

        System.out.print(n);



        
    }
}
