package temp;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author hsc
 * @date 2019-11-20 23:43:57
 */
public class Test06 {

    static class ListNode {
           int val;
           ListNode next = null;

           ListNode(int val) {
               this.val = val;
           }

        @Override
        public String toString() {
               String str="ttt";
            ListNode listNode=this;
            System.out.println(this);
            while (listNode.next!=null){
                str+=","+listNode.val;
                listNode=listNode.next;
            }
            return str;
        }
    }


    public static String replaceSpace(StringBuffer str) {
        int count=0;
        for(int i=0;i<str.length();i++){
            if(" ".equals(String.valueOf(str.charAt(i))))count++;
        }
//        for(){
//
//        }
        return null;
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
           ArrayList<Integer> arrayList=new ArrayList<>();
        ArrayList<Integer> arrayList1=new ArrayList<>();
        if(listNode==null){
            return arrayList;
        }
        while (listNode.next!=null){
            arrayList.add(listNode.val);
            listNode=listNode.next;
        }
        for(int i=arrayList.size();i>0;i--){
            arrayList1.add(arrayList.get(i));
        }
        return arrayList1;
    }
    @Test
    public void test1(){
        System.out.println(8&9);
    }
    public static int Fibonacci(int n) {
        int a=1,b=1;
        if(n==0)return 0;
        if(n==1)return 1;
        if(n==2)return 1;
        int thenum=0;
        for(int i=0;i<n;i++){
            if(i<2)
                thenum=1;
            else{
                thenum=a+b;
                a=b;
                b=thenum;

            }
        }
        return thenum;
    }
    public static void main(String[] args) {
        System.out.println(Fibonacci(4));
//        ListNode listNode=new ListNode(100);
//        ListNode listNode=null;
//        for (int i=0;i<10;i++){
//            listNode.next=new ListNode(i);
//            listNode=listNode.next;
//        }
        //System.out.println(listNode.toString());
//        System.out.println(printListFromTailToHead(listNode));

//        "".replace();
//        System.out.println(Math.abs(-1));
//        System.out.println(" ".length());
//        StringBuffer str=new StringBuffer("We Are Happy");
////        System.out.println(replaceSpace(str));
//        System.out.println("%20".length());
    }
}
