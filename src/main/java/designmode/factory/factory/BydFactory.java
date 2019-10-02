package designmode.factory.factory;

/**
 * @author hsc
 * @date 2019/8/21 - 22:11
 */
public class BydFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Byd();
    }
}
