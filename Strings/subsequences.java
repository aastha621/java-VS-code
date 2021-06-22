package Strings;

public class subsequences {


    public static void subsequence(String q, String a){

        if(q.length()==0){
            System.out.println(a);
            return;
        }

            char c=q.charAt(0);

            subsequence(q.substring(1), a+c);
            subsequence(q.substring(1), a);


        



    }


    public static void main(String[] args) {
        subsequence("abc", "");
    }
    
}
