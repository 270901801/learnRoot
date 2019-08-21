package webserver.reflect;

import java.lang.reflect.InvocationTargetException;

/**
 * 反射：把java类中的各种结构（方法，属性，构造器，类名）映射成一个个java对象
 * 1.获取Class对象
 *推荐Class.forName("xx.xx")
 * 2.可以动态创建对象
 * @author hsc
 * @date 2019/8/20 - 16:27
 */
public class learnReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //三种方式
        //1.对象.getClass()
        Class clz=new Iphone().getClass();
        //2.类.class();
        clz=Iphone.class;
        //3.Class.forName("包名.类名")
        clz=Class.forName("webserver.reflect.Iphone");

        //创建对象
        Iphone iphone= (Iphone) clz.newInstance();
        System.out.println(iphone);

        Iphone iphone2= (Iphone) clz.getConstructor().newInstance();
        System.out.println(iphone2);
    }
}

class Iphone{
    public Iphone(){}
}