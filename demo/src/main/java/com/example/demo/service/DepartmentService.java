package com.example.demo.service;

import com.example.demo.dtos.DepartmentDTO;
import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repo.DepartmentRepository;
import com.example.demo.repo.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository deptRepo;
    private final EmployeeRepository empRepo;

    public DepartmentService(DepartmentRepository deptRepo, EmployeeRepository empRepo) {
        this.deptRepo = deptRepo;
        this.empRepo = empRepo;
    }

    public List<DepartmentDTO> getAllDepartments() {
        return deptRepo.findAll().stream().map(this::mapToDTO).toList();
    }

    @Transactional
    public DepartmentDTO addDepartment(DepartmentDTO dto) {
        if (deptRepo.existsByName(dto.name())) {
            throw new IllegalArgumentException("Department with name already exists: " + dto.name());
        }

        Department department = new Department();
        department.setName(dto.name());
        department.setLocation(dto.location());

        deptRepo.save(department);

        return dto;
    }

    @Transactional
    public EmployeeDTO addEmployeeToDepartment(Long deptId, EmployeeDTO dto) {

        Department dept = deptRepo.findById(deptId)
                .orElseThrow(() -> new IllegalArgumentException("Department ID not found: " + deptId));

        if (empRepo.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("Employee with email already exists.");
        }

        Employee emp = new Employee(dto.name(), dto.email(), dto.position(), dto.salary(), dept);
        empRepo.save(emp);
        return dto;
    }

    @Transactional
    public void deleteEmployee(Long empId) {
        if (empRepo.findById(empId).isEmpty()) {
            throw new IllegalArgumentException("Employee with id not found: .");
        }
        empRepo.deleteById(empId);
    }

    private DepartmentDTO mapToDTO(Department dept) {
        List<EmployeeDTO> employeeDTOs = dept.getEmployees().stream()
                .map(this::mapToEmployeeDTO)
                .collect(Collectors.toList());

        return new DepartmentDTO(
                dept.getName(),
                dept.getLocation(),
                employeeDTOs
        );
    }

    private EmployeeDTO mapToEmployeeDTO(Employee emp) {
        return new EmployeeDTO(
                emp.getName(),
                emp.getEmail(),
                emp.getPosition(),
                emp.getSalary()
        );
    }

    public List<EmployeeDTO> getEmployeesByDept(Long deptId) {
        List<Employee> employees = empRepo.findAllByDepartmentId(deptId);

        return employees.stream()
                .map(this::mapToEmployeeDTO)
                .collect(Collectors.toList());
    }

}
