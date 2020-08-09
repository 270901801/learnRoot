package arithmetic.sort.test;

import arithmetic.sort.SortUtil;

import java.util.Arrays;
import java.util.Date;

/**
 * @author hsc
 * @date 2020-03-14 16:25:51
 */
public class QuickSort {
        public static int[] sort(int[] arr,int l,int r){
            if(l<r){
                int i,j,x;
                i=l;
                j=r;
                x=arr[i];
                while(i<j){
                    while (i<j&&arr[j]>x){
                        j--;
                    }
                    if(i<j){
                        arr[i++]=arr[j];
                    }
                    while (i<j&&arr[i]<x){
                        i++;
                    }
                    if(i<j){
                        arr[j--]=arr[i];
                    }
                }
                arr[i]=x;
                sort(arr,l,i-1);
                sort(arr,i+1,r);
            }
            return arr;
        }

    public static void main(String[] args) {
        int[] arr=SortUtil.luan(1000);
        long start=System.currentTimeMillis();
        arr=sort(arr,0,arr.length-1);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        long end=System.currentTimeMillis();
        System.out.println();
        System.out.println("during_time:"+(end-start));
    }
}
