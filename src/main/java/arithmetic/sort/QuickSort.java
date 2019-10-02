package arithmetic.sort;

import org.junit.Test;

/**快速排序：
 * 基本思想：选择一个基准数，通过一趟排序将要排序的数据分割成独立的两部分；其中一部分的所有数据都比另外一部分的所有数据都要小。然后，再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 * 排序流程：(1) 从数列中挑出一个基准值。
 *           (2) 将所有比基准值小的摆放在基准前面，所有比基准值大的摆在基准的后面(相同的数可以到任一边)；在这个分区退出之后，该基准就处于数列的中间位置。
 *           (3) 递归地把"基准值前面的子数列"和"基准值后面的子数列"进行排序。
 * @author hsc
 * @date 2019/8/21 - 19:13
 */
public class QuickSort extends Sort {

    /**
     *
     * @param arr   待排序的数组
     * @param l     数组的左边界 l=0
     * @param r     数组的右边界  r=arr.length-1
     */
    public void quickSort(int[] arr,int l,int r){
        if (l<r){
            int i,j,x;
            i=l;
            j=r;
            x=arr[i];
            while (i<j){
                while (i<j&&arr[j]>x){
                    j--;// 从右向左找第一个小于x的数
                }
                if(i<j){
                    arr[i++]=arr[j];
                }
                while (i<j&&arr[i]<x){
                    i++;// 从左向右找第一个大于x的数
                }
                if (i<j){
                    arr[j--]=arr[i];
                }
            }
            arr[i]=x;
            quickSort(arr,l,i-1);/* 递归调用 */
            quickSort(arr,i+1,r);/* 递归调用 */
        }
    }
    @Test
    public void test(){
        long start=System.currentTimeMillis();
        QuickSort ss=new QuickSort();
        ss.quickSort(arr,0,arr.length-1);
        ss.print(arr);
        System.out.println();
        System.out.println("运行时间"+(System.currentTimeMillis()-start));
    }
}
