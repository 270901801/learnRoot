package utils;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class util {
    public static String fileToString(String fileName) throws IOException {
        File file=new File(fileName);
        InputStream inputStream=new FileInputStream(file);
        int len;
        String string="";
        StringBuffer stringBuffer=new StringBuffer();
        while((len=inputStream.read())!=-1){
            char str= ((char) len);
            stringBuffer.append(str);
            string+=str;
        }
        return string;
    }
    public String stringToFile(String string,String fileName) throws IOException {
        OutputStream outputStream=new FileOutputStream(new File(fileName));
        outputStream.write(string.getBytes());
        return "success";
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        String string=fileToString("C:\\Users\\Administrator\\Desktop\\test.sql");
//        string=string.replaceAll("insert","select");
//        System.out.println(string);'
//        for (Field field : getEntityProperties("utils.pojo")) {
//            System.out.println(field.getName());
//        }
//        String string=fileToString("D:\\code\\idea\\learnRoot\\pom.xml");
////        System.out.println(string);
//        System.out.println(getElement(string));

//        list list=new list();
//        for (int i=0;i<10;i++){
//            list.push(i);
//        }
//        for (int i=0;i<10;i++){
//            System.out.println(list.pop());
//        }
        int []arr={8,3,6,1};
        System.out.println(sort.minNumberInRotateArray(arr));


    }
    public static Field[] getEntityProperties(String entityPath) throws ClassNotFoundException {
        Class clazz=Class.forName(entityPath);
        Field[] properties=clazz.getDeclaredFields();
        return properties;
    }

    public static String getElement(String string){
        String regex="<(.+?)>";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(string);
        System.out.println(matcher.find());
//        System.out.println(matcher.group());
        System.out.println(matcher.groupCount());
        for(int i=0;i<matcher.groupCount();i++){
            System.out.println("第"+i+"组"+matcher.group(i));
        }
        return "";//matcher.group();
    }

    static class list{
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();

        public void push(int node){
            stack1.push(node);
        }

        public int pop(){
            if (stack1.empty()&&stack2.empty()){
                return -1;
            }
            if(stack2.empty()){
                while(!stack1.empty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }


    }

    static class sort{
        public static int minNumberInRotateArray(int [] array) {

            for(int i=0;i<array.length;i++){
                boolean flag=false;
                for(int j=0;j<array.length-1;j++){
                    if(array[j]>array[j+1]){
                        int temp=array[j];
                        array[j]=array[j+1];
                        array[j+1]=temp;
                        flag=true;
                    }
                }
                if(!flag){
                    return array[0];
                }
            }
            return array[0];
        }
    }
}
