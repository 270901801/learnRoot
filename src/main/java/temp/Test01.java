package temp;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test01 {

    public static int getDay(String date){
        int num=0;
        int year=Integer.valueOf(date.substring(0,4));
        int month=Integer.valueOf(date.substring(4,6));
        int day=Integer.valueOf(date.substring(6,8));
        int[] run={31,29,31,30,31,30,31,31,30,31,30,31};
        int[] nrun={31,28,31,30,31,30,31,31,30,31,30,31};
        if ((year%400==0)||(year%4==0&&year%100!=0)){
            for (int i=0;i<month-1;i++){
                num+=run[i];
            }
            num+=day;
        }else{
            for (int i=0;i<month-1;i++){
                num+=nrun[i];
            }
            num+=day;
        }
//        Date date1=new Date(year,month,day);
//        System.out.printf("%d,%d,%d",year,month,day);
//        System.out.println();
//        num=date1.getDay();
        return num;
    }

    public static void main(String[] args) throws ParseException {
//        String date="20201231";
//        System.out.println(date+"是第"+getDay(date)+"天");

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年月日：");
        String d = sc.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = sdf.parse(d);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        System.out.println(c.get(Calendar.DAY_OF_YEAR));


    }

    @Test
    public void test() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年月日：");
        String d = sc.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = sdf.parse(d);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        System.out.println(c.get(Calendar.DAY_OF_YEAR));
    }
}