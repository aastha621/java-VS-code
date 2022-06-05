import java.util.Stack;

public class StackReverse {

    public static void InsertAtBottom(Stack<Integer> st, int x){
        
        if(st.isEmpty()){
            st.push(x);
            return;
        }
        
        int p=st.pop();

        InsertAtBottom(st, x);

        st.push(p);

        
    }

    public static void reverseStack(Stack<Integer> st){
        
        if(!st.isEmpty())
        {
        int top=st.pop();
        reverseStack(st);
        InsertAtBottom(st, top);
        } 
    }

    public static void main(String[] args) {

        Stack<Integer> st= new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        reverseStack(st);

        while(!st.isEmpty()){
            int x=st.pop();
            System.out.print(x);
        }
    }
    
}
