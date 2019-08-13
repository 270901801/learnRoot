package javaRoot.collection;

/**实现hashmap
 * 重写toString方法
 * @author hsc
 * @date 2019/8/8 - 21:20
 */
public class MyHashMap<K,V> {

/**
 * hashmap node
 */
class Node<K,V>{
    int hash;
    K key;
    V value;
    Node next;
}
    //位桶数组。bucket array
    Node[] table;
    //存放的键值对的个数
    int size;

    public MyHashMap(){
        table=new Node[16];//长度一般定义为2的整数幂
    }

    public void put(K key,V value){
        //定义新的节点对象
        Node newNode=new Node();
        newNode.hash=myHash(key.hashCode(),table.length);
        newNode.key=key;
        newNode.value=value;
        newNode.next=null;

        boolean keyRepeat=false;
        Node temp=table[newNode.hash];
        Node iterLast=null;
        if (temp==null){
            //此处数组元素为空，则直接将新节点放进去
            table[newNode.hash]=newNode;
            size++;
        }else {
            //不为空，则遍历对应链表。
            while (temp!=null){
                //判断key如果重复，则覆盖
                if (temp.key.equals(key)){
                    keyRepeat=true;
                    System.out.println("key重复了");
                    temp.value=value;
                    break;
                }else {
                    //key不重复
                    iterLast=temp;
                    temp=temp.next;
                }
            }
            //没有发生key重复的情况，则添加到链表最后
            if (!keyRepeat){
                iterLast.next=newNode;
                size++;
            }
        }
    }

    public V get(K key){
        int hash=myHash(key.hashCode(),table.length);
        V value=null;
        Node temp=table[hash];
        if (temp!=null){
            while (temp!=null){
                if (temp.key.equals(key)){
                    value =(V)temp.value;
                    return value;
                }
                temp=temp.next;
            }
        }
        return value;
    }

    public int myHash(int hashcode,int length){
        System.out.println("hash in myHash:"+(hashcode&(length-1)));//直接位运算，效率高
        //System.out.println("hash in myHash:"+(hashcode%(length-1)));//取模运算，效率低
        return hashcode&(length-1);
    }

    @Override
    public String toString() {
        //{10:aa,20:bb}
        StringBuilder sb=new StringBuilder("{");
        Node temp=null;
        for (int i=0;i<table.length;i++){
            if (table[i]!=null){
                temp=table[i];
                while (temp!=null){
                    sb.append(temp.key+":"+temp.value+"\t");
                    temp=temp.next;
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyHashMap<String ,Integer> mh=new MyHashMap();
//        mh.put(10,"aa");
//        mh.put(20,"bb");
//        mh.put(30,"cc");
//        mh.put(30,"sssssssss");
        mh.put("ab",11);
        mh.put("bc",12);
        mh.put("vd",13);
        mh.put("abb",14);
        System.out.println(mh.get("abb"));
        System.out.println(mh.toString());
    }

}
