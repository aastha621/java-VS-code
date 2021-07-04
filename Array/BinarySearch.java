package Array;

public class BinarySearch {

    //(Q1) Find row in matrix with max 1's 

    public static int rowWithMax1s(int arr[][], int n, int m) {
        
        int cnt;
        int max=0;
        int index=-1;
        
        for(int i=0; i<n; i++){
            int[] row=arr[i];
            
            cnt=count1(row); //using binary search, we will find the freq of 1 in each row
            
            if(cnt>max){
                max=cnt;
                index=i;
            }
            
            
            
        }
        
        
        return index;
    }
    
    
    public static int count1(int[] a){
        int n=a.length;
        int lo=0; 
        int hi=n-1;
        
        //we are finding the first occurence of 1
        while(lo<=hi){
            
            int mid= lo+(hi-lo)/2;
            
            if((mid==0 || a[mid-1]==0) && a[mid]==1) //first occurence of 1 found, return freq
            return n-mid;
            
            
            else if(a[mid]==0) // mid==0, i.e first occurence of 1 will lie in the second half
                lo=mid+1;
            
            else //mid==1, i.e it is possible that this in not the first occurence of 1, lets check in left half
            hi=mid;
        }
        
        return 0;
        
    }


    //(Q2) Count zeroes in a row wise and col wise sorted matrix

    public static int countZeros(int a[][], int N)
    {
        int cnt=0;
        int i=0; 
        int j=N-1;
        
        while(i<N && j>=0){
            
            if(a[i][j]==1){
                j--;
            }
            
            else{
                cnt+=(j+1);
                i++;
                
            }
        }
        
        
        return cnt;
        
        
    }
    


}
