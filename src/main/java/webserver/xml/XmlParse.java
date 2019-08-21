package webserver.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

/**
 * @author hsc
 * @date 2019/8/20 - 16:47
 */
public class XmlParse {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        File inputFile = new File("D:\\code\\git\\learnRoot\\src\\main\\java\\webserver\\xml\\person.xml");
        //SAX解析
        //1.获取解析工厂
        SAXParserFactory factory=SAXParserFactory.newInstance();
        //2.从解析工厂获取解析器
        SAXParser parser=factory.newSAXParser();
        //加载文档Document注册处理器
        //4.编写处理器
        PersonHandler handler=new PersonHandler();
        //5.解析
//        System.out.println(Thread.currentThread().getContextClassLoader()
//                .getResourceAsStream("D:\\code\\git\\learnRoot\\src\\main\\java\\webserver\\xml\\person.xml"));
        parser.parse(new FileInputStream(inputFile),handler);
    }
}


class PersonHandler extends DefaultHandler{
    public void startDocument() throws SAXException {
        System.out.println("-----解析文档开始-----");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName+"-->解析开始");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents=new String(ch,start,length).trim();
        if(contents.length()>0){
            System.out.println("内容为："+contents);
        }else{
            System.out.println("内容为：空");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName+"-->解析结束");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("-----解析文档结束-----");
    }
}