package javaRoot.thread.game;

/**
 * @author hsc
 * @date 2019-11-04 18:57:42
 */
public class BlockJoin {
    public static void main(String[] args) {
        System.out.println("儿子给爸爸买烟的故事");
        new Thread(new Father()).start();
    }


}

class Father implements Runnable{
    @Override
    public void run() {
        System.out.println("想抽烟，发现烟没了");
        System.out.println("叫儿子去买烟");
        Son son=new Son();
        Thread thread=new Thread(son);
        thread.start();
        try {
            thread.join();
            System.out.println("父亲接过烟，把零钱给了儿子");
        } catch (InterruptedException e) {
            System.out.println("赶紧去找儿子");
            e.printStackTrace();
        }
    }
}
class Son implements Runnable{
    @Override
    public void run() {
        System.out.println("儿子接到钱去买烟");
        System.out.println("路过一家游戏厅");
        System.out.println("走进游戏厅");
        for (int i=1;i<11;i++){
            System.out.println(i+"小时过去了..");
            try {
                Thread.sleep(1000);
                if(i==5){
                    throw new InterruptedException("儿子走丢了");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("赶紧起去买烟");
        System.out.println("手拿一包中华回家");
    }
}