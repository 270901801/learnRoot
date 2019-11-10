package javaRoot.thread.concurrence;

/**
 * @author hsc
 * @date 2019-11-04 20:33:44
 */
public class UnsafeExample01 {
    public static void main(String[] args) {
        Account account=new Account("you",100);
        Drawing you=new Drawing(account,70,"you");
        Drawing wife=new Drawing(account,70,"your wife");
        you.start();
        wife.start();
    }

}

class Account{
    String name;
    int money;
    public Account(String name,int money){
        this.name=name;
        this.money=money;
    }
}
//模拟取款
class Drawing extends Thread{
    Account account;
    int drawingMoney;//取得钱数
    int packetTotal;//取的总数
    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account=account;
        this.drawingMoney=drawingMoney;
    }

    @Override
    public void run() {
        if(account.money-drawingMoney<0){
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money-=drawingMoney;
        packetTotal+=drawingMoney;
        System.out.println(this.getName()+"账户余额为："+account.money);
        System.out.println(this.getName()+"口袋余额为："+packetTotal);
    }
}