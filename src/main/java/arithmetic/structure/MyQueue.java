package arithmetic.structure;

/**
 * @author hsc
 * @date 2019/8/8 - 15:25
 */
public class MyQueue {
    private int [] elements;

    public MyQueue(){
        elements=new int[0];
    }

    //入队

    public void add(int element) {
        //创建一个新的数组
        int[] newArr=new int[elements.length+1];
        //把旧的数组赋给新的数组
        for (int i=0;i<elements.length;i++){
            newArr[i]=elements[i];
        }
        //把新的数组最后一个赋上element
        newArr[newArr.length-1]=element;
        //替换数组
        elements=newArr;
    }

    //出队
    public int poll(){
        //创建一个新的-1数组
        int[] newArr=new int[elements.length-1];
        //把旧的1以后的数组赋给新的数组
        for (int i=0;i<elements.length-1;i++){
            newArr[i]=elements[i+1];
        }
        int result=elements[0];
        //替换数组
        elements=newArr;
        //返回对头
        return result;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return elements.length==0;
    }
}
