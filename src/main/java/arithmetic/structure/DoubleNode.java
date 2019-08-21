package arithmetic.structure;

/**循环双链表
 * @author hsc
 * @date 2019/8/8 - 18:00
 */
public class DoubleNode {
    //上一个节点
    DoubleNode pre=this;
    //下一个节点
    DoubleNode next=this;
    //节点数据
    int data;
    public DoubleNode(int data){
        this.data=data;
    }

    //增节点
    public void after(DoubleNode node){
        //从左到右
        DoubleNode nextNext=this.next;
        this.next=node;
        node.pre=this;
        node.next=nextNext;
        nextNext.pre=node;
    }

    //下一个节点
    public DoubleNode next(){
        return next;
    }
    //上一个节点
    public DoubleNode pre(){
        return pre;
    }
    //获取值
    public int getData() {
        return data;
    }
}
