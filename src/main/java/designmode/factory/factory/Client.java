package designmode.factory.factory;

/**
 * @author hsc
 * @date 2019/8/21 - 22:15
 */
public class Client {
    public static void main(String[] args) {
        Car c1=new AudiFactory().createCar();
        Car c2=new BenzFactory().createCar();
        Car c3=new BydFactory().createCar();

        c1.run();
        c2.run();
        c3.run();

    }
}
