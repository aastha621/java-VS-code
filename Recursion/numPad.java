package Recursion;

public class numPad {

    public static void cross(String a, String b, String ans)
    {
        if(b.length()==0){
            System.out.println(ans);
          return;  
        }
        


        for(int i=0; i<a.length(); i++){
            char ch=b.charAt(0);
            String rem=b.substring(1);

            cross(a, rem, ""+a.charAt(i)+ch);
        }


    }

    public static void main(String[] args) {
        cross("abc", "def", "");
    }
    
}
