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

    public static void ASCIIsubsequence(String q, String a){

        if(q.length()==0){
            System.out.println(a);
            return;
        }

            char c=q.charAt(0);
            int code=c-'0';

            ASCIIsubsequence(q.substring(1), a+c);
            ASCIIsubsequence(q.substring(1), a);
            ASCIIsubsequence(q.substring(1), a+ Integer.toString(code));
}


    public static void main(String[] args) {
        ASCIIsubsequence("ab", "");
    }
    
}
