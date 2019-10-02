package arithmetic.sort;

import org.junit.Test;

/**桶排序：
 * 基本思想：假设待排序的数组a中共有N个整数，并且已知数组a中数据的范围[0, MAX)。在桶排序时，创建容量为MAX的桶数组r，并将桶数组元素都初始化为0；将容量为MAX的桶数组中的每一个单元都看作一个"桶"。
 *          在排序时，逐个遍历数组a，将数组a的值，作为"桶数组r"的下标。当a中数据被读取时，就将桶的值加1。例如，读取到数组a[3]=5，则将r[5]的值+1。
 * 排序流程：
 * @author hsc
 * @date 2019/8/21 - 19:59
 */
public class BucketSort extends Sort {
    public void sort(int[] arr,int len,int max){
        int [] tmp=new int[max+1];
        for (int i=0;i<arr.length;i++){
            tmp[arr[i]]++;
        }
        print(tmp);
        System.out.println();
        int j=0;
        for (int i=0;i<tmp.length;i++){
            while (tmp[i]>0){
                arr[j++]=i;
                tmp[i]--;
            }
        }
    }

    @Test
    public void test(){
        BucketSort bs=new BucketSort();
//        int arr[]={2,4,2,5,6,4,2,1};
        bs.sort(arr,1000,999);
        bs.print(arr);
    }
}
