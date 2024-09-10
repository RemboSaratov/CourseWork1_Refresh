package pro.sky.CourseWorkRefresh.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.CourseWorkRefresh.Employee;
import pro.sky.CourseWorkRefresh.exeption.EmployeeAlreadyAddedException;
import pro.sky.CourseWorkRefresh.exeption.EmployeeNotFoundException;
import pro.sky.CourseWorkRefresh.exeption.EmployeeStorageIsFullException;

class EmployeeServiceImplTest {
    EmployeeServiceImpl service = new EmployeeServiceImpl();
    Employee employee1;
    Employee employee2;
    Employee employeeForTestAdd;

    @BeforeEach
    public void setUp() {
                employee1 = new Employee("Anton","Petrov",1, 25000);
                employee2 = new Employee("Anna","Sedocova",2, 40000);
                employeeForTestAdd = new Employee("I", "Z", 1, 2000);
    }
    @Test
    public void findAll() {
        Collection<Employee> actual = new ArrayList<>();
        actual.add(employee1);
        actual.add(employee2);
        Collection<Employee> expected = service.findAll();
        assertEquals(expected, actual);

    }
    @Test
    public void addEmployee() {
        var employeeExpected = service.addPerson("I", "Z", 1, 2000);
        assertThat(employeeExpected).isEqualToComparingFieldByField(employeeForTestAdd);
//        assertEquals(employeeExpected, employeeForTestAdd);
        assertThat(service.findAll()).size().isEqualTo(3);
    }
    @Test
    public void employeeAlreadyAddedException() {
        service.addPerson("I", "Z", 1, 2000);
        assertThrows(EmployeeAlreadyAddedException.class, () -> service.addPerson("I", "Z", 1, 2000));
    }

    @Test
    public void employeeStorageIsFullException() {
        service.addPerson("Q","E",2,9000);
        service.addPerson("O","U",4,1200);
        service.addPerson("V","M",3,8200);
        assertThrows(EmployeeStorageIsFullException.class, () -> service.addPerson("full", "full", 0, 000));
    }
    @Test
    public void removeEmployee() {
        var employeeTest = new Employee("Anton","Petrov",1, 25000);
        assertEquals(service.removePerson("Anton", "Petrov", 1, 25000), employeeTest);
        assertThat(service.findAll()).size().isEqualTo(1);
    }

    @Test
    public void employeeNotFoundExceptionWhenRemove() {
        assertThrows(EmployeeNotFoundException.class, () -> service.removePerson("notFound","notFound",0, 000));

    }

    @Test
    public void getEmployee() {
        var employeeActual = service.addPerson("get", "geT", 0, 000);
        var employeeExpected = service.getPerson("get","geT",0, 000);
        assertThat(employeeExpected).isEqualTo(employeeActual);
    }

    @Test
    public void employeeNotFoundExceptionWhenGet() {
        assertThrows(EmployeeNotFoundException.class, () -> service.getPerson("notFound","notFound",0, 000));

    }
}

