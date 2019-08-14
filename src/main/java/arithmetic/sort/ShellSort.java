package arithmetic.sort;

import org.junit.Test;

import java.util.Random;

/**希尔排序
 * @author hsc
 * @date 2019/8/14 - 13:07
 */
public class ShellSort extends Sort{
    @Override
    public void sort(int[] arr) {
        int h=1;
        while (h<arr.length/3){
            h=h*3+1;
        }
        print(arr);
        while (h>=1){
            for (int i=h;i<arr.length;i++){
                for (int j=i;j>=h&&(arr[j]<arr[j-h]);j-=h){
                    swap(arr,j,j-h);
                    System.out.println();
                    print(arr);
                }
            }
            h=h/3;
        }
    }
    @Test
    public void test(){
        int []arr=new int[]{252,70,46,160,153,141,219,151,56,218};
        Random random=new Random();
//        for (int i=0;i<arr.length;i++){
//            arr[i]=random.nextInt(300);
//        }
        ShellSort ss=new ShellSort();
        ss.sort(arr);
//        ss.print(arr);
    }
}
