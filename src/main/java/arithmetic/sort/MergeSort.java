package arithmetic.sort;

import org.junit.Test;

/**归并排序的思想是将数组分成两部分，分别进行排序，然后归并起来
 * 归并方法将数组中两个已经排序的部分归并成一个
 * @author hsc
 * @date 2019/8/20 - 23:05
 */
public class MergeSort extends Sort{

    /**
     * 将一个数组中的两个相邻有序区间合并成一个
     * @param a         包含两个有序区间的数组
     * @param start     第一个有序区间的起始地址
     * @param mid       第一个有序区间的结束地址。也是第二个有序区间的起始地址
     * @param end       第二个有序区间的结束地址
     */
    public void merge(int[] a,int start,int mid,int end){
        //tmp是汇总2个有序区间的临时区域
        int[] tmp=new int[end-start+1];
        //第一个有序区间的索引
        int i=start;
        //第二个有序区间的索引
        int j=mid+1;
        //临时区域的索引
        int k=0;
        //80,30,60,40 ,20,10,50,70
        //30,40,60,80  10,20,50,70//i=1,j=2
        //10,20,30,40,50,60,70
        //
        while (i<=mid&&j<=end){
            //将两个有序区间的较小的放到tmp，会剩余一个最大的数没有存进来
            if(a[i]<=a[j]){
                tmp[k++]=a[i++];
            }else {
                tmp[k++]=a[j++];
            }
        }
        //这两个循环是将最后一个大数存到tmp后面
        while (i<=mid){
            tmp[k++]=a[i++];
        }
        while (j<=end){
            tmp[k++]=a[j++];
        }
        //将排序后的元素，全部都整合到数组a中
        for(i=0;i<k;i++){
            a[start+i]=tmp[i];
        }
        tmp=null;
    }

    /**
     * 对数组a做若干次合并：数组a的总长度为len，将它分为若干个长度为gap的子数组；
     * 将“每2个相邻的子数组”进行合并排序
     * @param a         待排序的数组
     * @param len     数组的长度
     * @param gap       子数组的长度
     */
    public void mergeGroups(int[] a,int len,int gap){
        int i;
        //两个相邻的子数组的长度
        int twolen=2*gap;
        //将“每2个相邻的子数组”进行合并排序
        for (i=0;i+2*gap-1<len;i+=(2*gap)){
            merge(a,i,i+gap-1,i+2*gap-1);
        }
        //若i+gap-1<len-1,则剩余一个子数组没有配对。
        //将该子数组合并到已排序的数组中
        if (i+gap-1<len-1){
            merge(a,i,i+gap-1,len-1);
        }
    }

    /**
     * 归并排序（从下往上）
     * @param a     待排序的数组
     */
    public void mergeSortDown2Up(int []a){
        if (a==null){
            return;
        }
        for (int i=1;i<a.length;i*=2){
            mergeGroups(a,a.length,i);
        }
    }
    @Test
    public void test(){
        MergeSort ss=new MergeSort();
        ss.mergeSortDown2Up(arr);
        ss.print(arr);
//        System.out.println("总共交换的次数"+count);
    }

}
