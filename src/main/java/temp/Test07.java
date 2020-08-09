package temp;

import arithmetic.structure.LoopNode;
import arithmetic.structure.Node;
import javaRoot.collection.MyLinkedList;

import java.util.LinkedList;

/**
 * @author hsc
 * @date 2019-11-23 19:25:47
 */
public class Test07 {
    public static void main(String[] args) {
        Node linkedList1=new Node(1);
        linkedList1.append(new Node(3));
        linkedList1.append(new Node(6));
        linkedList1.append(new Node(7));

        Node linkedList2=new Node(2);
        linkedList2.append(new Node(5));
        linkedList2.append(new Node(8));
        linkedList2.append(new Node(9));
//        linkedList.print();
//        printReverse(linkedList);
        merge(linkedList1,linkedList2);

    }
    static void printReverse(Node node){
        if (node==null)return;
        printReverse(node.next());
        System.out.println(node.getData());;
    }

    static void merge(Node node1,Node node2){
        while (node2!=null){
            if (node1.next().getData()>node2.next().getData()){

            }
            node1=node1.next();
            node2=node2.next();
        }
    }
}
