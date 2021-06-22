package Strings;

import java.util.ArrayList;

public class permutations {

    //swap method
    public static ArrayList<String> ans1= new ArrayList<>();

    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
    
    public static void permute_swap(String s, int l, int r){

        if(l==r){
            ans1.add(s);
            return;
        }


        for(int i=l; i<=r; i++){
            s=swap(s, l, i);

            permute_swap(s, l+1,r);

        }



    }



    public static ArrayList<String> ans2= new ArrayList<>();

    


    public static void permute2(String q, String a){

        if(q.length()==0){
            ans2.add(a);
            return;
        }


        for(int i=0; i<q.length(); i++){

            char c= q.charAt(i);
            String rem= q.substring(0,i)+q.substring(i+1);

            permute2(rem, c+a);
            permute2(rem, a+c);


        }

        



    }



    
}
