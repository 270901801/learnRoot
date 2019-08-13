package spired;

import java.io.*;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hsc
 * @date 2019/8/13 - 0:04
 */



public class GetText {
    /**
     * 1.根据小说存放位置创建file对象
     * 2.根据网页结构编写正则，创建pattern对象
     * 3.编写循环，创建向所有小说张杰页面发起网络请求的url对象
     * 4.网络流BufferReader
     * 5.创建输入流
     * 6.循环读取请求得到的内容，使用正则匹配其中的内容
     * 7.将读取的内容写入本地文件，直到循环结束
     * 8.注意代码中的异常处理
     */
    public static void main(String[] args) {
        File file=new File("D:\\Novel\\three_guo.txt");
        String regex_content="<p.*>(.*?)</p>";
        String regex_title="<title>(.*?)</title>";
        Pattern p_content=Pattern.compile(regex_content);
        Pattern p_title=Pattern.compile(regex_title);

        Matcher m_content;
        Matcher m_title;

        //3.编写循环，创建向所有小说章节页面而发起网络请求的url对象
        for (int i=1;i<=120;i++){
            System.out.println("第"+i+"章开始下载。。");
            try {
                //创建每一个页面的url对象
                URL url=new URL("http://www.shicimingju.com/book/sanguoyanyi/"+i+".html");
                //创建网络读取流
                BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream(),"utf8"));
                //读取网络内容到BufferReader
                String str=null;
                // 创建输入流
                BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true)));
                while ((str=reader.readLine())!=null){
                    m_title=p_title.matcher(str.toString());
                    m_content=p_content.matcher(str.toString());

                    //获取小说标题并写入本地文件
                    Boolean isEx=m_title.find();
                    if (isEx){
                        String title=m_title.group();
                        //清洗得到的数据
                        title=title.replace("<title>","").replace("</title>","");
                        System.out.println(title);
                        writer.write("第"+i+"章"+title+"\r\n");
                    }

                    while (m_content.find()){
                        String content=m_content.group();
                        //清洗得到的数据
                        content=content.replace("<p>","").replace("</p>","").replace("&nbsp","");
                        //把小说内容写入文件
                        writer.write(content+"\r\n");
                    }

                }
                System.out.println("第"+i+"章下载完成。。。");
                writer.write("\r\n");
                writer.close();
                reader.close();
            }catch (Exception e){
                System.out.println("下载失败");
            }finally {
            }
        }
    }

}
