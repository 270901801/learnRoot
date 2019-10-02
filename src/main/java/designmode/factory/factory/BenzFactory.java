package designmode.factory.factory;

/**
 * @author hsc
 * @date 2019/8/21 - 22:13
 */
public class BenzFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Benz();
    }
}
