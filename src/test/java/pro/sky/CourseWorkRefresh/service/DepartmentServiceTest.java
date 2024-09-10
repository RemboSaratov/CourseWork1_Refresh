package pro.sky.CourseWorkRefresh.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.CourseWorkRefresh.Employee;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        when(employeeService.findAll()).thenReturn(List.of(
                new Employee("Anton", "Petrov", 1, 5005),
                new Employee("Anna", "Sedocova", 3, 40000),
                new Employee("test1", "TEST1", 2, 999),
                new Employee("test2", "TEST2", 3, 66000),
                new Employee("test3", "TEST3", 1, 400),
                new Employee("test4", "TEST4", 1, 4440000),
                new Employee("test5", "TEST5", 3, 4440000)));
    }

    @Test
    public void getMaxSalary() {
        assertEquals(new Employee("test4", "TEST4", 1, 4440000), departmentService.getMaxSalary(1));
    }

    @Test
    public void getMinSalary() {
        assertEquals(new Employee("test3", "TEST3", 1, 400), departmentService.getMinSalary(1));
    }

    @Test
    public void getSumSalaryByDepartment() {
        assertEquals((5005 + 400 + 4440000), departmentService.getSumSalaryByDepartment(1));
    }

    @Test
    public void getEmployeeByDepartment() {
        assertEquals(List.of(
                new Employee("Anna", "Sedocova", 3, 40000),
                new Employee("test2", "TEST2", 3, 66000),
                new Employee("test5", "TEST5", 3, 4440000)), departmentService.getByDepartment(3));
        assertThat(departmentService.getByDepartment(1)).containsExactly(
                new Employee("Anton", "Petrov", 1, 5005),
                new Employee("test3", "TEST3", 1, 400),
                new Employee("test4", "TEST4", 1, 4440000));

    }

    @Test
    public void groupByDepartment() {
        Map<Integer, List<Employee>> employeeMap = new HashMap<>();
        employeeMap.put(1, List.of(
                new Employee("Anton", "Petrov", 1, 5005),
                new Employee("test3", "TEST3", 1, 400),
                new Employee("test4", "TEST4", 1, 4440000)));
        employeeMap.put(2, List.of(
                new Employee("test1", "TEST1", 2, 999)));
        employeeMap.put(3, List.of(
                new Employee("Anna", "Sedocova", 3, 40000),
                new Employee("test2", "TEST2", 3, 66000),
                new Employee("test5", "TEST5", 3, 4440000)));
        assertThat(departmentService.groupByDepartment()).isEqualTo(employeeMap);

//        assertThat(departmentService.groupByDepartment()).isEqualTo(Map.of(
//                1, List.of(
//                        new Employee("Anton", "Petrov", 1, 5005),
//                        new Employee("test3", "TEST3", 1, 400),
//                        new Employee("test4", "TEST4", 1, 4440000)),
//                2, List.of(
//                        new Employee("test1", "TEST1", 2, 999)),
//                3, List.of(
//                        new Employee("Anna", "Sedocova", 3, 40000),
//                        new Employee("test2", "TEST2", 3, 66000),
//                        new Employee("test5", "TEST5", 3, 4440000))));
    }

    @Test
    public void getMaxSalaryRuntimeExceptionBecauseWrongID() {
        assertThrows(RuntimeException.class, () -> departmentService.getMaxSalary(10));
    }

    @Test
    public void getMinSalaryRuntimeExceptionBecauseWrongID() {
        assertThrows(RuntimeException.class, () -> departmentService.getMinSalary(0));
    }
}