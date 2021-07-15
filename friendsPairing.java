public class friendsPairing {

    public static int FP_recursive(int num)
    {
        if(num==0 || num==1)
        return 1;

        if(num==2)
        return 2;

        return FP_recursive(num-1)+FP_recursive(num-2)*(num-1);
    }

    

    public static void main(String[] args) {

        System.out.println(FP_recursive(5));
        
    }
    
}
