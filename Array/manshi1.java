package Array;

import java.util.ArrayList;

import java.util.Collections;

public class manshi1 {

   


    public static String[] giveDig(int n){
        ArrayList<String[]> nums= new ArrayList<>();
        String[] zero= {
            "#####",
            "#   #", 
            "#   #", 
            "#   #", 
            "#####", 
        };

        String[] one= {
            "    #",
            "    #", 
            "    #", 
            "    #", 
            "    #", 
        };

        String[] two= {
            "#####", 
            "    #", 
            "#####", 
            "#    ", 
            "#####"
        };

        String[] three= {
            "#####", 
            "    #", 
            "#####", 
            "    #", 
            "#####"
        };

        String[] four= {
            "#   #", 
            "#   #", 
            "#####", 
            "    #", 
            "    #"
        };

        String[] five= {
            "#####", 
            "#    ", 
            "#####", 
            "    #", 
            "#####"
        };

        String[] six= {
            "#####", 
            "#    ", 
            "#####", 
            "#   #", 
            "#####"
        };

        String[] seven= {
            "#####",
            "    #", 
            "    #", 
            "    #", 
            "    #", 
        };


        String[] eight= {
            "#####",
            "#   #", 
            "#####", 
            "#   #", 
            "#####", 
        };

        String[] nine= {
            "#####", 
            "#   #", 
            "#####", 
            "    #", 
            "    #"
        };

        String[] colon= {
            "     ", 
            "  #  ", 
            "     ", 
            "  #  ", 
            "     "
        };
        nums.add(zero);

        nums.add(one);
        nums.add(two);
        nums.add(three);
        nums.add(four);
        nums.add(five);
        nums.add(six);
        nums.add(seven);
        nums.add(eight);
        nums.add(nine);
        nums.add(colon);

        return nums.get(n);

        

        

    }




    public static void displayCLock(int a, int b){
        ArrayList<Integer> arr= new ArrayList<>(); 
        
        while(b!=0){
            int d=b%10;
            arr.add(d);
            b=b/10;
            

        }

        arr.add(10);

         while(a!=0){
            int d=a%10;
            arr.add(d);
            a=a/10;
        }

        Collections.reverse(arr);

            printClock(arr);
           


            
    }
    
    private static void printClock(ArrayList<Integer> arr) {

        for(int i=0; i<5; i++){
           
            for(int j=0; j<5; j++){
                String d[]= giveDig(arr.get(j));

                System.out.print(d[i]);

                if(j<5)System.out.print(" ");
               
            } 
            System.out.println();
            
        }

    }




    public static void createClock(String input){
         int n=input.length();
         int c= input.indexOf(":");
         String s1= input.substring(0, c);
         String s2= input.substring(c+1, n);

         int d1=Integer.parseInt(s1);
         int d2=Integer.parseInt(s2);

         displayCLock(d1, d2);
         
     }
    


     public static void main(String[] args) {
         String t="09:79";

         createClock(t);

         
     }
}
