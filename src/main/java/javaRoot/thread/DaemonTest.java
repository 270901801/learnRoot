package javaRoot.thread;

/**守护线程：是为用户线程服务的；jvm停止不用等待守护线程执行完毕
 * 默认：用户线程jvm停止等待用户线程执行完毕才会停止
 * @author hsc
 * @date 2019-11-04 19:58:54
 */
public class DaemonTest {
    public static void main(String[] args) {
        God god=new God();
        You you=new You();
        Thread thread=new Thread(god);
        thread.setDaemon(true);
        thread.start();
        new Thread(you).start();
    }

}
class You implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<365*100;i++){
            System.out.println("happy life..");
        }
        System.out.println("oooooo...");
    }
}
class God implements Runnable{
    @Override
    public void run() {
        for (;true;){
            System.out.println("bless you...");
        }
    }
}