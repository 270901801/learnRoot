package javaRoot.thread;

/**线程的优先级1-10：
 * 1,NORM_PRIORITY 5 默认
 * 2,MIN_PRIORITY 0
 * 3,MAX_PRIORITY 10
 * 概率，不代表绝对的先后顺序
 * @author hsc
 * @date 2019-11-04 19:45:26
 */
public class PriorityTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());
        MyPriority myPriority=new MyPriority();
        Thread thread1=new Thread(myPriority);
        Thread thread2=new Thread(myPriority);
        Thread thread3=new Thread(myPriority);
        Thread thread4=new Thread(myPriority);
        Thread thread5=new Thread(myPriority);
        Thread thread6=new Thread(myPriority);

        //设置优先级在启动前
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread4.setPriority(Thread.MIN_PRIORITY);
        thread5.setPriority(Thread.MIN_PRIORITY);
        thread6.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());
    }
}
