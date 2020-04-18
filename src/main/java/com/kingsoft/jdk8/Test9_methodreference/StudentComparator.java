package com.kingsoft.jdk8.Test9_methodreference;

/**
 * @ClassName StudentComparator
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 14:38
 * @Version 1.0
 **/
public class StudentComparator {

    public int compareStudentByScore(Student student1, Student student2){
        return student1.getScore() - student2.getScore();
    }


    public int compareStudentByName(Student student1, Student student2){
        return student1.getName().compareToIgnoreCase(student2.getName());
    }

}
