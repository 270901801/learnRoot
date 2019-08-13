package javaRoot.collection;

import java.util.HashMap;
import java.util.Set;

/**
 * @author hsc
 * @date 2019/8/9 - 9:59
 */
public class MyHashSet {

    HashMap map;

    private static final Object PRESENT=new Object();

    public MyHashSet(){
        map=new HashMap();
    }

    public int size(){
        return map.size();
    }

    public void add(Object o){
        map.put(o,PRESENT);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append('[');
        for (Object key:map.keySet()){
            sb.append(key+",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyHashSet myHashSet=new MyHashSet();
        myHashSet.add("aaa");
        myHashSet.add("aaa");
        myHashSet.add("aaa");
        System.out.println(myHashSet);
    }
}
