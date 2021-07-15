package DP;

public class palindromicPartition 
{

    public boolean isPal(String s){
        int l=0; 
        int r=s.length()-1;
        
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
        
        
        return true;
    }
    
    
    public int minCut(String s) {
        
        int[] dp= new int[s.length()];
        
        //each cell i represents the min number of pal cuts for the substring(0-i)
        
        
        dp[0]=0;// single char-> no cut
        
        for(int i=1; i<s.length(); i++){
            
          if(isPal(s.substring(0,i+1)))
                dp[i]=0;
            
            else{
                  
            int min=Integer.MAX_VALUE;
            
            
            for(int j=i; j>=1; j--)
            {
                String prefix=s.substring(j,i+1);
                
                if(isPal(prefix))
                {
                    
                if(dp[j-1]<min)
                    min=dp[j-1];
                }
               
            }
            
            dp[i]=min+1;
            
            }
            
          
            
        }
        
        
        return dp[s.length()-1];
        
        
        
        
        
    }
    
}
