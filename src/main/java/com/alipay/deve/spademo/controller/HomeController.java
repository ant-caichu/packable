package com.alipay.deve.spademo.controller;

import com.alipay.deve.spademo.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

    private List<Employee> employees = new ArrayList<>();
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    HomeController() {
        Employee employee = new Employee(1L, "caichu", "dev");
        employees.add(employee);
    }

    private String HEALTH_OK = "OK";

    @GetMapping("/checkService")
    public String checkService() {
        return HEALTH_OK;
    }

    @GetMapping("/employees")
    @ResponseBody
    public List<Employee> list() {
        return employees;
    }

    @GetMapping("/employees/{id}")
    @ResponseBody
    public Employee findOne(@PathVariable Long id) {
        if(employees.isEmpty()) {
            log.info("employee list is empty.");
        }
        return employees.get(0);
    }
}
