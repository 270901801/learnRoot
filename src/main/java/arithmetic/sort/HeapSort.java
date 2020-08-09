package arithmetic.sort;

import org.junit.Test;

/**堆排序
 * https://www.cnblogs.com/fengyumeng/p/10994279.html
 * @author hsc
 * @date 2019/8/23 - 22:47
 */
public class HeapSort extends Sort{

    public void sort(int[] arr){
        int length=arr.length;
        buildHeap(arr,length);
        for (int i=length-1;i>0;i--){
            //将堆顶元素和末尾元素交换
            swap(arr,0,i);
            //数组减1，隐藏末尾元素
            length--;
            //将堆顶元素下沉，目的是将最大元素上浮到堆顶
            sink(arr,0,length);
        }
    }

    /**
     * 构建堆
     * @param arr
     * @param length 数组范围
     */
    public void buildHeap(int[] arr,int length){
        for (int i=length/2;i>=0;i--){
            sink(arr,i,length);
        }
    }

    /**
     * 下沉调整
     * @param arr
     * @param target 调整位置，需要调整的位置
     * @param length 数组范围
     */
    public void sink(int[] arr,int target,int length){
        int leftChild = 2 * target+1;
        int rightChild = 2 * target+2;
        int present=target;//待调整的节点下标

        if (leftChild<length && arr[present]<arr[leftChild]){
            present=leftChild;
        }

        if (rightChild<length && arr[present]<arr[rightChild]){
            present=rightChild;
        }

        //发送上面两步调整时，
        if (present!=target){
//            int temp=arr[present];
//            arr[present]=arr[target];
//            arr[target]=temp;
            swap(arr,present,target);
            //继续下沉
            sink(arr,present,length);
        }
    }

    @Test
    public void test(){
        System.out.println("排序前");
        print(arr);
        sort(arr);
        System.out.println("排序后");
        print(arr);
    }
}
