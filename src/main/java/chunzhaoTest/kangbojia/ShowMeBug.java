package chunzhaoTest.kangbojia;

import org.junit.Test;

import java.util.*;

/**
 * 现在程序中有一组学生成绩数据（getScoreList()返回结果），每条数据为某个学生的某科成绩。学生成绩可能不是4科都有，
 * 可能有缺科。要求对这组数据进行数据转换和计算处理，转换成学生记录列表，每条记录里面有4科成绩和总成绩，
 * 并在此基础上计算全班的平均成绩。最后用控制台输出即可，要求表格按总成绩从高到低排序。计算平均成绩时，
 * 缺课也算人次，结果保留三位小数，输出格式如下。
 * 需要注意的是，最终完成代码的代码质量（逻辑是否清晰，变量/方法命名是否合理等），将作为考察标准的一部分
 * 姓名		数学		语文		英语		物理		总成绩
 * 张三		 		  65	   84	     89	      316
 * 李四		 89		  76				 76		  313
 * …
 * 平均成绩    83.5	 70.5	  78	    82.5	314.5
 */

public class ShowMeBug {


    @Test
    public static void test(){
        List<ScoreVo> scoreList = getScoreList();
        // TODO 请编写代码实现题目要求
        List<StudentVo> studentScoreList=new ArrayList<>();
        //整理学生成绩
        for (ScoreVo scoreVo : scoreList) {
            StudentVo studentVo = null;
            Boolean isNotFound=false;
            for (StudentVo stu : studentScoreList){
                if (stu.getName().equals(scoreVo.studentName)){
                    isNotFound=true;
                }else{
                    isNotFound=false;
                    studentVo=stu;
                    break;
                }
            }
            if (studentScoreList.size()==0||isNotFound){
                studentVo.setName(scoreVo.studentName);
                studentScoreList.add(studentVo);
            }
            //记录每位同学的单科成绩
            switch (scoreVo.courseName){
                case "语文":
                    studentVo.setChineseScore(scoreVo.score);
                    break;
                case "数学":
                    studentVo.setMathScore(scoreVo.score);
                    break;
                case "英语":
                    studentVo.setEnglishScore(scoreVo.score);
                    break;
                case "物理":
                    studentVo.setPhysicalScore(scoreVo.score);
                    break;
            }
            //统计每位同学的总分
            studentVo.setTotalScore(studentVo.getTotalScore()+scoreVo.score);
        }
        //按总分降序排序
        Collections.sort(studentScoreList, new Comparator<StudentVo>() {
            @Override
            public int compare(StudentVo o1, StudentVo o2) {
                return Double.valueOf(o2.getTotalScore()).compareTo(o1.getTotalScore());
            }
        });
        //计算总分，平均分
        StudentVo averageScore = null;
        for (StudentVo stu:studentScoreList){
            averageScore.setTotalScore(averageScore.getTotalScore()+stu.getTotalScore());
            averageScore.setPhysicalScore(averageScore.getPhysicalScore()+stu.getPhysicalScore());
            averageScore.setEnglishScore(averageScore.getEnglishScore()+stu.getEnglishScore());
            averageScore.setChineseScore(averageScore.getChineseScore()+stu.getChineseScore());
            averageScore.setMathScore(averageScore.getMathScore()+stu.getMathScore());
        }
        //打印成绩
        System.out.println("姓名\t\t数学\t\t语文\t\t英语\t\t物理\t\t总成绩");
        for (StudentVo score : studentScoreList) {
            System.out.print(score.getName()+"\t\t");
            System.out.printf("%.3f\t",score.getMathScore());
            System.out.printf("%.3f\t",score.getChineseScore());
            System.out.printf("%.3f\t",score.getEnglishScore());
            System.out.printf("%.3f\t",score.getPhysicalScore());
            System.out.printf("%.3f\t",score.getTotalScore());
            System.out.println();
        }
        int studentNum=studentScoreList.size();
        System.out.print("平均成绩");
        System.out.printf("%.3f\t",averageScore.getMathScore());
        System.out.printf("%.3f\t",averageScore.getChineseScore());
        System.out.printf("%.3f\t",averageScore.getEnglishScore());
        System.out.printf("%.3f\t",averageScore.getPhysicalScore());
        System.out.printf("%.3f\t",averageScore.getTotalScore());
        System.out.println();

    }
    public static void main(String[] args) {
        List<ScoreVo> scoreList = getScoreList();
        // TODO 请编写代码实现题目要求
        List<StudentVo> studentScoreList=new ArrayList<>();
        //整理学生成绩
        for (ScoreVo scoreVo : scoreList) {
            StudentVo studentVo = new StudentVo();
            Boolean isNotFound=false;
            for (StudentVo stu : studentScoreList){
                if (!stu.getName().equals(scoreVo.studentName)){
                    isNotFound=true;
                }else{
                    isNotFound=false;
                    studentVo=stu;
                    break;
                }
            }
            if (studentScoreList.size()==0||isNotFound){
                studentVo.setName(scoreVo.studentName);
                studentScoreList.add(studentVo);
            }
            //记录每位同学的单科成绩
            switch (scoreVo.courseName){
                case "语文":
                    studentVo.setChineseScore(scoreVo.score);
                    break;
                case "数学":
                    studentVo.setMathScore(scoreVo.score);
                    break;
                case "英语":
                    studentVo.setEnglishScore(scoreVo.score);
                    break;
                case "物理":
                    studentVo.setPhysicalScore(scoreVo.score);
                    break;
            }
            //统计每位同学的总分
            studentVo.setTotalScore(studentVo.getTotalScore()+scoreVo.score);
        }
        //按总分降序排序
        Collections.sort(studentScoreList, new Comparator<StudentVo>() {
            @Override
            public int compare(StudentVo o1, StudentVo o2) {
                return Double.valueOf(o2.getTotalScore()).compareTo(o1.getTotalScore());
            }
        });
        //计算总分，平均分
        StudentVo averageScore = new StudentVo();
        for (StudentVo stu:studentScoreList){
            averageScore.setTotalScore(averageScore.getTotalScore()+stu.getTotalScore());
            averageScore.setPhysicalScore(averageScore.getPhysicalScore()+stu.getPhysicalScore());
            averageScore.setEnglishScore(averageScore.getEnglishScore()+stu.getEnglishScore());
            averageScore.setChineseScore(averageScore.getChineseScore()+stu.getChineseScore());
            averageScore.setMathScore(averageScore.getMathScore()+stu.getMathScore());
        }
        //打印成绩
        System.out.println("姓名\t\t数学\t\t语文\t\t英语\t\t物理\t\t总成绩");
        for (StudentVo score : studentScoreList) {
            System.out.print(score.getName()+"\t\t");
            System.out.printf("%.3f\t",score.getMathScore());
            System.out.printf("%.3f\t",score.getChineseScore());
            System.out.printf("%.3f\t",score.getEnglishScore());
            System.out.printf("%.3f\t",score.getPhysicalScore());
            System.out.printf("%.3f\t",score.getTotalScore());
            System.out.println();
        }
        int studentNum=studentScoreList.size();
        System.out.print("平均成绩");
        System.out.printf("%.3f\t",averageScore.getMathScore()/studentNum);
        System.out.printf("%.3f\t",averageScore.getChineseScore()/studentNum);
        System.out.printf("%.3f\t",averageScore.getEnglishScore()/studentNum);
        System.out.printf("%.3f\t",averageScore.getPhysicalScore()/studentNum);
        System.out.printf("%.3f\t",averageScore.getTotalScore()/studentNum);
        System.out.println();
//        List<ScoreVo> scoreList = getScoreList();
//        // TODO 请编写代码实现题目要求
//        List<Map<String,Object> > studentScoreList=new ArrayList<>();
//        //整理学生成绩
//        for (ScoreVo scoreVo : scoreList) {
//            Map<String, Object> courseScoreMap=new HashMap<>();
//            Boolean isNotFound=false;
//            for (Map<String,Object> map : studentScoreList){
//                if (map.get("姓名")==null||!map.get("姓名").equals(scoreVo.getStudentName())){
//                    isNotFound=true;
//                }else{
//                    isNotFound=false;
//                    courseScoreMap=map;
//                    break;
//                }
//            }
//            if (studentScoreList.size()==0||isNotFound){
//                courseScoreMap.put("姓名", scoreVo.getStudentName());
//                studentScoreList.add(courseScoreMap);
//            }
//            //记录每位同学的单科成绩
//            courseScoreMap.put(scoreVo.getCourseName(), Double.valueOf(scoreVo.getScore()));
//            //统计每位同学的总分
//            if (courseScoreMap.get("总成绩")!=null){
//                courseScoreMap.put("总成绩",(Double) courseScoreMap.get("总成绩")+Double.valueOf(scoreVo.getScore()));
//            }else{
//                courseScoreMap.put("总成绩",Double.valueOf(scoreVo.getScore()));
//            }
//        }
//        //计算总分，平均分
//        Map<String,Object> averageScore=new HashMap<>();
//        for (Map<String,Object> map:studentScoreList){
//            for (Map.Entry<String,Object> entry:map.entrySet()){
//                if (entry.getKey().equals("姓名")) continue;
//                if (averageScore.get(entry.getKey())!=null){
//                    averageScore.put(entry.getKey(),(Double) averageScore.get(entry.getKey())+(Double) (entry.getValue()==null?0.000:entry.getValue()));
//                }else{
//                    averageScore.put(entry.getKey(),entry.getValue()==null?0.000:entry.getValue());
//                }
//            }
//        }
//        //按总分降序排序
//        Collections.sort(studentScoreList, new Comparator<Map<String, Object>>() {
//            @Override
//            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
//                Double scoresAll1=(Double) o1.get("总成绩");
//                Double scoresAll2=(Double) o2.get("总成绩");
//                return scoresAll2.compareTo(scoresAll1);
//            }
//        });
        //打印成绩
//        System.out.println("姓名\t\t数学\t\t语文\t\t英语\t\t物理\t\t总成绩");
//        for (Map<String,Object> score : studentScoreList) {
//            System.out.print(score.get("姓名")+"\t\t");
//            System.out.printf("%.3f\t",score.get("数学")==null?0.000:score.get("数学"));
//            System.out.printf("%.3f\t",score.get("语文")==null?0.000:score.get("语文"));
//            System.out.printf("%.3f\t",score.get("英语")==null?0.000:score.get("英语"));
//            System.out.printf("%.3f\t",score.get("物理")==null?0.000:score.get("物理"));
//            System.out.printf("%.3f\t",score.get("总成绩")==null?0.000:score.get("总成绩"));
//            System.out.println();
//        }
//        int studentNum=studentScoreList.size();
//        System.out.print("平均成绩");
//        System.out.printf("%.3f\t",averageScore.get("数学").equals(Double.valueOf(0))?0.000:(Double)averageScore.get("数学")/studentNum);
//        System.out.printf("%.3f\t",averageScore.get("语文").equals(Double.valueOf(0))?0.000:(Double)averageScore.get("语文")/studentNum);
//        System.out.printf("%.3f\t",averageScore.get("英语").equals(Double.valueOf(0))?0.000:(Double)averageScore.get("英语")/studentNum);
//        System.out.printf("%.3f\t",averageScore.get("物理").equals(Double.valueOf(0))?0.000:(Double)averageScore.get("物理")/studentNum);
//        System.out.printf("%.3f\t",averageScore.get("总成绩").equals(Double.valueOf(0))?0.000:(Double)averageScore.get("总成绩")/studentNum);
//        System.out.println();
    }

