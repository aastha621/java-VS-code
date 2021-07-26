package Strings;

import java.util.HashMap;

public class kAnagram {


//Given two strings of lowercase alphabets and a value k, the task is to find if two strings are K-anagrams of each other or not.
// Two strings are called k-anagrams if following two conditions are true. 

// Both have same number of characters.
// Two strings can become anagram by changing at most k characters in a string.

    boolean areKAnagrams(String s1, String s2, int k)
    {
        HashMap<Character, Integer> map1= new HashMap<>();
        
        for(int i=0; i<s1.length(); i++){
            char ch=s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0)+1);
        }
        

        for(int i=0; i<s2.length(); i++){
            char ch=s2.charAt(i);
            

            if(map1.getOrDefault(ch,0)>0){
                map1.put(ch, map1.get(ch)-1);
            } 
        }

        int cnt=0;


        //now only extra elements will be remaining in the map
        
        for(char ch:map1.keySet()){
            cnt+=map1.get(ch);
        }

        return cnt<=k;
    }
    
}
