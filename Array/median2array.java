package Array;

public class median2array {


    public static int median2sortedArrays(int[] a, int[] b)
    {   int n=a.length; 
        int m=b.length;

        if(n>m){
            return median2sortedArrays(b, a);
        }

        int lo=0; int hi=n;

        int t=n+m;

        int med=0;

        while(lo<=hi){

            int al=(lo+hi)/2;
            int bl= (t+1)/2-al;

            int alm1=(al==0)?Integer.MIN_VALUE: a[al-1];
            al=(al==n)? Integer.MAX_VALUE: a[al];

            int blm1=(bl==0)?Integer.MIN_VALUE: b[bl-1];
            bl=(bl==m)?Integer.MAX_VALUE: b[bl];


            if(alm1<bl && blm1<al){

                if(t%2==0){

                    int m1=Math.max(alm1, blm1);
                    int m2=Math.max(al, bl);

                    med= (m1+m2)/2;

                }
                else{
                    med=Math.max(alm1, blm1);
                }
            }


            else if(alm1>bl){
                hi=al-1;
            }
            else if(blm1>al){

                lo=al+1;

            }

        }

        return med;



        




    }
    
}
