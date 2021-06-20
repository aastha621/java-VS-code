import java.util.*;
public class RedundantBrackets {

    public static boolean redundant(String s){
        Stack<Character> st= new Stack<>();
        
         for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);

            if(c==')')
            {
                if(st.peek()=='(')
                return true;

                else{
                    boolean flag=true;

                    while(st.peek()!='('){
                        char top= st.pop();

                        if(top=='+')
                        flag=false;
                    }

                    st.pop();
                    

                    if(flag==true)return true;

                }

                

            }

            else st.push(c);

        }


        return false;
    }
    public static void main(String args[]) {
        System.out.println(redundant("((a)+(b+g)+c)"));
    }
    
}
