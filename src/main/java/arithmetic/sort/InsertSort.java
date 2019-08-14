package arithmetic.sort;

import org.junit.Test;

/**插入排序
 * @author hsc
 * @date 2019/8/14 - 12:34
 */
public class InsertSort extends Sort{
    @Override
    public void sort(int[] arr) {
        for (int i=1;i<arr.length;i++){
            for (int j=i;j>0&&(arr[j]<arr[j-1]);j--){
                  swap(arr,j,j-1);
            }
        }
    }

    @Test
    public void test() {
        InsertSort is=new InsertSort();
        is.sort(arr);
        is.print(arr);
    }
}
