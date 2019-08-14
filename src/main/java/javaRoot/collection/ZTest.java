package javaRoot.collection;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**测试类
 * @author hsc
 * @date 2019/8/8 - 15:15
 */
public class ZTest {

    @Test
    public void testQueue(){
        MyQueue mq=new MyQueue();
        mq.add(2);
        mq.add(4);
        mq.add(6);
        System.out.println(mq.isEmpty());
        System.out.println(mq.poll());
        System.out.println(mq.poll());
        System.out.println(mq.poll());
        System.out.println(mq.isEmpty());
    }

    @Test
    public void testStack(){
        MyStack ms=new MyStack();
        for (int i=0;i<10;i++){
            ms.push(i);

        }
        System.out.println(ms.peek());
        ms.pop();
        ms.pop();
        ms.pop();
        System.out.println(ms.peek());
        System.out.println(ms.isEmpty());
    }

    @Test
    public void testNode(){
        //创建节点
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        //追加节点
        n1.append(n2).append(new Node(90));
        n1.append(n3).append(new Node(6));
        //取出下一个节点的数据
        System.out.println(n1.next().getData());
//        n1.print();
//        System.out.println();
//        n2.print();
//        System.out.println();
//        n3.print();
        System.out.println(n3.next().isLast());
        n1.next().next().removeNext();
//        n1.print();
        //插入一个节点到n1的后面
        n1.after(new Node(89));
        n1.print();

    }

    @Test
    public void testLoopNode(){
        LoopNode ln1=new LoopNode(1);
        LoopNode ln2=new LoopNode(2);
        LoopNode ln3=new LoopNode(4);
        LoopNode ln4=new LoopNode(9);
        ln1.after(ln2);
        ln2.after(ln3);
        ln3.after(ln4);
        System.out.println(ln1.getData());
        System.out.println(ln1.next.getData());
        System.out.println(ln1.next.next.getData());
        System.out.println(ln1.next.next.next.getData());
        System.out.println(ln1.next.next.next.next.getData());

//        ln1.print();


    }

    @Test
    public void testDouleNode(){
        DoubleNode n1=new DoubleNode(1);
        DoubleNode n2=new DoubleNode(2);
        DoubleNode n3=new DoubleNode(3);
        DoubleNode n4=new DoubleNode(4);

        //产生联系
        n1.after(n2);
        n2.after(n3);
        n3.after(n4);


        System.out.println(n1.getData());
        System.out.println(n1.pre.getData());
        System.out.println(n1.next.getData());

        System.out.println(n1.getData());
        System.out.println(n1.next.getData());
        System.out.println(n1.next.next.getData());
        System.out.println(n1.next.next.next.getData());
        System.out.println(n1.next.next.next.next.getData());
    }

    @Test
    public void testBinaryTree(){
        //创建一颗树
        BinaryTree binTree=new BinaryTree();
        //创建一个根节点
        TreeNode root=new TreeNode(1);
        //把根节点赋给树
        binTree.setRoot(root);
        //创建一个左节点
        TreeNode rootL=new TreeNode(2);
        //把新创建的节点设置为根节点的子节点
        root.setLeftNode(rootL);
        //创建一个右节点
        TreeNode rootR=new TreeNode(3);
        //把新创建的节点设置为根节点的子节点
        root.setRightNode(rootR);
        //为二层的左节点创建左右字节点
        rootL.setLeftNode(new TreeNode(4));
        rootL.setRightNode(new TreeNode(5));
        //为二层的右节点创建左右字节点
        rootR.setLeftNode(new TreeNode(6));
        rootR.setRightNode(new TreeNode(7));

        //前序遍历
        root.frontShow();
        System.out.println("===========================");
        //中序遍历
        root.midShow();
        System.out.println("===========================");
        //后序遍历
        root.afterShow();

        //前序查找
        TreeNode result=binTree.frontSearch(5);
        System.out.println(result);
        //中序查找
        result=binTree.midSearch(5);
        System.out.println(result);
        //后序查找
        result=binTree.afterSearch(5);
        System.out.println(result);
    }

    @Test
    public void testTreeMap(){
        Map<Integer,String> treeMap=new TreeMap<Integer, String>();
        treeMap.put(20,"aa");
        treeMap.put(30,"ff");
        treeMap.put(10,"aee");

        for (Integer key:treeMap.keySet()){
            System.out.println(treeMap.get(key));
        }
    }

}
