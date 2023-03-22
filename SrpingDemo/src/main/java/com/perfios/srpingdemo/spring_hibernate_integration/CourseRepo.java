package com.perfios.srpingdemo.spring_hibernate_integration;


import java.util.List;

public interface CourseRepo {

    void saveCourseDetails(Course course);

    Course getCourseDetailsById(int id);

    List<Course> getAllCourseDetails();

    void updateCourseDetails(Course course);

    void deleteCourseById(int id);

}
