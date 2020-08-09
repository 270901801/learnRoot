package chunzhaoTest.kangbojia;

import java.util.ArrayList;
import java.util.List;

/**康博嘉
 * @author hsc
 * @date 2020-04-20 09:38:35
 */
public class test {
    public static void main(String[] args) {
        List<Student> list=new ArrayList<>();
        list.add(new Student("张三","语文",60));
        list.add(new Student("张三","数学",70));
        list.add(new Student("李四","语文",65));
        list.add(new Student("李四","数学",75));
        Student result=null;
        String name=null;
        int total=0;
        for(Student stu:list){
            if(!stu.name.equals(name)){
                result=new Student();
                total=0;
            }
            total=total+stu.score;
            result.total=total;
            name=stu.name;
        }
        System.out.println(result.total);
    }

}
class Student{
    public String name;
    public String course;
    public int score;
    public int total;

    public Student() {
    }

    public Student(String name, String course, int score) {
        this.name = name;
        this.course = course;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
