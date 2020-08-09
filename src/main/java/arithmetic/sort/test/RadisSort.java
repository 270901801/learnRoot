package arithmetic.sort.test;

import arithmetic.sort.SortUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static sun.misc.Version.print;

/**
 * @author hsc
 * @date 2020-03-18 18:44:24
 */
public class RadisSort {
    @Test
    public void sort(){
        int[] arr={2,4,1,5,7,434,121,4,11,44};
        int length=arr.length;
        int max=arr[0];
        for (int i=0;i<length;i++){
            if (max<arr[i]){
                max=arr[i];
            }
        }

        List<List<Integer>> bucketList=new ArrayList<>();
        for (int i=0;i<10;i++){
            bucketList.add(new ArrayList<>());
        }

        int location=1;
        while (true){
            int dd= (int) Math.pow(10,location-1);
            if (max<dd){
                break;
            }


            for (int i=0;i<length;i++){
                int num=(arr[i]/dd)%10;
                bucketList.get(num).add(arr[i]);
            }

            int index=0;
            for (int i=0;i<bucketList.size();i++){
                for (int j=0;j<bucketList.get(i).size();j++){
                    arr[index++]=bucketList.get(i).get(j);
                }
                bucketList.get(i).clear();
            }
            location++;
        }
        SortUtil.print(arr);
    }
}
