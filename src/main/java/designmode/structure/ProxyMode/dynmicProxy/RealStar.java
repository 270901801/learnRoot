package designmode.structure.ProxyMode.dynmicProxy;

/**
 * @author hsc
 * @date 2019-11-06 21:48:49
 */
public class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("周杰伦 confer");
    }

    @Override
    public void signContract() {
        System.out.println("周杰伦 signContract");
    }

    @Override
    public void bookTicket() {
        System.out.println("周杰伦 bookTicket");
    }

    @Override
    public void sing() {
        System.out.println("周杰伦 sing");
    }

    @Override
    public void collectMoney() {
        System.out.println("周杰伦 collectMoney");
    }
}
