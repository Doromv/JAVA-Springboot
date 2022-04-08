package com.doromv.dao;

import com.doromv.pojo.Department;
import com.doromv.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Doromv
 * @create 2022-03-10-8:38
 */
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employeeMap=null;
    @Autowired
    DepartmentDao departmentDao=null;
    static {
        employeeMap=new HashMap<Integer,Employee>();
        employeeMap.put(1001,new Employee(1001,"AA","ADoromv@163.com",1,new Department(101,"教学部")));
        employeeMap.put(1002,new Employee(1002,"BB","BDoromv@163.com",1,new Department(102,"市场部")));
        employeeMap.put(1003,new Employee(1003,"CC","CDoromv@163.com",1,new Department(103,"教研部")));
        employeeMap.put(1004,new Employee(1004,"DD","DDoromv@163.com",1,new Department(104,"运营部")));
        employeeMap.put(1005,new Employee(1005,"EE","EDoromv@163.com",1,new Department(105,"后勤部")));
    }
    private static Integer intId=1006;
    public void addEmployee(Employee employee){
        if(employee.getId()==null){
            employee.setId(intId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(),employee);
    }
    public Collection<Employee> getAllEmpolyee(){
        return employeeMap.values();
    }
    public Employee getEmployById(Integer id){
        return employeeMap.get(id);
    }
    public void deleteEmployee(Integer id){
        employeeMap.remove(id);
    }
}
