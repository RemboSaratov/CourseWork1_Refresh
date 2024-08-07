package pro.sky.CourseWorkRefresh.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import pro.sky.CourseWorkRefresh.Employee;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getMaxSalary(int departmentId) {
        return employeeService.findAll().stream()
                       .filter(employee -> departmentId == employee.getDepartmentId())
                       .max(Comparator.comparingInt(employee -> employee.getSalary()))
                       .orElseThrow(() -> new RuntimeException("Не верно введенный ID"));
    }
    public Employee getMinSalary(int departmentId) {
        return employeeService.findAll().stream()
                              .filter(employee -> departmentId == employee.getDepartmentId())
                              .min(Comparator.comparingInt(employee -> employee.getSalary()))
                              .orElseThrow(() -> new RuntimeException("Не верно введенный ID"));
    }

    public Collection<Employee> getByDepartment(int departmentId) {
        return employeeService.findAll().stream()
                              .filter(employee -> departmentId == employee.getDepartmentId())
                              .toList();
    }

    public Map<Integer, List<Employee>> groupByDepartment() {
        return employeeService.findAll().stream()
                              .collect(Collectors.groupingBy(employee -> employee.getDepartmentId()));
    }
}
