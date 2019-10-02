package designmode.factory.factory;

/**
 * @author hsc
 * @date 2019/8/21 - 22:10
 */
public class AudiFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Audi();
    }
}
