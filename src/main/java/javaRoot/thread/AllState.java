package javaRoot.thread;

/**观察线程的状态
 * @author hsc
 * @date 2019-11-04 19:24:26
 */
public class AllState {
    public static void main(String[] args) {
        Thread thread=new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(100);
                    System.out.println("...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //观察状态
        Thread.State state= thread.getState();
        System.out.println(state);//new
        thread.start();
        state= thread.getState();
        System.out.println(state);//runnable <就绪，running>


        /*while (state!=Thread.State.TERMINATED){//TERMINATED
            try {
                Thread.sleep(200);
                state= thread.getState();
                System.out.println(state);//timed_waiting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        while (true){
            try {
                Thread.sleep(200);
                int num=Thread.activeCount();
                System.out.println(num);
                state= thread.getState();
                System.out.println(state);//timed_waiting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
