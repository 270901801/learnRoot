package designmode.bridge;

/**
 * @author hsc
 * @date 2019/8/19 - 23:10
 */
public class Client {
    public static void main(String[] args) {
        //销售联想的笔记本电脑
        Computer2 computer2=new Laptop2(new Lenovo());
        computer2.sale();

        //销售神州的台式机
        Computer2 computer3=new Desktop2(new Shenzhou());
        computer3.sale();
    }
}
