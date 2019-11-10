package designmode.creation.factory.simplefactory;

/**测试没有用工厂模式的情况
 * @author hsc
 * @date 2019/8/21 - 21:33
 */
public class Client1 {//调用者
    public static void main(String[] args) {
        Car c1=new Audi();
        Car c2=new Byd();
        c1.run();
        c2.run();
    }

}
