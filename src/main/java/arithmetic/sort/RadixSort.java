package arithmetic.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**基数排序
 * https://www.cnblogs.com/fengyumeng/p/10994279.html
 * @author hsc
 * @date 2020-03-14 21:45:50
 */
public class RadixSort extends Sort{

    public void sort(int[] arr){
        //找出最大数
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        //当前排序的位置
        int location=1;
        //桶列表
        List<List<Integer>> bucketList=new ArrayList<>();
        for (int i=0;i<10;i++){
            bucketList.add(new ArrayList<>());
        }

        while (true){
            //判断是否排完
            int dd= (int) Math.pow(10,location-1);
            if (max<dd){
                break;
            }

            //将数据放入具体的桶中
            for(int i=0;i<arr.length;i++){
                //计算余数
                int num=(arr[i]/dd)%10;
                bucketList.get(num).add(arr[i]);
            }

            //按桶的数组的顺序放入原数组中
            int index=0;
            for (int i=0;i<10;i++){
                //
                for (int j=0;j<bucketList.get(i).size();j++){
                    arr[index++]=bucketList.get(i).get(j);
                }
                bucketList.get(i).clear();
            }
            location++;
        }
        //
    }

    @Test
    public void test(){
        RadixSort rs=new RadixSort();
//        int arr[]={2,4,2,5,6,4,2,1};
        rs.sort(arr);
        rs.print(arr);
    }
}
