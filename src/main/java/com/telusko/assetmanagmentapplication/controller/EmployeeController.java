package com.telusko.assetmanagmentapplication.controller;

import com.telusko.assetmanagmentapplication.assetObjects.Assets;
import com.telusko.assetmanagmentapplication.assetObjects.Employees;
import com.telusko.assetmanagmentapplication.assetObjects.Locations;
import com.telusko.assetmanagmentapplication.dto.CategoryDropDownDTO;
import com.telusko.assetmanagmentapplication.dto.EmployeeAddDTO;
import com.telusko.assetmanagmentapplication.dto.EmployeeDropDownDTO;
import com.telusko.assetmanagmentapplication.dto.LocationAddDTO;
import com.telusko.assetmanagmentapplication.service.AssetsService;
import com.telusko.assetmanagmentapplication.service.EmployeesService;
import com.telusko.assetmanagmentapplication.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class EmployeeController {

    private final EmployeesService employeesService;

    public EmployeeController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping("/employees")
    public List<Employees> getAllEmployees() {

        return employeesService.getAllEmployees();
    }

    @PostMapping("/employees/add")
    public String addEmployee(@RequestBody EmployeeAddDTO employeeAddDTO) {
        return employeesService.addEmployee(employeeAddDTO);
    }

    @GetMapping("/employees/list")
    public List<EmployeeDropDownDTO> getAllEmployeesForDropDown() {
        return employeesService.getAllEmployeesForDropDown();
    }

    @PutMapping("/employees/update")
    public String updateEmployee(@RequestBody EmployeeAddDTO employeeAddDTO) {
        return employeesService.updateEmployee(employeeAddDTO);
    }


}