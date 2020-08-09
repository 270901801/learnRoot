package chunzhaoTest.chuangling;

import arithmetic.sort.SortUtil;
import org.junit.Test;

import java.util.Scanner;

import static sun.misc.Version.print;

/**
 *
 * 小明的女朋友最喜欢在网上买买买了，可是钱包里钞票有限，不能想买啥就买啥。面对琳琅满目的物品，她想买尽可能多的种类，每种只买一件，同时总价格还不能超过预算上限。于是她请小明写程序帮她找出应该买哪些物品，并算出这些物品的总价格。
 *
 * 输入规范：
 * 每个输入包含两行。第一行是预算上限。第二行是用空格分隔的一组数字，代表每种物品的价格。所有数字都为正整数并且不会超过10000。
 *
 * 输出规范：
 * 对每个输入，输出应买物品的总价格。
 *
 * 输入示例1:
 * 100
 * 50 50
 * 输出示例1:
 * 100
 *
 * 输入示例2:
 * 188
 * 50 42 9 15 105 63 14 30
 * 输出示例2:
 * 160
 *
 * @author hsc
 * @date 2020-04-05 18:26:13
 */
public class test1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.println("输入上限:");
        int limit=scanner.nextInt();
        System.out.println("输入物品单价：");
        String str=scanner.next();
        String [] temp=str.split(" ");
        int [] place=new int[temp.length];
        for(int i=0;i<place.length;i++){
            place[i]=Integer.valueOf(temp[i]);
        }
        for(int i=place.length;i>0;i--){
            boolean flag=false;
            for(int j=0;j<i-1;j++){
                if (place[j]>place[j+1]){
                    int temp1=place[j];
                    place[j]=place[j+1];
                    place[j+1]=temp1;
                    flag=true;
                }
            }
            if (!flag){
                break;
            }
        }
        int money=0;
        for (int i=0;i<place.length;i++){
            if ((money+place[i])<limit){
                money+=place[i];
            }else{
                break;
            }
        }
        System.out.println(money);
    }

    @Test
    public void test(){
    }

}
