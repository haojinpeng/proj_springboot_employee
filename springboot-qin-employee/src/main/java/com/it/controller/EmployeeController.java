package com.it.controller;

import com.it.dao.DepartmentDao;
import com.it.dao.EmployeeDao;
import com.it.pojo.Department;
import com.it.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.engine.ElementModelStructureHandler;

import java.util.Collection;
import java.util.Collections;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //添加员工之查询部门
    @GetMapping("/addEmp")
    public String toAddpage(Model model){
        //查出所有部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/addEmp";
    }

    //添加员工
    @PostMapping("/addEmp")
    public String addEmp(Employee employee){
        System.out.println("employee-->"+employee);
        //保存员工信息
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //去修改员工
    @GetMapping("/toUpdateEmp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id,Model model){
        //查出原来的数据
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("empById",employee);
        //查出所有部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/updateEmp";
    }

    //修改员工
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/delEmp/{id}")
    public String delEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
