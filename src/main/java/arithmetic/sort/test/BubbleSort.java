package arithmetic.sort.test;

import arithmetic.sort.SortUtil;

/**
 * @author hsc
 * @date 2020-03-14 16:57:52
 */
public class BubbleSort {
    public static void sort(int[] arr){
        for (int i=0;i<arr.length;i++){
            boolean flag=false;
            for (int j=1;j<arr.length-i;j++){
                if (arr[j-1]>arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    flag=true;
                }
            }
            if (!flag){
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr=SortUtil.luan(100000);
        long start=System.currentTimeMillis();
        sort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        long end=System.currentTimeMillis();
        System.out.println();
        System.out.println("during_time:"+(end-start));
    }
}
