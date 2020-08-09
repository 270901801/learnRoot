package arithmetic.sort.test;

/**
 * @author hsc
 * @date 2020-03-14 22:51:03
 */
public class BinSearch {

    public static int search(int[] arr,int a){
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if (arr[mid]==a){
                return mid;
            }else if(arr[mid]>a){
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={1,2,2,3,5,8,45};
        System.out.println(search(arr, 3));
    }
}
