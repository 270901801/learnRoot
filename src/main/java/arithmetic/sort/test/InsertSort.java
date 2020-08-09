package arithmetic.sort.test;

import arithmetic.sort.Sort;
import org.junit.Test;

/**
 * @author hsc
 * @date 2020-03-18 20:14:35
 */
public class InsertSort extends Sort {

    public void sort(int[] arr){
        for (int i=0;i<arr.length;i++){
            for (int j=i;j>0&&arr[j]<arr[j-1];j--){
                swap(arr,j,j-1);
            }
        }
    }

    @Test
    public void test(){
        print(arr);
        System.out.println();
        System.out.println("排序后");
        sort(arr);
        print(arr);
    }
}
