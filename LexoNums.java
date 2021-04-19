public class LexoNums {

    public static void lexoOrder(int i , int n){
        if(i>n)
        return;
    
    System.out.println(i);
    
    for(int j=0; j<10; j++)
    {
        lexoOrder(i*10+j, n);
    }
        
    }

    public static void main(String[] args) {

        int n=13;
        for(int i=1; i<=n; i++){
           lexoOrder(i, n);
        }
    }
    
}
