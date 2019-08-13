package arithmetic.offer.threeTo9;

/**
 * @author hsc
 * @date 2019/8/5 - 18:13
 */

import com.sun.beans.decoder.ValueObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 *
 * Input:
 * {2, 3, 1, 0, 2, 5}
 *
 * Output:
 * 2
 */
public class repeatedNum {
    public  int repeatedNum(int[] arr){
        int rep=0;
//        for (int i=0;i<arr.length;i++){
//            print(arr);
//            long start=System.currentTimeMillis();
//            while(arr[i]!=i){
//                swap(arr,i,arr[i]);
//                long end=System.currentTimeMillis();
////                if (end-start>100000){
////                    System.out.println(1);
////                }
//                try {
//                    Thread.currentThread().sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                print(arr);
//            }
//
//
//        }
        List list=new ArrayList<Integer>();
        for (int i=0;i<arr.length;i++){
            if (list.contains(Integer.valueOf(arr[i]))){
                return arr[i];
            }
            list.add(Integer.valueOf(arr[i]));
        }
        return -1;
    }
    public  void swap(int []arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public  void print(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        repeatedNum repeatedNum=new repeatedNum();
        int []arr={4,3,5,1,6,2};
        System.out.println(repeatedNum.repeatedNum(arr));
    }
}
