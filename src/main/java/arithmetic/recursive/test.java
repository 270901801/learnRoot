package arithmetic.recursive;

import arithmetic.sort.SortUtil;

/**
 * @author hsc
 * @date 2020-06-29 21:26:32
 */
public class test {
   public static void sort(int[] A, int lo, int hi) {
      // 判断是否只剩下最后一个元素
      if (lo >= hi) return;

      // 从中间将数组分成两个部分
      int mid = lo + (hi - lo) / 2;

      // 分别递归地将左右两半排好序
      sort(A, lo, mid);
      sort(A, mid + 1, hi);
    
      // 将排好序的左右两半合并
      merge(A, lo, mid, hi);
    }
    public static void merge(int[] nums, int lo, int mid, int hi) {
        // 复制一份原来的数组
        int[] copy = nums.clone();

        // 定义一个 k 指针表示从什么位置开始修改原来的数组，i 指针表示左半边的起始位置，j 表示右半边的起始位置
        int k = lo, i = lo, j = mid + 1;

        while (k <= hi) {
            if (i > mid) {
                nums[k++] = copy[j++];
            } else if (j > hi) {
              nums[k++] = copy[i++];
            } else if (copy[j] < copy[i]) {
              nums[k++] = copy[j++];
            } else {
              nums[k++] = copy[i++];
            }
        }
    }

    public static void main(String[] args) {

       int [] nums={2,1,3,2,6,8,5};
       sort(nums,0,6);
//       System.out.println(nums);
        SortUtil.print(nums);
    }
}
