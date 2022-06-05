package Array;

import java.util.*;

public class subtractMatrix {

    public static void subtract(int[][] m, int[][]n){
        int p=m.length;
        int q=m[0].length;

        for(int i=0; i<p; i++){
            for(int j=0; j<q; j++){

                m[i][j]=m[i][j]-n[i][j];

            }
        }

        //print
        for(int i=0; i<p; i++){
            for(int j=0; j<q; j++){

                System.out.print(m[i][j]+" ");

            }

            System.out.println();


        }


    }

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int row, col;

        row=s.nextInt();
        col=s.nextInt();

        int a[][]= new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                a[i][j]=s.nextInt();

            }
        }

        int b[][]= new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                b[i][j]=s.nextInt();

            }
        }

        subtract(a, b);

        s.close();

    }


   
    
}
