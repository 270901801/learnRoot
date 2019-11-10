package designmode.structure.ProxyMode.staticProxy;

/**
 * @author hsc
 * @date 2019-11-06 22:19:55
 */
public class Client {
    public static void main(String[] args) {
        Star realStar=new RealStar();
        ProxyStar proxyStar=new ProxyStar(realStar);

        proxyStar.bookTicket();
        proxyStar.collectMoney();
        proxyStar.confer();
        proxyStar.signContract();
        proxyStar.sing();
    }
}
