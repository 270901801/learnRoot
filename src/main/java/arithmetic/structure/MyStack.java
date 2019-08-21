package arithmetic.structure;

/**
 * @author hsc
 * @date 2019/8/8 - 14:55
 */
public class MyStack {

    //栈的底层使用数组来存取
    int[] elements;

    public MyStack(){
        elements=new int[0];
    }

    //压栈
    public void push(int element){
        //创建一个新的+1数组
        int[] newArr=new int[elements.length+1];
        for (int i=0;i<elements.length;i++){
            newArr[i]=elements[i];
        }
        newArr[newArr.length-1]=element;
        //把newArr赋给elements
        elements=newArr;
    }
    //弹栈
    public void pop(){
        //是否为空，为空抛异常
        if(elements.length==0){
            throw new RuntimeException("栈为空");
        }
        //创建一个新的-1数组
        int[] newArr=new int[elements.length-1];
        for (int i=0;i<elements.length-1;i++){
            newArr[i]=elements[i];
        }
        elements=newArr;
    }
    //查看栈顶元素
    public int peek(){
        //是否为空，为空抛异常
        if(elements.length==0){
            throw new RuntimeException("栈为空");
        }
        return elements[elements.length-1];
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return elements.length==0;
    }
}
