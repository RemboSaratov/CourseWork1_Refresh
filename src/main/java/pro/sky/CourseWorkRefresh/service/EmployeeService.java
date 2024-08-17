package pro.sky.CourseWorkRefresh.service;

import java.util.Collection;
import java.util.List;
import pro.sky.CourseWorkRefresh.Employee;

public interface EmployeeService {

    Employee addPerson(String firstName, String lastName, int departmentId, int salary);

    Employee removePerson(String firstName, String lastName, int departmentId, int salary);

    Employee getPerson(String firstName, String lastName, int departmentId, int salary);

    Collection <Employee> findAll();

    void checkName(String firstName, String lastName);
}
