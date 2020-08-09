package arithmetic.sort;

import java.util.Arrays;

/**二分查找
 * https://www.cnblogs.com/coderising/p/5708632.html
 * @author hsc
 * @date 2020-03-14 22:12:10
 */
public class BinSearch {

    /**
     * 非递归
     * @param array
     * @param a
     * @return
     */
    public static int biSearch(int []array,int a){
        int lo=0;
        int hi=array.length-1;
        int mid;
        while(lo<=hi){
            mid=(lo+hi)/2;
            if(array[mid]==a){
                return mid;
            }else if(array[mid]<a){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return -1;
    }

    /**
     * 递归实现   时间复杂度为 O(logN)
     * @param arr
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int biSearch(int []array,int a,int lo,int hi){
        if(lo<=hi){
            int mid=(lo+hi)/2;
            if(a==array[mid]){
                return mid;
            }
            else if(a>array[mid]){
                return biSearch(array,a,mid+1,hi);
            }else{
                return biSearch(array,a,lo,mid-1);
            }
        }
        return -1;
    }


    /**
     * 查找第一个出现的
     * @param array
     * @param a
     * @return
     */
    public static int biSearchFirst(int []array,int a){
        int n=array.length;
        int low=0;
        int hi=n-1;
        int mid=0;
        while(low<hi){
            mid=(low+hi)/2;
            if(array[mid]<a){
                low=mid+1;
            }else{
                hi=mid;
            }
        }
        if(array[low]!=a){
            return -1;
        }else{
            return low;
        }
    }

    /**
     * 查找最后一个出现的
     * @param array
     * @param a
     * @return
     */
    public static int biSearchLast(int []array,int a){
        int n=array.length;
        int low=0;
        int hi=n-1;
        int mid=0;
        while(low<hi){
            mid=(low+hi+1)/2;
            if(array[mid]<=a){
                low=mid;
            }else{
                hi=mid-1;
            }
        }

        if(array[low]!=a){
            return -1;
        }else{
            return hi;
        }
    }



    public static void main(String[] args) {
        int[] arr={1,1,2,3,4,5,5,6,6,7};//SortUtil.luan(100);
//        Arrays.asList(arr).forEach(item->System.out.println(item));
        for (int i:arr){
            System.out.print(i+",");
        }
        System.out.println();
        System.out.println(biSearch(arr, 5));
        System.out.println(biSearch(arr, 5,0,arr.length));
        System.out.println(biSearchFirst(arr, 5));
        System.out.println(biSearchLast(arr, 5));
//        Integer[] items = {1, 2, 3};
//
//        // 普通for循环遍历
//        System.out.println("第一种方式：普通for循环遍历 Array 数组");
//        for (int i = 0; i < items.length; i++) {
//            System.out.println(items[i]);
//        }
//
//        // 增强for循环遍历
//        System.out.println("\n第二种方式：增强for循环遍历 Array 数组");
//        for (Integer item : items) {
//            System.out.println(item);
//        }
//
//        // Lambda 表达式遍历（JDK 1.8）
//        System.out.println("\n第三种方式：Lambda 表达式遍历 Array 数组");
//        Arrays.asList(items).forEach(item -> System.out.println(item));
//
//        // Lambda 表达式遍历（JDK 1.8）
//        System.out.println("\n第四种方式：Lambda 表达式遍历 Array 数组");
//        Arrays.asList(items).forEach(System.out::println);
    }
}
