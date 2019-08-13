package javaRoot.collection;

/**
 * @author hsc
 * @date 2019/8/8 - 16:41
 */
public class Node {

    private int data;
    private Node next;

    public Node(int data){
        this.data=data;
    }
    //追加节点到最后节点
    public Node append(Node node){
        //当前节点
        Node currentNode=this;
        //循环向后找
        while(true){
            //去除下一个节点
            Node nextNode=currentNode.next;
            //如果下一个节点为null
            if(nextNode==null){
                break;
            }
            //赋给当前节点
            currentNode=nextNode;
        }
        //把需要追加的节点追加到当前节点的下一个节点
        currentNode.next=node;
        return this;
    }

    //获取下一个节点
    public Node next(){
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
        Node newNext=next.next;
        this.next=newNext;
    }

    //插入一个节点作为当前节点的下一个节点
    public void after(Node node){
        //加入一个节点到当前节点的下一个
        Node nextNext=this.next;
        this.next=node;
        node.next=nextNext;

    }


    //打印完整的链
    public void print(){
        System.out.print(this.data);
        Node currentNode=this;
        while (true){
            currentNode=currentNode.next;
            if (currentNode==null){
                break;
            }
            System.out.print("->"+currentNode.getData());
        }
    }
}
