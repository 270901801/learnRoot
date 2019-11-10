package designmode.creation.singleton;

/**测试饿汉单例模式
 * 特点：线程安全，方法没有同步调用效率高
 * 缺点：没有延时加载优势，浪费资源
 * @author hsc
 * @date 2019/8/20 - 19:07
 */
public class SingletonDemo1 {
    //类初始化时，立即加载
    private static SingletonDemo1 instance=new SingletonDemo1();
    private SingletonDemo1(){

    }
    public static SingletonDemo1 getInstance(){
        return  instance;
    }
}
