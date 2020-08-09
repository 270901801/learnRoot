package chunzhaoTest.xiecheng;

import sun.security.util.BitArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 6
 * 0,30
 * 0,50
 * 10,20
 * 15,30
 * 20,50
 * 20,65
 *
 * 5
 * @author hsc
 * @date 2020-04-01 19:23:02
 */
public class test1 {

    static int calcMinStaff(int [][]time) {
        int num=1;
        int[] list=new int[time.length+1];
        list[0]=0;
        for (int i=0;i<time.length;i++){
            for (int val:list){
                int j=0;
                if (time[i][0]<val){
                    num++;
                    break;
                }
                list[i]=time[i][1];
                if (val==0)break;
                if (i==time.length-1)
                    break;
            }
        }
        return num;
    }


    public static void main(String[] args){
        int res;
        Scanner in = new Scanner(System.in);
        int num=in.nextInt();
        int i=0;
        int [][]time=new int[num][2];
        System.out.println("num:"+num);
        while (num>i){
            String input=in.next();
            time[i][0]=Integer.valueOf(input.split(",")[0]);
            time[i][1]=Integer.valueOf(input.split(",")[1]);
            i++;
        }
//        int [][]time={{0,30},{0,50},{10,20},{15,30},{20,50},{20,65}};
        res = calcMinStaff(time);
        System.out.println(res);

    }
}
