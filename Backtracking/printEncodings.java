package Backtracking;

public class printEncodings {


    public static void encodings(String ans, String q)
    {
        if(q.length()==0)
        {
            System.out.println(ans);
            return;
        }
        
        else if(q.length()==1){
            int num=q.charAt(0)-'0';
            String rem= q.substring(1);

            if(num==0)
            return;

            else{
                char ch= (char)('a'+num-1);
                encodings(ans+ch, rem);
            }

        }
        else {
            int num=q.charAt(0)-'0';
            String rem= q.substring(1);

            if(num==0)
            return;

            else{
                char ch= (char)('a'+num-1);

                encodings(ans+ch, rem);

                String two_dig=q.substring(0,2);

                char ch2= (char)('a'+Integer.parseInt(two_dig)-1);

                encodings(ans+ch2, rem);
            }




        }




       
    }


    public static void main(String[] args) {

        encodings("", "123");
        


    }
    
}
