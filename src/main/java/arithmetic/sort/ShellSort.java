package arithmetic.sort;

import org.junit.Test;

import java.util.Random;

/**希尔排序
 * 原理：先计算出一个最大步长然后步长依次减小为原来的若干倍，然后从第一个数隔着步长分组进行比较
 * 直到
 *
 * @author hsc
 * @date 2019/8/14 - 13:07
 */
public class ShellSort extends Sort{
    @Override
    public void sort(int[] arr) {
        int h=1;
        while (h<arr.length/3){
            h=h*3+1;
            System.out.println("-----------------h:"+h);
        }
        print(arr);
        System.out.println();
        while (h>=1){
            for (int i=h;i<arr.length;i++){
                for (int j=i;j>=h&&(arr[j]<arr[j-h]);j-=h){
                    swap(arr,j,j-h);
//                    System.out.println();
//                    print(arr);
                }
            }
            h=h/3;
        }
        System.out.println("比较的次数："+count);
    }
    @Test
    public void test(){
//        int []arr=new int[]{252,70,46,160,153,141,219,151,56,218};

//        int[] arr=new int[1000];
//        Random random=new Random();
//        for (int i=0;i<arr.length;i++){
//            arr[i]=random.nextInt(300);
//        }
        ShellSort ss=new ShellSort();
        ss.sort(arr);
        ss.print(arr);


//        ShellSort ss=new ShellSort();
//        ss.sort(arr);
//        ss.print(arr);
    }

//    public void shellsort(int []arr){
//        //遍历所有的步长
//        for (int d=arr.length/2;d>0;d/=2){
//            //遍历所有元素
//            for (int i=)
//        }
//    }


}
