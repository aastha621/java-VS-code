package Strings;

public class KMP {

    //based on prefix suffix array
    //the prefix array stores the length of the longest proper prefix of the substring 
    //which is also a suffix in the substring

    
    public static int[] buildPi(String s)
    {
        int[] pi=new int[s.length()];
        pi[0]=0;

        for(int i=1; i<s.length(); i++)
        {
            int j=pi[i-1];

            while(j>0 && s.charAt(j)!=s.charAt(i))
            j=pi[j-1];


            if(s.charAt(i)==s.charAt(j))
            j++;

            pi[i]=j;
        }

        return pi;
    }//O(m)


    public static int kmp(String p, String t){

        int[] pi= buildPi(p); //O(m)


        int i=0;//for test
        int j=0;//for pi


        while(i<t.length())
        {

            if(p.charAt(j)==t.charAt(i))
            {
                i++;
                j++;

            }

            else{

                if(j==0)
                i++;

                else
                j=pi[j-1];

            } 
            
            if(j==p.length())
            return (i-p.length());
        }

        //O(n)

        return -1;

    }
    //total t.c= O(m+n)

        public static void main(String[] args) {
            
            int ans= kmp("cde", "abcdefg");

            System.out.print(ans);
        }


    
}
