package javaRoot.collection;


/**
 * 自定义实现一个ArrayList，体会底层原理
 * 增加泛型，数组扩容
 * 增加索引检测
 * 增加remove
 * @author hsc
 * @date 2019/8/9 - 8:42
 */
public class MyArrayList<E> {
    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY=10;

    public MyArrayList(){
        elementData=new Object[DEFAULT_CAPACITY];
    }
    public MyArrayList(int capacity){
        if (capacity<0){
            throw new RuntimeException("capacity不能为负数");
        }
        elementData=new Object[capacity];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(E element){
        //什么时候扩容
        if (size==elementData.length){
            //怎么扩容
            Object[] newArr=new Object[elementData.length+(elementData.length>>1)];//1.5
            System.arraycopy(elementData,0,newArr,0,elementData.length);
            //替换数组
            elementData=newArr;
        }

        elementData[size++]=element;
    }

    public E get(int index){
        checkRange(index);
        return (E)elementData[index];
    }

    public void set(E element,int index){
        checkRange(index);
        elementData[index]=element;
    }
    public void remove(E element){
        //element,将他和所有元素进行比较，获得第一个比较为true的返回
        for (int i=0;i<size;i++){
            if (element.equals(get(i))){
                //将该元素从此处移除
                remove(i);
            }
        }
    }
    public void remove(int index){
        int numMoved=elementData.length-index-1;
        if (numMoved>0){
            System.arraycopy(elementData,index+1,elementData,index,elementData.length-index-1);
        }
        elementData[--size]=null;
    }
    public void checkRange(int index){
        if (index>=size||index<0){
            throw new RuntimeException("index不合法"+index);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append('[');
        for (int i=0;i<size;i++){
            sb.append(elementData[i]+",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyArrayList sl=new MyArrayList(20);
        for (int i=0;i<20;i++){
            sl.add("aa"+i);
        }
//        sl.add("ab");
        System.out.println(sl);
        sl.remove("aa5");
        System.out.println(sl);
    }
}
