package designmode.structure.ProxyMode.dynmicProxy;

import java.lang.reflect.Proxy;

/**
 * @author hsc
 * @date 2019-11-06 22:40:56
 */
public class Client {
    public static void main(String[] args) {
        Star realStar = new RealStar();
        StarHandler handler = new StarHandler(realStar);

        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Star.class}, handler);
        proxy.sing();
    }
}
