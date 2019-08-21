package designmode.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**懒汉式如何防止反射和反序列化漏洞
 * @author hsc
 * @date 2019/8/20 - 20:08
 */
public class SingletonDemo6 implements Serializable{
    //类初始化时，立即加载
    private static SingletonDemo6 instance=null;
    private SingletonDemo6(){
        //多次new就直接抛出异常,破解反射调用私有构造器
        if (instance!=null){
            throw new RuntimeException();
        }
    }
    public static synchronized SingletonDemo6 getInstance(){
        if (instance==null){
            instance=new SingletonDemo6();
        }
        return instance;
    }
    //反序列化时，如果定义了readResolve() 则直接返回此方法指定的对象。而不需要单独在创建新对象！
    private Object readResolve() throws ObjectStreamException{
        return instance;
    }
}

/**
 * 如何防止反射和反序列化漏洞
 */
class Client{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        SingletonDemo6 s1=SingletonDemo6.getInstance();
        SingletonDemo6 s2=SingletonDemo6.getInstance();
        System.out.println(s1);
        System.out.println(s1 == s2);

//        //通过反射调用私有构造器
//        Class<SingletonDemo6> clazz= (Class<SingletonDemo6>) Class.forName("designmode.singleton.SingletonDemo6");
//        Constructor<SingletonDemo6> c=clazz.getDeclaredConstructor(null);
//        //跳过权限的检测
//        c.setAccessible(true);
//        SingletonDemo6 s3=c.newInstance();
//        SingletonDemo6 s4=c.newInstance();
//        System.out.println(s3);
//        System.out.println(s4);

        //通过反序列化的方式构造多个对象
        FileOutputStream fos=new FileOutputStream("d:/a.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(s1);
        oos.close();
        fos.close();

        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("d:/a.txt"));
        SingletonDemo6 s3= (SingletonDemo6) ois.readObject();
///        SingletonDemo6 s4= (SingletonDemo6) ois.readObject();
        System.out.println(s3);
    }
}