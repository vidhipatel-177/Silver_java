package com.example.demo.controller;

import com.example.demo.dtos.DepartmentDTO;
import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping(value = "/addDepartment")
    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentDTO dto) {
        return ResponseEntity.ok(service.addDepartment(dto));
    }

    @GetMapping("/departments")
    public List<DepartmentDTO> getDepartments() {
        return service.getAllDepartments();
    }

    @GetMapping("/departments/{deptId}/employees")
    public List<EmployeeDTO> getEmployeesInDept(@PathVariable String deptId) {
        return service.getEmployeesByDept(Long.parseLong(deptId));
    }

    @PostMapping("/departments/{deptId}/employees")
    public ResponseEntity<EmployeeDTO> addEmployee(
            @PathVariable String deptId,
            @RequestBody EmployeeDTO dto) {
        return ResponseEntity.ok(service.addEmployeeToDepartment(Long.parseLong(deptId), dto));
    }

    @DeleteMapping("/employees/{empId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String empId) {
        service.deleteEmployee(Long.parseLong(empId));
        return ResponseEntity.noContent().build();
    }
}
