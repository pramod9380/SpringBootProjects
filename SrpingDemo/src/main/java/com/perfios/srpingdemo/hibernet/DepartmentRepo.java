package com.perfios.srpingdemo.hibernet;

import java.util.List;

public interface DepartmentRepo {

    void saveDepartmentDetails(Department department);

    Department getDepartmentDetailsById(int id);

    List<Department> getAllDepartmentDetails();

    void updateDepartmentDetails(Department department);

    void deleteDepartmentById(int id);

}
