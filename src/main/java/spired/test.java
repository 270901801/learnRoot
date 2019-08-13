package spired;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author hsc
 * @date 2019/8/13 - 11:02
 */
public class test {
    public static void main(String[] args) throws Exception {
        URL url=new URL("http://www.shicimingju.com/book/sanguoyanyi/"+2+".html");
        BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream(),"utf8"));
        String str;
        while ((str=br.readLine())!=null){
            System.out.println(str);
        }
    }
}
