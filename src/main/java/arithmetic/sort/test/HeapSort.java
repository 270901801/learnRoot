package arithmetic.sort.test;

import arithmetic.sort.Sort;
import org.junit.Test;

/**
 * @author hsc
 * @date 2020-03-18 20:01:17
 */
public class HeapSort extends Sort {
    public void sort(int[] arr){
        int length=arr.length;
        buildHeap(arr,length);
        for (int i=length-1;i>0;i--){
            swap(arr,0,i);
            sink(arr,0,--length);
        }
    }

    public void buildHeap(int[] arr,int length){
        for (int i=length/2;i>=0;i--){
            sink(arr,i,length);
        }
    }

    public void sink(int[] arr,int target,int length){
        int leftChild=2*target+1;
        int rightChild=2*target+2;
        int present=target;

        if(leftChild<length && arr[present]<arr[leftChild]){
            present=leftChild;
        }

        if (rightChild<length && arr[present]<arr[rightChild]){
            present=rightChild;
        }

        if (present!=target){
            swap(arr,target,present);
            sink(arr,present,length);
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
