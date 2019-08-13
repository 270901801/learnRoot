package javaRoot.collection.root;


import java.util.ArrayList;
import java.util.List;

/**
 * @author hsc
 * @date 2019/8/5 - 11:50
 */
public class learnList {
//    public native int hashCode();
//    static {
//        System.loadLibrary("hashCode");
//    }
    public static void main(String[] args) {
        List list=new ArrayList();
        Object object=new Object();
        System.out.println(object.hashCode());
        System.out.println(object.equals(object));
        learnList learnList=new learnList();
        System.out.println(learnList.hashCode());
    }

}
