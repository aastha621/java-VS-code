package DP;

public class editDistance {

    //insert: m, n-1
    //remove: m-1, n
    //replace: m-1, n-1



    public static int editD_recursive(String a, String b, int i, int j){

        if(i==a.length() && j==b.length())return 0;

        if(i==a.length()) //if a gets empty, to make it equal we must add all remaining chars in b
        return b.length()-j;


        if(j==b.length()) //if b becomes empty, to make equal all the remaining chars in a must be removed
        return a.length()-i;





        if(a.charAt(i)==b.charAt(j))
        return editD_recursive(a, b, i+1, j+1);


        int insert = editD_recursive(a, b, i, j+1);
        int remove = editD_recursive(a, b, i+1, j);
        int replace = editD_recursive(a, b, i+1, j+1);


        return Math.min(insert, Math.min(remove, replace));



    }



    


    
}
