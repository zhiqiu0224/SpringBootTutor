package com.example.demo.repository;

import com.example.demo.modal.Course;
import com.example.demo.modal.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Repository
public class CourseRepository {
    List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        Course javaOne = Course.builder()
                .className("Java1")
                .instructor(new Instructor("Steve", "Jobs", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();

        courses.add(javaOne);
    }


    public List<Course> findAllClasses(){
        //链接数据库
        //返回数据库的信息
        return  courses;
    }

    public void addNewCourse(Course newCourse) {
        courses.add(newCourse);
    }

    public void removeCourseByName(String courseName) {
        Iterator iter = courses.iterator();
        while (iter.hasNext()) {
            Course c = (Course)iter.next();
            if (c.getClassName().equals(courseName)) {
                iter.remove();
                return;
            }
        }
    }


    public List<Course> findAllCourse(String searchByCourseName){

        return new ArrayList<Course>();
    }

    public List<Course> findCourseByName(String courseName) {
        if(courseName.equals("Java_I")) {
            return courses;
        }

        return new ArrayList<Course>();
    }
}
