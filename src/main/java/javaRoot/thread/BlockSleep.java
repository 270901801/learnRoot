package javaRoot.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * 静态方法
 * @author hsc
 * @date 2019-11-03 23:29:22
 */
public class BlockSleep  {
    public static void main(String[] args) throws InterruptedException {
        //倒计时
        Date endTime=new Date(System.currentTimeMillis()+1000*10);
        long end=endTime.getTime();
        while(true){
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            Thread.sleep(1000);
            endTime=new Date(endTime.getTime()-1000);
            if(end-10000>endTime.getTime()){
                System.out.println("倒计时结束！");
                break;
            }
        }
    }
}
