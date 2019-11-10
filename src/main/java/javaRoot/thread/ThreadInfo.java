package javaRoot.thread;

/**线程的其他方法
 * Thread.currentThread单钱线程
 * setName getName 设置代理名称
 *
 * @author hsc
 * @date 2019-11-04 20:12:52
 */
public class ThreadInfo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().isAlive());
        MyInfo myInfo=new MyInfo("战斗机");
        Thread thread=new Thread(myInfo);
        thread.setName("公鸡");
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.isAlive());
    }
}
class MyInfo implements Runnable{

    private String name;
    public MyInfo(String name){
        this.name=name;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+name);
    }
}
