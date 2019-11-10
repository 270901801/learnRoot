package designmode.creation.singleton;

/**测试懒汉单例模式
 * 优点：延迟加载，懒加载，真正用的时候才加载，节约资源，资源利用率高
 * 缺点：每次调用getInstance()方法都要同步，并发效率低
 * @author hsc
 * @date 2019/8/20 - 19:11
 */
public class SingletonDemo2 {
    private static SingletonDemo2 instance;

    private SingletonDemo2(){}

    public static synchronized SingletonDemo2 getInstance(){
        if(instance==null){
            instance=new SingletonDemo2();
        }
        return instance;
    }
}
