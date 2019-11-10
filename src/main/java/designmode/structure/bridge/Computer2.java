package designmode.structure.bridge;

/**电脑类型的另一个维度
 * @author hsc
 * @date 2019/8/19 - 23:06
 */
public abstract class Computer2 implements Brand {
    protected Brand brand;

    public Computer2(Brand brand){
        this.brand=brand;
    }

    public void sale(){
        brand.sale();
    }
}

class Desktop2 extends Computer2 {

    public Desktop2(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售台式机");
    }

}
class Laptop2 extends Computer2{

    public Laptop2(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售笔记本");
    }
}