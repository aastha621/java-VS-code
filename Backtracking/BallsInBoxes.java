package Backtracking;

public class BallsInBoxes{

    //Given n boxes and r balls, print ways in which you can place one ball in one box each

    //Case 1: Balls are undistinguishable


    public static void printCombinations(int cball, int tball, int box,int tbox,  String ans)
    //at each level of rec tree, we either fill ith box or we dont fill it
    {
        if(box>tbox){

            if(cball==tball)
            {
            System.out.println(ans);
            }
            
            return;

        }
        
        //place ball in box
        printCombinations(cball+1, tball, box+1, tbox, ans+"B");

        //dont place ball
        printCombinations(cball, tball, box+1, tbox,  ans+"_");

    }


    //Case 1: Balls are distinguishable

    public static void printPermuatations(int[] boxes, int ball, int tball) 
    // at each level of rec tree, we place 'i'th ball
    {

        if(ball>tball){
            for(int x:boxes){
                System.out.print(x);
            }

            System.out.println();
            return;

        }


        for(int i=0; i<boxes.length; i++){
            if(boxes[i]==0)
            {             
                boxes[i]=ball;
                printPermuatations(boxes, ball+1, tball);
                boxes[i]=0;
            }
            
        }
    }



    public static void main(String[] args) {

        // printCombinations(1, 2, 1, 4, "");
        printPermuatations(new int[5], 1, 3);
        
    }





    
}
