package com.perfios.srpingdemo.jdbc_templete;

import com.perfios.srpingdemo.hibernet.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Scanner;

public class StudentTest {

    public static void main(String[] args) {

        // Using Annotation type

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DriverManagerDataSource dataSource = context.getBean(DriverManagerDataSource.class);

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/college");
        dataSource.setUsername("root");
        dataSource.setPassword("password");

        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        jdbcTemplate.setDataSource(dataSource);

        StudentDao studentDao = context.getBean(StudentDao.class);
        Student student = context.getBean(Student.class);

        studentDao.setTemplate(new NamedParameterJdbcTemplate(dataSource));
        studentDao.setJdbcTemplate(jdbcTemplate);

        /*
            // Using Traditional Method
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            JdbcTemplate jdbcTemplate = new JdbcTemplate();

            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/college");
            dataSource.setUsername("root");
            dataSource.setPassword("password");

            jdbcTemplate.setDataSource(dataSource);
            StudentDao studentDao = new StudentDao();

        */


        /*
            // Using xml configuration

            ApplicationContext context = new ClassPathXmlApplicationContext("jdbctemplate.xml");

            StudentDao studentDao = context.getBean("student", StudentDao.class);

            studentDao.insertStudentData(new Student(2,"Pavan","1MS18CS088","DoddaBallapur"));
            studentDao.updateStudentData(new Student(2,"Shubham","1BNM18IS088","Bihar"));
            studentDao.deleteStudentData(new Student(1,"Pramod","1MS18CS093","Bidar"));
            studentDao.insetStudentDataUsingPreparedStatement(new Student(3,"Aditya","1PS18CS007","Durga"));

            List<Student> students = studentDao.getAllStudentUsingResultSet();
            students.stream().forEach(System.out::println);

            List<Student> studentList = studentDao.getAllStudentUsingRowMap();
            studentList.stream().forEach(System.out::println);

         */

        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("==================MENU=================");
                System.out.println("1. Add new Student Details");
                System.out.println("2. See all the Student Details");
                System.out.println("3. Update a Student Details");
                System.out.println("4. Delete a Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = input.nextInt();

                switch (choice) {
                    case 1: {
                        System.out.println("Enter the student id:");
                        int studentId = input.nextInt();
                        System.out.print("Enter the student name: ");
                        String studentName = input.next();
                        System.out.print("Enter the usn: ");
                        String studentUsn = input.next();
                        System.out.println("Enter the location: ");
                        String studentLocation = input.next();
                        System.out.println("\nAdding the Student.........");
                        studentDao.insertStudentData(new Student(studentId, studentName, studentUsn, studentLocation));
                        System.out.println("Department added successfully!");
                        break;
                    }
                    case 2: {
                        List<Student> studentList = studentDao.getAllStudentUsingRowMap();
                        studentList.stream().forEach(System.out::println);
                        break;
                    }
                    case 3: {
                        System.out.println("Enter the student id:");
                        int studentId = input.nextInt();
                        System.out.print("Enter the student name: ");
                        String studentName = input.next();
                        System.out.print("Enter the usn: ");
                        String studentUsn = input.next();
                        System.out.println("Enter the location: ");
                        String studentLocation = input.next();
                        System.out.println("Updating student data...............");
                        studentDao.updateStudentData(new Student(studentId,studentName,studentUsn,studentLocation));
                        System.out.println("Updated student data.................");
                        break;
                    }

                    case 4:{
                        System.out.println("Enter student id:");
                        int id = input.nextInt();
                        student.setId(id);
                        System.out.println("deleting student data..................");
                        studentDao.deleteStudentData(student);
                        System.out.println("deleted student data...................");
                    }

                    case 5:
                        System.exit(0);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
