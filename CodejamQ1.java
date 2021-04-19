import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class CodejamQ1 {

    public static int minTreats(int[] arr){
        
        TreeMap<Integer, Integer> tm= new TreeMap<>();

        for(int x:arr){
            tm.put(x, tm.getOrDefault(x, 0)+1);
        }

        int treats=0;
        int f=1;

        for(Map.Entry<Integer, Integer> e:tm.entrySet()){
            int val=e.getValue();

            treats+=val*f;

            f++;

        }


        return treats;
        
    }


    public static void main(String[] args) {

        Scanner s= new Scanner(System.in);

        int t=s.nextInt();

        for(int i=0; i<t; i++)
        {
            int size=s.nextInt();
            int[] arr= new int[size];

            for(int j=0; j<size; j++){
                arr[j]=s.nextInt();

            }

            int a= minTreats(arr);

            System.out.println("Case #"+(i+1)+": "+a);
        }
        
    }
    
}
