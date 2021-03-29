import java.util.*;
public class Interleave {

    public static void interleave(Queue<Integer> q)
    {
        Stack<Integer> st = new Stack<>();

        int n=q.size()/2;

        int i=0; 

        // the idea is to divide the queue into two equal halves,
        // and implement the first half of queue using stack.
        
        //push state
        while(i<n)
        {
            st.push(q.poll());
            i++;
        }


        while(!st.isEmpty()){
            q.add(st.pop());
        }


        for(int j=0; j<n; j++)
        {
            q.add(q.poll());

        }

        i=0; 

    
        //pop state
        while(i<n)
        {
            st.push(q.poll());
            i++;
        }


        while(!st.isEmpty()){
           q.add(st.pop());
           q.add(q.poll());
        }

        for(int x:q){
            System.out.print(x+" ");
        }

    }

    public static void main(String[] args) {
        Queue<Integer> q= new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        interleave(q);
        
    }


    
}
