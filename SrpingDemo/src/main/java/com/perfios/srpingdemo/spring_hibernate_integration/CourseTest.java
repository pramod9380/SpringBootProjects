package com.perfios.srpingdemo.spring_hibernate_integration;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class CourseTest {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("spring_hibernate_integration/applicationcontext.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        CourseDao courseDao = new CourseDao();

        courseDao.setSessionFactory(sessionFactory);

//        Course course = new Course();

        Scanner input = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("==================MENU=================");
                System.out.println("1. Create a new Course");
                System.out.println("2. See a Course Details");
                System.out.println("3. See all the Course Details");
                System.out.println("4. Update a Course Details");
                System.out.println("5. Delete a Course");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = input.nextInt();

                switch(choice) {
                    case 1:
                    {
                        System.out.println("Enter the course id:");
                        int courseId = input.nextInt();
                        System.out.print("Enter the course name: ");
                        String courseName = input.next();
                        System.out.print("Enter the course duration: ");
                        String courseDuration = input.next();
                        System.out.println("Enter the course price");
                        int coursePrice = input.nextInt();
                        System.out.println("\nAdding the course.........");
                        courseDao.saveCourseDetails(new Course(courseId,courseName,courseDuration,coursePrice));
                        System.out.println("Course added successfully!");
                        break;
                    }

                    case 2:
                    {
                        System.out.print("Enter the courseId: ");
                        int id = input.nextInt();
                        System.out.println(courseDao.getCourseDetailsById(id));
                        break;
                    }
                    case 3:
                    {
                        courseDao.getAllCourseDetails().stream().forEach(System.out::println);
                        break;
                    }
                    case 4:
                    {
                        System.out.println("Enter the courseId: ");
                        int id = input.nextInt();
                        Course course1 = courseDao.getCourseDetailsById(id);
                        if(course1 == null) {
                            System.out.println("Sorry! The course does not exit.");
                            break;
                        }
                        System.out.println("Enter the course id:");
                        int courseId = input.nextInt();
                        System.out.print("Enter the course name: ");
                        String courseName = input.next();
                        System.out.print("Enter the course duration: ");
                        String courseDuration = input.next();
                        System.out.println("Enter the course price");
                        int coursePrice = input.nextInt();
                        System.out.println("Updating the Course.........");
                        course1 = new Course(courseId,courseName,courseDuration,coursePrice);
                        courseDao.updateCourseDetails(course1);
                        System.out.println("Course updated successfully!");
                        break;
                    }
                    case 5:
                    {
                        System.out.println("Enter the courseId: ");
                        int id = input.nextInt();
                        System.out.println("Deleting the course.......");
                        courseDao.deleteCourseById(id);
                        System.out.println("course deleted successfully!");
                        break;
                    }
                    case 6:
                        System.exit(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


