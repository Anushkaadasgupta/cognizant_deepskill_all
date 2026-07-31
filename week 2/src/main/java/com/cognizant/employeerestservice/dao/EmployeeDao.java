package com.cognizant.employeerestservice.dao;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.employeerestservice.exception.EmployeeNotFoundException;
import com.cognizant.employeerestservice.model.Employee;

@Repository
public class EmployeeDao {

    private static ArrayList<Employee> EMPLOYEE_LIST;

    @SuppressWarnings("unchecked")
    public EmployeeDao() {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("employee.xml");

        EMPLOYEE_LIST =
                (ArrayList<Employee>) context.getBean("employeeList");

        context.close();
    }

    public ArrayList<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {

        boolean found = false;

        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {

            if (EMPLOYEE_LIST.get(i).getId().equals(employee.getId())) {

                EMPLOYEE_LIST.set(i, employee);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new EmployeeNotFoundException("Employee not found");
        }
    }

    public void deleteEmployee(int id) throws EmployeeNotFoundException {

        boolean found = false;

        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {

            if (EMPLOYEE_LIST.get(i).getId().equals(id)) {

                EMPLOYEE_LIST.remove(i);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new EmployeeNotFoundException("Employee not found");
        }
    }
}