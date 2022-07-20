package com.itsoluwatobby.StudentManagementSystem.controller;

import com.itsoluwatobby.StudentManagementSystem.entity.Employee;
import com.itsoluwatobby.StudentManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping({"/showEmployees", "/", "/list"})
    public ModelAndView getAllEmployees() {
        ModelAndView mvc = new ModelAndView("list-of-employees");
        List<Employee> list = employeeService.getAllEmployees();
        mvc.addObject("employee", list);
        return mvc;
    }

    @GetMapping("/showEmployeeForm")
    public ModelAndView showEmployeeForm() {
        ModelAndView mvc = new ModelAndView("show-employee-form");
        Employee newEmployee = new Employee();
        mvc.addObject("employee", newEmployee);
        return mvc;
    }

    @PostMapping("/saveEmployees")
    public String saveEmployee(@ModelAttribute Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/list";
    }

    @GetMapping("/updateEmployee")
    public ModelAndView updateEmployee(@RequestParam Long id) {
        ModelAndView mvc = new ModelAndView("show-employee-form");
        Employee employee = employeeService.findById(id);
        mvc.addObject("employee", employee);
        return mvc;
    }

    @DeleteMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam Long id) {
        employeeService.deleteById(id);
        return "redirect:/list";
    }
}
