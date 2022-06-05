package Array;

public class Q2 {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int cnt=1;
        int n=A.length;

        int num=A[n-1];
        int i=n-2;

        while(i>=0){
            if(A[i]<num){
                cnt++;
                num=A[i];
            }

            i--;
        }

        

        return cnt;
    }
    
}
