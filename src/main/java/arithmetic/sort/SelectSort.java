package arithmetic.sort;

import org.junit.Test;

/**选择排序
 * @author hsc
 * @date 2019/8/14 - 12:25
 */
public class SelectSort extends Sort{

    @Override
    public void sort(int arr[]){
        for (int i=0;i<arr.length;i++){
            int minIndex=i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            swap(arr,minIndex,i);
        }
        System.out.println("比较的次数："+count);
    }

    @Test
    public void test(){
        SelectSort ss=new SelectSort();
        ss.sort(arr);
        ss.print(arr);
    }
}
