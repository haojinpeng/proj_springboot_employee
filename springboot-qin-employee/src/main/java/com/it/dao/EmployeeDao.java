package com.it.dao;

import com.it.pojo.Department;
import com.it.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//员工dao
@Repository
public class EmployeeDao {
    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;
    //员工所属部门
    @Autowired
    private DepartmentDao departmentDao;
    static {
        //创建一个部门表
        employees = new HashMap<>();
        employees.put(1001,new Employee(1001,"AA","aaa.@qq.com",1,new Department(101,"财务部")));
        employees.put(1002,new Employee(1002,"BB","aaa.@qq.com",0,new Department(102,"秘书部")));
        employees.put(1003,new Employee(1003,"CC","aaa.@qq.com",0,new Department(103,"活动部")));
        employees.put(1004,new Employee(1004,"DD","aaa.@qq.com",1,new Department(104,"宣传部")));
        employees.put(1005,new Employee(1005,"EE","aaa.@qq.com",0,new Department(105,"外联部")));
    }

    //主键自增
    private static  Integer initId = 1006;
    //增加一个员工
    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除员工
    public void delete(Integer id){
        employees.remove(id);
    }

}
