package designmode.singleton;

/**静态内部类（也是一种懒加载方式）
 * 优点：1.外部类没有static属性，不会像饿汉式那样立即加载对象
*      2.调用了getInstance（）才会加载静态内部类。加载类是线程安全的。
*      instance是static final类型，保证了内存中只有这样一个实例存在，而且只能被
*      赋值一次，保证了线程安全性
*      3.兼备了并发高效调用和延迟加载的优势！
 * 缺点：
 * @author hsc
 * @date 2019/8/20 - 19:26
 */
public class SingletonDemo4 {
    private static class SingletonClassInstance{
        private static final SingletonDemo4 instance=new SingletonDemo4();
    }
    private SingletonDemo4(){}
    public static SingletonDemo4 getInstance(){
        return SingletonClassInstance.instance;
    }

}
