package temp;


import org.apache.http.client.utils.HttpClientUtils;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * 了解和使用类库
 */
public class Test04 {
    private static final Random rnd=new Random();
    static int random(int n){
        return Math.abs(rnd.nextInt())%n;
    }
    public int Fibonacci(int n) {
        int preNum=1;
        int prePreNum=0;
        int result=0;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        for(int i=2;i<=n;i++){
            result=preNum+prePreNum;
            prePreNum=preNum;
            preNum=result;
        }
        return result;

    }

    public static void main(String[] args) {
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MAX_VALUE);
//        for(int i=0;i<2;i++){
//            System.out.print(random(100)+"\t");
//        }
////        Method[] method=Test03.class.getMethods();
////        method[0].invoke();
//        System.exit(100);
//        int[] arr={1,2,3};
//
//        System.out.println(123);

        System.out.println(new Test04().Fibonacci(10));
    }
}
