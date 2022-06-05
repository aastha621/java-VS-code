package Strings;

import java.util.Arrays;

public class reverse {

    public static void main(String[] args) {
        String s="cab";
        char[] a= s.toCharArray();

        Arrays.sort(a);

        if(a.equals("abc"))
        System.out.print("true");

        for(char ch:a){
            System.out.print(ch);
        }
    }

   
    
}
