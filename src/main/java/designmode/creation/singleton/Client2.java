package designmode.creation.singleton;

import java.util.concurrent.CountDownLatch;

/**并发环境下五种创建单例模式的效率
 *
 * @author hsc
 * @date 2019/8/20 - 20:38
 */
public class Client2 {
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        int threadNum=10;
        //启动线程计数器
        final CountDownLatch countDownLatch=new CountDownLatch(threadNum);
        for (int i=0;i<threadNum;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<10000000;i++){
                        Object o=SingletonDemo5.INSTANCE;
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
//        //设置一个循环一直等到上面的线程执行完后再执行main方法线程
//        while (){
//
//        }

        //CountDownLatch,同步辅助类，在完成一组正在其他线程中执行的操作之前，他允许一个或多个线程一直等待。
        //main线程阻塞，知道计算器变为0，才会继续往下执行！
        countDownLatch.await();
        long end=System.currentTimeMillis();
        System.out.println("总耗时："+(end-start));

    }
}
