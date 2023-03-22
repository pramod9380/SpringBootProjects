package com.perfios.srpingdemo.hibernet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        HibernateConf conf = applicationContext.getBean(HibernateConf.class);

        DepartmentDao dao = applicationContext.getBean(DepartmentDao.class);

        dao.setSessionFactory(conf.getSessionFactory());

        Scanner input = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("==================MENU=================");
                System.out.println("1. Create a new Department");
                System.out.println("2. See a Department Details");
                System.out.println("3. See all the Department Details");
                System.out.println("4. Update a Department Details");
                System.out.println("5. Delete a Department");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = input.nextInt();

                switch(choice) {
                    case 1:
                    {
                        System.out.println("Enter the department id:");
                        int departmentId = input.nextInt();
                        System.out.print("Enter the department name: ");
                        String departmentName = input.next();
                        System.out.print("Enter the college: ");
                        String departmentCollege = input.next();
                        System.out.println("\nAdding the Department.........");
                        dao.saveDepartmentDetails(new Department(departmentId,departmentName,departmentCollege));
                        System.out.println("Department added successfully!");
                        break;
                    }
                    case 2:
                    {
                        System.out.print("Enter the departmentId: ");
                        int id = input.nextInt();
                        System.out.println(dao.getDepartmentDetailsById(id));
                        break;
                    }
                    case 3:
                    {
                        dao.getAllDepartmentDetails().stream().forEach(System.out::println);
                        break;
                    }
                    case 4:
                    {
                        System.out.println("Enter the departmentId: ");
                        int id = input.nextInt();
                        Department department = dao.getDepartmentDetailsById(id);
                        if(department == null) {
                            System.out.println("Sorry! The department does not exit.");
                            break;
                        }
                        System.out.println("Leave blank if don't want to change.");
                        System.out.println("Enter the department id:");
                        int departmentId = input.nextInt();
                        System.out.print("Enter the department name: ");
                        String departmentName = input.next();
                        System.out.print("Enter the college: ");
                        String departmentCollege = input.next();
                        System.out.println("Updating the Department.........");
                        department = new Department(departmentId,departmentName,departmentCollege);
                        dao.updateDepartmentDetails(department);
                        System.out.println("Department updated successfully!");
                        break;
                    }
                    case 5:
                    {
                        System.out.println("Enter the departmentId: ");
                        int id = input.nextInt();
                        System.out.println("Deleting the department.......");
                        dao.deleteDepartmentById(id);
                        System.out.println("department deleted successfully!");
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

