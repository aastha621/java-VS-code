package Array;

// import java.util.Scanner;
import java.util.*;

public class question2 {

    public static int multiply(int a, int b){
        int res=a;
        for(int i=1; i<=b; i++){
            res=res*2;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);

        

        int a=s.nextInt();
        int b=s.nextInt();
        System.out.print(multiply(a,b));

        s.close();
        
    }
    
}
