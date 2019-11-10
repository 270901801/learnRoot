package designmode.creation.singleton;

/**枚举类单例模式
 * 优点：1.实现简单
 *       2. 枚举本身就是单利面试。由jvm从根本上提供保障！
 *       3.避免通过反射和反序列化的漏洞！
 * 缺点：无延迟加载
 * @author hsc
 * @date 2019/8/20 - 19:35
 */
public enum SingletonDemo5 {
    /**
     * 定义一个枚举的元素，他就代表了Singleton的一个实例。
     *
     */
    INSTANCE;

    public void singletonOperation(){
        //功能处理
    }

    public static void main(String[] args) {
        SingletonDemo5 sd=SingletonDemo5.INSTANCE;
        SingletonDemo5 sd2=SingletonDemo5.INSTANCE;
        System.out.println(sd == sd2);
    }
}
