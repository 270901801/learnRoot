package javaRoot.jdk.lang.demo;

import java.io.*;

/**
 * @author hsc
 * @date 2020-04-03 04:46:03
 */
public class LangUtil {
    public static <T> T clone(T obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();
    }
}
