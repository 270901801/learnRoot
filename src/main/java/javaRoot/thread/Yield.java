package javaRoot.thread;

/**yield礼让线程 重回就绪状态 不是阻塞状态
 * 静态方法
 * @author hsc
 * @date 2019-11-03 23:40:06
 */
public class Yield {
    public static void main(String[] args) {

//        MyYield myYield=new MyYield();
//        new Thread(myYield,"test1").start();
//        new Thread(myYield,"test2").start();
        new Thread(()->{
            for(int i=0;i<100;i++){
                System.out.println("lamda"+i);
            }
        }).start();
        for(int i=0;i<100;i++){
            if(i%13!=0){
                Thread.yield();
            }
            System.out.println("main"+i);
        }

    }
    static class MyYield implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"-->start");
            System.out.println(Thread.currentThread().getName()+"-->end");
        }
    }
}
