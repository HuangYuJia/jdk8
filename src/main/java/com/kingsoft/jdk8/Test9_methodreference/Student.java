package com.kingsoft.jdk8.Test9_methodreference;

/**
 * @ClassName Student
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 14:34
 * @Version 1.0
 **/
public class Student {
    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    // 不是很有意义的写法
    // Student方法中传入两个student对象进行比较？那这个方法抽取到其他的类中也能使用,
    // 正确的方法应该是把当前的student对象和传入的student对象进行比较
    public static int compareStudentByScore(Student student1, Student student2){
        return student1.getScore() - student2.getScore();
    }

    public static int compareStudentByName(Student student1, Student student2){
        return student1.getName().compareToIgnoreCase(student2.getName());
    }

    // 有意义的写法
    public int compareByScore(Student student){
        return this.getScore() - student.getScore();
    }

    public int compareByName(Student student){
        return this.getName().compareToIgnoreCase(student.getName());
    }

}
