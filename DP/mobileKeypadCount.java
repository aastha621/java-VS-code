package DP;

public class mobileKeypadCount {

    public long getCount(int N)
	{
	    long[][] dp= new long[N+1][10];
		
		int[][] moves=
		{
		    
		    {0,8},
		    {1,2,4},
		    {1,2,3,5},
		    {2,3,6}, 
		    {1,4,5,7},
		    {2,4,5,6,8},
		    {3,5,6,9}, 
		    {4,7,8},
		    {5,7,8,9,0},
		    {6,8,9}
		    
		};
		
		
		//each cell (i,j) of storage denotes the count of numbers
		//that can be generated if we click jth number and i clicks are allowed
		
		for(int i=0; i<=N; i++){
		    for(int j=0; j<=9; j++){
		        
		        if(i==0)
		        dp[i][j]=0; //0 clicks allowed->no num generated
		        
		        else if(i==1)
		        dp[i][j]=1; //1 click allowed, one num generated by every cell
		        
		        else {
		            
		            int[] nbr=moves[j];
		            
		            for(int x:nbr){
		                
		                dp[i][j]+=dp[i-1][x];
		            }
		            
		            
		        }
		    }
		}
		
		int sum=0;
		
		
		for(int i=0; i<=9; i++){
		    
		    sum+=dp[N][i];
		}
		
		return sum;
		
		 
	}
    
}