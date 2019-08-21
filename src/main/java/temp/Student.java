package temp;

import java.lang.reflect.InvocationTargetException;

public class Student  implements Comparable<Student>{//
    private String name;        // 姓名
    private int age;            // 年龄

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Student student=new Student("hsc",22);
        System.out.println(Student.class.getDeclaredFields());
        System.out.println(Class.forName("temp.Student").getDeclaredFields());
        String.class.newInstance();
        System.out.println(Student.class.getConstructor(Student.class).newInstance("hsc", 22).toString());
        //student.getClass().getDeclaredField("toString");


    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }


    public int compareTo(Student o) {
        return this.age - o.age; // 比较年龄(年龄的升序)
    }

}