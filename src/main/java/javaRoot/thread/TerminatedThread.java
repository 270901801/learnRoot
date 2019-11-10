package javaRoot.thread;

/**
 * 线程的状态
 * 终止线程：
 * 1、线程正常执行完毕-->次数
 * 2、外部干涉-->加入标识
 * 不要使用stop，destory 不安全
 * @author hsc
 * @date 2019-11-03 22:58:24
 *
 */
public class TerminatedThread implements Runnable{
    private String name;
    private boolean flag=true;

    public TerminatedThread(String name) {
        this.name = name;
    }
    public void terminate(){
        this.flag=false;
    }

    @Override
    public void run() {
        int i=100;
        System.out.println("123");
        while(flag){
            System.out.println(name+"--->"+i--);
        }
    }

    public static void main(String[] args) {
        TerminatedThread terminatedThread=new TerminatedThread("hello");
        new Thread(terminatedThread).start();
        for (int i=0;i<100;i++){
            if(i==88){
                terminatedThread.terminate();
                System.out.println("game over");
            }
            System.out.println("main--->"+i);
        }
    }



}
