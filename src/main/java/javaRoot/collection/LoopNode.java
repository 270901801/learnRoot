package javaRoot.collection;

/**循环链表
 * @author hsc
 * @date 2019/8/8 - 16:41
 */
public class LoopNode {

    private int data;
    LoopNode next=this;

    public LoopNode(int data){
        this.data=data;
    }


    //获取下一个节点
    public LoopNode next(){
        return this.next;
    }
    //获取节点的数据
    public int getData(){
        return this.data;
    }
    //当前节点是否是最后一个节点
    public boolean isLast(){
        return this.next==null;
    }

    //删除下一个节点
    public void removeNext(){
        //取出下一个节点
        LoopNode newNext=next.next;
        this.next=newNext;
    }

    //插入一个节点作为当前节点的下一个节点
    public void after(LoopNode node){
        //加入一个节点到当前节点的下一个
        LoopNode nextNext=next;
        this.next=node;
        node.next=nextNext;
        System.out.println("this.next == next:"+(this.next == next));

    }


    //打印完整的链
    public void print(){
        System.out.print(this.data);
        LoopNode currentNode=this;
        while (true){
            currentNode=currentNode.next;
            if (currentNode==null){
                break;
            }
            System.out.print("->"+currentNode.getData());
        }
    }
}
