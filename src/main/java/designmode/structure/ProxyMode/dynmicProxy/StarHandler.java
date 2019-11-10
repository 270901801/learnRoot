package designmode.structure.ProxyMode.dynmicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author hsc
 * @date 2019-11-06 22:36:29
 */
public class StarHandler implements InvocationHandler {
    Star realStar;

    public StarHandler(Star realStar) {
        super();
        this.realStar = realStar;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object=null;
        //其他业务
        System.out.println("真正的方法执行前！");
        System.out.println("面谈，签合同，预付款，订机票");

        //核心业务,需要调用realStar真实对象来处理
        if(method.getName().equals("sing")){
            object=method.invoke(realStar,args);
        }
        System.out.println("真正的方法执行后！");
        System.out.println("收尾款");
        return object;
    }
}
