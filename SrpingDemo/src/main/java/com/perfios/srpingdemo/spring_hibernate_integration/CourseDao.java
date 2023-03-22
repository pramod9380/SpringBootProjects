package com.perfios.srpingdemo.spring_hibernate_integration;

import com.perfios.srpingdemo.hibernet.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CourseDao implements CourseRepo {

    SessionFactory sessionFactory;

    Session session;
    Transaction transaction;

    public void setSessionFactory(SessionFactory factory){
        sessionFactory =factory;
    }

    @Override
    public void saveCourseDetails(Course course) {

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.save(course);
        transaction.commit();
    }

    @Override
    public Course getCourseDetailsById(int id) {
        Course course = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            course = session.get(Course.class,id);
            transaction.commit();
            session.close();
            return course;
        }catch (Exception e){
            System.out.println("Exception accured while fetching the course details by id from the database!!!!!!!");
        }
        return course;
    }

    @Override
    public List<Course> getAllCourseDetails() {
        List<Course> courses = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            courses = session.createQuery("from Course ").list();
            transaction.commit();
            session.close();
            return courses;
        }catch (Exception e){
            System.out.println("Exception accured while fetching the all course details from the database!!!!!!!");
        }
        return courses;
    }

    @Override
    public void updateCourseDetails(Course course) {

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(course);
            transaction.commit();
            session.delete(course);
            session.close();
        }catch (Exception e){
            System.out.println("Exception accured while updating the course details in the database!!!!!!!");
        }

    }

    @Override
    public void deleteCourseById(int id) {
        Course course = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            course = session.get(Course.class,id);
            session.delete(course);
            transaction.commit();
            session.close();
        }catch (Exception e){
            System.out.println("Exception accured while deleting the department details from the database!!!!!!!");
        }
    }
}
