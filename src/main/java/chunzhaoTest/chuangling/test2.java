package chunzhaoTest.chuangling;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * \
 *
 *
 * 李雷和韩梅梅坐前后排，上课想说话怕被老师发现，所以改为传小纸条。为了不被老师发现他们纸条上说的是啥，他们约定了如下方法传递信息：
 * 将26个英文字母（全为大写），外加空格，一共27个字符分成3组，每组9个。也就是ABCDEFGHI是第一组，JKLMNOPQR是第二组，STUVWXYZ*是第三组（此处用*代表空格）。
 * 然后根据传递纸条那天的日期，改变字母的位置。
 * 先根据月份数m，以整个分组为单位进行循环左移，移动(m-1)次。
 * 然后根据日期数d，对每个分组内的字符进行循环左移，移动(d-1)次。
 * 以3月8日为例，首先移动分组，3月需要循环左移2次，变成：
 * STUVWXYZ*，ABCDEFGHI，JKLMNOPQR
 * 然后每组内的字符，8日的话需要循环左移7次，最终的编码为：
 * Z*STUVWXY，HIABCDEFG，QRJKLMNOP
 * 对于要传递信息中的每个字符，用组号和组内序号两个数字来表示。
 * 如果在3月8日传递信息“HAPPY”，那么H位于第2组的第1个，A位于第2组第3个，P位于第3组第9个，Y位于第1组第9个，所以纸条上会写成：
 * 21 23 39 39 19
 * 现在给定日期和需要传递的信息，请输出应该写在纸条上的编码。
 *
 * 输入规范：
 * 每个输入包含两行。第一行是用空格分隔的两个数字，第一个数字是月份，第二个数字是日子。输入保证是一个合法的日期。
 * 第二行为需要编码的信息字符串，仅由A~Z和空格组成，长度不超过1024个字符。
 *
 * 输出规范：
 * 对每个输入，打印对应的编码，数字之间用空格分隔，每个输出占一行。
 *
 * 输入示例1:
 * 1 1
 * HI
 * 输出示例1:
 * 18 19
 *
 * 输入示例2:
 * 3 8
 * HAPPY
 * 输出示例2:
 * 21 23 39 39 19
 *
 * 输入示例3:
 * 2 14
 * I LOVE YOU
 * 输出示例3:
 * 35 25 18 12 29 31 25 23 12 28
 *
 *
 * @author hsc
 * @date 2020-04-05 18:26:22
 */
public class test2 {
    public static void main(String[] args) {
        System.out.println("请输入日期（例如：2,2）：");
        Scanner input=new Scanner(System.in);
        String in=input.next();
        int mon=Integer.valueOf(in.split(",")[0]);
        int day=Integer.valueOf(in.split(",")[1]);
        System.out.println("请输入带编码的信息：");
        String word=input.next();
        List<Integer> list=convert(mon-1,day-1,word);
        System.out.println(list);
    }

    public static List<Integer> convert(int mon,int day,String word){
        List<Integer> list=new ArrayList<>();
        char[] coder=new char[27];
        int start=65;
        for (int i=0;i<coder.length;i++){
            coder[i]=(char) start++;
        }
        coder[26]='*';
        //以月份左移，整体左移
        coder=move_left(coder,0,coder.length-1,mon*9);
        for (char c : coder){
            System.out.print(c+" ");
        }
        System.out.println();
        //以天数左移，分组左移
        coder=move_left(coder,0,8,day);
        coder=move_left(coder,9,17,day);
        coder=move_left(coder,18,26,day);
        for (char c : coder){
            System.out.print(c+" ");
        }
        System.out.println();
        //查找每个信息字符的位置
        int index=0;
        for (int i=0;i<word.length();i++){
            for (int j=0;j<coder.length;j++){
                if (coder[j]==word.charAt(i)){
                    index=j;
                }
            }
//            index=Math.ceil((double) index/(double) 9)*10+index%10;
            list.add(index);
        }
        return list;
    }

    public static char[] move_left(char[] arr,int start,int end,int steps){
        int length=end-start+1;
        for (int i=start;i<end-steps+1;i++){
            int oth=(i+steps)%length+start;
            char temp=arr[i];
            arr[i]=arr[oth];
            arr[oth]=temp;
        }
        return arr;
    }

    public static void swap(char[] arr,int a,int b){
        char temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void print(char[] chars){
        for (int i=0;i<chars.length;i++){
            System.out.print(chars[i]+",");
        }
        System.out.println();
    }

    public static char[] leftMove(char[] a,int n,int k){
        char[] s=new char[n];
        for(int i=0;i<n;i++){         //核心，中心思想
            s[i]=a[k];
            k++;
            if(k==6){
                k=0;
            }
        }
        for(int i=0;i<n;i++){
            a[i]=s[i];
        }
        System.out.print(a[0]);
        for(int i=1;i<n;i++){
            System.out.print(","+a[i]);
        }
        return a;
    }

    /*求逆算法*/
    public static char[] reverse(int a,int b,char[] str){
        char temp;
        while(true){
            temp =str[a];
            str[a]=str[b];
            str[b]=temp;
            a++;
            b--;
            if(a>=b)
                break;
        }
        return str;
    }
    public static char[] treverse(int n,char[] str){
        reverse(0,str.length-n-1,str);
        reverse(str.length-n,str.length-1,str);
        reverse(0,str.length-1,str);
        return str;
    }

    /*普通算法*/
//    public static char[] usually(int[] a,int n,int k) {
//        int[] s=new int[n];
//        for(int i=0;i<n;i++){         //核心，中心思想
//            s[i]=a[k];
//            k++;
//            if(k==6){
//                k=0;
//            }
//        }
//        for(int i=0;i<n;i++){
//            a[i]=s[i];
//        }
//        System.out.print(a[0]);
//        for(int i=1;i<n;i++){
//            System.out.print(","+a[i]);
//        }
//    }


    @Test
    public void test(){
//        System.out.println((char)65);
        char[] chars={'a','b','c','d','e','f'};
//        System.out.println(treverse(2,chars));
//        int v=1;
//        for (int i=0;i<chars.length;i++){
//            int n=(v+i)%chars.length;
//            char temp=chars[i];
//            chars[i]=chars[n];
//            chars[n]=temp;
//        }
        print(move_left(chars,3,5,1));
//        System.out.println(treverse(2,chars));
//        System.out.println(usually(1,chars));
    }
}
