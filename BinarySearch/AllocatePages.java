package BinarySearch;

public class AllocatePages{

     //Function to find minimum number of pages.
     public static int findPages(int[]a,int n,int m)
    {
        // [20, 10, 30, 40] in any case of distribution, the min pages alloted to a student will be the max value of the array

        int max=0;
        int sum=0;

        for(int x: a){
            max=Math.max(max, x);
            sum+=x;
        }

        int lo=max;
        int hi=sum;
        int result=-1;

        while(lo<=hi){
            int mid= lo+(hi-lo)/2;


            if(isPossible(a,m, mid)){
                result=mid;
                hi=mid-1;
                
            }

            else{
                lo=mid+1;
            }
        }

        return result;
    }


    public static boolean isPossible(int[] p, int students, int max)
    {
        int sum=0;
        int st=1;

        for(int i=0; i<p.length; i++)
        {
            sum+=p[i];

            if(sum>max)
            {
                sum=p[i];
                st++;

            }
        }
        
        return st<=students;
    }


    public static void main(String[] args) {
        String a = "amaankhan";
        String s = a.substring(a.length() -2 ,a.length());
        System.out.println(s);

        if (s.equals("an")){
            System.out.print("Amaan is a good boy");
        }
        else {
            System.out.print("Amaan is excellent boy ");
        }
    }
    
}
