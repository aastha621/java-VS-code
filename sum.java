public class sum {

    public static void main(String[] args) {

        int sum=0;

        for(int i=0; i<100; i++){
            // if(i%15==0)
            // sum+=i;

            if(i%3==0 || i%5==0)
            sum+=i;
        }

        System.out.print(sum);



    }
    
}
