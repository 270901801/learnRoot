package spired;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**学习正则表达式
 * @author hsc
 * @date 2019/8/18 - 19:4//https://www.xbiquge6.com/search.php?keyword=
 */
public class zhengze {
    public static final String  SEARCH_URL="http://www.shicimingju.com/chaxun/shici/";


    public static String getText(String src,String reg){
        String result="";
        return result;
    }

    public static void search(String novelName) throws Exception {
        String regexTitle="<h3>(.*?)</h3>";
        Pattern pTitle=Pattern.compile(regexTitle);
        Matcher mTitle;
        Matcher mUrl;
        URL url=new URL(SEARCH_URL+novelName);
        BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream()));
        String str="";
        while ((str=reader.readLine())!=null){
            mTitle=pTitle.matcher(str);
//            mUrl=pTitle.matcher(str);
            Boolean isEx=mTitle.find();
            if (isEx){
                String title=mTitle.group();
                String novelUrl=mTitle.group();
                novelUrl="http://www.shicimingju.com"+novelUrl.replaceAll("<h3>(.*?)<a href=\"","").replaceAll("\">(.*?)</a></h3>","");
                title=title.replaceAll("<(.*?)>","");//.replace("<em>","").replace("</em>","").
//                title.replace("<em>","").replace("</em>","");
                System.out.println(title+"\t"+novelUrl);
            }
            //System.out.println(str);
        }
    }
    public static void main(String[] args) throws Exception {
        while (true){
            System.out.println("请输入小说名：");
            Scanner scanner=new Scanner(System.in);
            String novelName=scanner.nextLine();
            search(novelName);
        }
    }
}
