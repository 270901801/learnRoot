package designmode.creation.prototype;

import java.util.Date;

/**
 * @author hsc
 * @date 2019-11-04 22:48:00
 */
public class Client {
    public static void main(String[] args) {
        Sheep sheep=new Sheep("shaoli",new Date());
        System.out.println(sheep);
    }
}
