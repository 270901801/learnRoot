package arithmetic.sort;

import static arithmetic.sort.SortUtil.luan;

/**
 * @author hsc
 * @date 2019/8/14 - 12:35
 */
public abstract class Sort {
    public int count=0;
    public int[] arr=luan(100);
    public void sort(int [] arr){

    }
    public void swap(int[] arr,int i,int j){
        count++;
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void print(int []arr){
        System.out.print("[");
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1){
                System.out.print(arr[i]);
            }else {
                System.out.print(arr[i]+",");
            }
        }
        System.out.print("]");
    }
}
