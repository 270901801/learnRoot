package designmode.creation.factory.simplefactory;

/**简单工厂模式情况
 * @author hsc
 * @date 2019/8/21 - 21:50
 */
public class Client2 {
    public static void main(String[] args) {
        Car c1=CarFactory.createCar("Byd");
        Car c2=CarFactory.createCar("Audi");
        c1.run();
        c2.run();
    }
}
