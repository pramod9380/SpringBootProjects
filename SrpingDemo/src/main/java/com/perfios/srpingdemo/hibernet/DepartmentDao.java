package com.perfios.srpingdemo.hibernet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDao implements DepartmentRepo{



    private SessionFactory sessionFactory ;
    Transaction transaction = null;

    // This is same as Statement is JDBC
    Session session;



    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveDepartmentDetails(Department department) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
            session.close();
        }catch (Exception e){
            System.out.println("Exception accured while save the department details into the database!!!!!!!");
        }
    }

    @Override
    public Department getDepartmentDetailsById(int id) {
        Department department = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            department = session.get(Department.class,id);
            transaction.commit();
            session.close();
            return department;
        }catch (Exception e){
            System.out.println("Exception accured while fetching the department details by id from the database!!!!!!!");
        }
        return department;
    }

    @Override
    public List<Department> getAllDepartmentDetails() {

        List<Department> departments = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            departments = session.createQuery("from Department ").list();
            transaction.commit();
            session.close();
            return departments;
        }catch (Exception e){
            System.out.println("Exception accured while fetching the all department details from the database!!!!!!!");
        }
        return departments;
    }

    @Override
    public void updateDepartmentDetails(Department department) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(department);
            transaction.commit();
            session.close();
        }catch (Exception e){
            System.out.println("Exception accured while updating the department details in the database!!!!!!!");
        }
    }

    @Override
    public void deleteDepartmentById(int id) {
        Department department = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            department = session.get(Department.class,id);
            session.delete(department);
            transaction.commit();
            session.close();
        }catch (Exception e){
            System.out.println("Exception accured while deleting the department details from the database!!!!!!!");
        }
    }
}
