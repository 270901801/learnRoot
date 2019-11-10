package designmode.creation.singleton;

/**测试双重检测锁实现
 * 优点：将同步内容下方到if内部，提高了执行的效率不必每次获取对象时都进行同步，只有第一次才同步创建了以后就没必要了
 * 缺点：编译器优化原因和jvm底层内部模型原因，偶尔出问题，不建议使用
 * @author hsc
 * @date 2019/8/20 - 19:15
 */
public class SingletonDemo3 {
    private static SingletonDemo3 instance=null;
    private SingletonDemo3(){}
    public static SingletonDemo3 getInstance(){
        if(instance==null){
            SingletonDemo3 sc;
            synchronized (SingletonDemo3.class){
                sc=instance;
                if (sc==null){
                    synchronized (SingletonDemo3.class){
                        if (sc==null){
                            sc=new SingletonDemo3();
                        }
                    }
                    instance=sc;
                }
            }
        }
        return instance;
    }
}
