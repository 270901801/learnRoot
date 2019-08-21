package arithmetic.sort;

import org.junit.Test;

/**冒泡排序
 * @author hsc
 * @date 2019/8/14 - 11:42
 */
public class BubbleSort extends Sort{
    @Override
    public void sort(int [] arr){
        int temp;
        for(int i=arr.length;i>0;i--){
            boolean flag=false;
            for(int j=0;j<i-1;j++){
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    flag=true;
                }
            }
            if (!flag){
                System.out.println("比较的次数："+count);
                return;
            }
        }

    }

    @Test
    public void test(){
        BubbleSort bs=new BubbleSort();
        bs.sort(arr);
        bs.print(arr);
    }

}
