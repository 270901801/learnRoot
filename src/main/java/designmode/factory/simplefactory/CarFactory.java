package designmode.factory.simplefactory;

/**
 * @author hsc
 * @date 2019/8/21 - 21:40
 */
public class CarFactory {
    public static Car createCar(String type){
        if ("奥迪".equals(type)){
            return new Audi();
        }else if("比亚迪".equals(type)){
            return new Byd();
        }else {
            return null;
        }
    }
    public static void main(String[] args) {

    }
}
