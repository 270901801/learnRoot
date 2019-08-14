package arithmetic.sort;

/**
 * @author hsc
 * @date 2019/8/14 - 12:35
 */
public abstract class Sort {
    public int[] arr={1,4,2,1,6,3};
    public void sort(int [] arr){

    }
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void print(int []arr){
        System.out.print("[");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.print("]");
    }
}
