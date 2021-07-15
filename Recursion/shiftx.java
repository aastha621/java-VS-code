package Recursion;

public class shiftx {

    public static String moveX (String s)
    {
        if(s.length()==0)
        return "";
        
        char ch=s.charAt(0);

        String rem=moveX(s.substring(1));

        if(ch=='x')
        return rem+ch;

        else return ch+rem;


    }


    public static void main(String[] args)
    {

        String s= "geekxsforgexxeksxx" ;

        System.out.print(moveX(s));
        
    }
    
}
