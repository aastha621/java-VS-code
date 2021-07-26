import java.util.*;
public class LRUcache {

    int cap,start=0,end=0;
    
    Map<Integer,Integer> map=new HashMap<>();
    LinkedList<Integer> list=new LinkedList<>();

    public LRUcache(int capacity) {
        cap=capacity;
    }
    public int get(int key) {
        if(map.containsKey(key)) {
            list.remove(list.indexOf(key));
            list.addLast(key);
            return map.get(key);
        }return -1;
    }
    public void set(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            list.remove(list.indexOf(key));
            list.addLast(key);
        }else if(map.size()<cap){
            map.put(key,value);
            list.addLast(key);
        }else{
            int get=list.removeFirst();
            map.remove(get);
            map.put(key,value);
            list.addLast(key);
        }
    }
    
}
