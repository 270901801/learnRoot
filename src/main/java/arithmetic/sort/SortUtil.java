package arithmetic.sort;

import org.junit.Test;

import java.util.Random;

/**
 * @author hsc
 * @date 2019/8/20 - 22:48
 */
public class SortUtil {
    /**
     * 将1-1000数字打乱,并返回
     * @return
     */
    public static int[] luan(){
        Random random=new Random();
        int arr[]=new int[1000];
        for (int i=0;i<arr.length;i++){
            arr[i]=i;
        }
        for (int i=0;i<arr.length;i++){
            swap(arr,i,random.nextInt(arr.length-1));
        }
        return arr;
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    @Test
    public void test(){
        print(luan());
    }
    public void print(int []arr){
        System.out.print("[");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.print("]");
    }
}
