import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class hello {

    public static class pair{
        int rno; 
        int course;
        pair(int x, int y){
            course=x;
            rno=y;

        }
    }

    public static void main(String[] args) throws IOException {
        Scanner s= new Scanner(System.in);
        int q=s.nextInt();
        
        ArrayList<pair> arr= new ArrayList<>();

            BufferedReader in = new BufferedReader( 
                new InputStreamReader( 
                System.in)); 

                
        for(int i=0; i<q; i++){

            
                
                String[] input = new String[3]; 
                int a; 
                int b; 
                
                 
                input = in.readLine().split(" ");

                // op = input[1]; 
                // String op=input[0];

                 
                

            if(input.length>1){
                
                a = Integer.parseInt(input[1]); 
                b = Integer.parseInt(input[2]);

                // int sp1=op.indexOf(" ");
                // int sp2=op.indexOf(" ", sp1+1);

                // String c= op.substring(sp1+1, sp2);
                // String r= op.substring(sp2+1, op.length());

                // int course=Integer.parseInt(c);
                // int rno=Integer.parseInt(r);
                
                int course=a;
                int rno=b;
                
                if(arr.isEmpty())
                {
                    arr.add(new pair(course, rno));
                }
                else{
                    boolean flag=false;

                    for(int j=arr.size()-1; j>=0; j--){

                        if(arr.get(j).course==course){
                            flag=true;
                            arr.add(j+1, new pair(course, rno));
                        }

                    }

                    if(flag==false){
                        arr.add(new pair(course, rno));
                        }
                }



            }

            else if(input.length==1)
            {
               pair rem= arr.get(0);
               arr.remove(0);
               System.out.println(rem.course+" "+rem.rno);

            }
            
           
        }

        s.close();
        

    }
    
}
