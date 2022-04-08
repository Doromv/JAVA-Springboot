package com.doromv.controller;

import com.doromv.dao.DepartmentDao;
import com.doromv.dao.EmployeeDao;
import com.doromv.pojo.Department;
import com.doromv.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author Doromv
 * @create 2022-03-10-17:38
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @RequestMapping("/e/g")
    public String getEmployee(Model model){
        Collection<Employee> employees = employeeDao.getAllEmpolyee();
        model.addAttribute("employees",employees);
        return "employee/list";
    }
    @GetMapping("/Add")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "employee/add";
    }
    @PostMapping("/Add")
    public String AddPage(Employee employee){
        employeeDao.addEmployee(employee);
        return "redirect:/e/g";
    }
    @GetMapping("/Update/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        Employee employById = employeeDao.getEmployById(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("emp",employById);
        model.addAttribute("departments",departments);
        return "employee/update";
    }
    @PostMapping("/Update")
    public String Update(Employee employee){
        System.out.println(employee);
        employeeDao.addEmployee(employee);
        return "redirect:/e/g";
    }
    @GetMapping("/Delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.deleteEmployee(id);
        return "redirect:/e/g";
    }
}
