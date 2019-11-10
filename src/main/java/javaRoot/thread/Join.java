package javaRoot.thread;

/**Join:合并线程，插队线程
 * 对象方法
 * @author hsc
 * @date 2019-11-04 18:52:01
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {

//        MyYield myYield=new MyYield();
//        new Thread(myYield,"test1").start();
//        new Thread(myYield,"test2").start();
        Thread t=new Thread(()->{
            for(int i=0;i<100;i++){
                System.out.println("lamda"+i);
            }
        });
        t.start();
        for(int i=0;i<100;i++){
            if(i==20){
                t.join();//插队 main被阻塞
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