    public static List<ScoreVo> getScoreList() {
        List<ScoreVo> scoreList = new ArrayList<ScoreVo>();
        ShowMeBug showMeBug = new ShowMeBug();
        scoreList.add(showMeBug.new ScoreVo("张三", "语文", 80));
        scoreList.add(showMeBug.new ScoreVo("张三", "物理", 76));
        scoreList.add(showMeBug.new ScoreVo("李四", "语文", 78));
        scoreList.add(showMeBug.new ScoreVo("茅十八", "英语", 65));
        scoreList.add(showMeBug.new ScoreVo("李四", "数学", 88));
        scoreList.add(showMeBug.new ScoreVo("李四", "物理", 87));
        scoreList.add(showMeBug.new ScoreVo("王五", "语文", 67));
        scoreList.add(showMeBug.new ScoreVo("张三", "数学", 76));
        scoreList.add(showMeBug.new ScoreVo("李四", "英语", 89));
        scoreList.add(showMeBug.new ScoreVo("王五", "数学", 65));
        scoreList.add(showMeBug.new ScoreVo("赵六", "物理", 95));
        scoreList.add(showMeBug.new ScoreVo("王五", "英语", 78));
        scoreList.add(showMeBug.new ScoreVo("王五", "物理", 65));
        scoreList.add(showMeBug.new ScoreVo("赵六", "语文", 89));
        scoreList.add(showMeBug.new ScoreVo("赵六", "英语", 87));
        scoreList.add(showMeBug.new ScoreVo("黄七", "语文", 78));
        scoreList.add(showMeBug.new ScoreVo("黄七", "数学", 65));
        scoreList.add(showMeBug.new ScoreVo("刘八", "英语", 87));
        scoreList.add(showMeBug.new ScoreVo("张三", "英语", 56));
        scoreList.add(showMeBug.new ScoreVo("黄七", "物理", 76));
        scoreList.add(showMeBug.new ScoreVo("刘八", "数学", 89));
        scoreList.add(showMeBug.new ScoreVo("黄七", "英语", 98));
        scoreList.add(showMeBug.new ScoreVo("刘八", "语文", 56));
        scoreList.add(showMeBug.new ScoreVo("刘八", "物理", 76));
        scoreList.add(showMeBug.new ScoreVo("钱九", "语文", 88));
        scoreList.add(showMeBug.new ScoreVo("钱九", "数学", 67));
        scoreList.add(showMeBug.new ScoreVo("茅十八", "数学", 43));
        scoreList.add(showMeBug.new ScoreVo("钱九", "英语", 75));
        scoreList.add(showMeBug.new ScoreVo("茅十八", "语文", 45));
        scoreList.add(showMeBug.new ScoreVo("茅十八", "物理", 56));

        return scoreList;

    }

    private class ScoreVo {
        public String studentName;
        public String courseName;
        public double score;

        public ScoreVo(String studentName, String courseName, double score) {
            this.studentName = studentName;
            this.courseName = courseName;
            this.score = score;
        }


        public String toString() {
            return this.studentName + "\t" + this.courseName + "\t" + this.score;
        }
    }

    private static class StudentVo {
        private String name;
        private double chineseScore;
        private double mathScore;
        private double englishScore;
        private double physicalScore;
        private double totalScore;

        public StudentVo() {

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getChineseScore() {
            return chineseScore;
        }

        public void setChineseScore(double chineseScore) {
            this.chineseScore = chineseScore;
        }

        public double getMathScore() {
            return mathScore;
        }

        public void setMathScore(double mathScore) {
            this.mathScore = mathScore;
        }

        public double getEnglishScore() {
            return englishScore;
        }

        public void setEnglishScore(double englishScore) {
            this.englishScore = englishScore;
        }

        public double getPhysicalScore() {
            return physicalScore;
        }

        public void setPhysicalScore(double physicalScore) {
            this.physicalScore = physicalScore;
        }

        public double getTotalScore() {
            return totalScore;
        }

        public void setTotalScore(double totalScore) {
            this.totalScore = totalScore;
        }
    }
}
