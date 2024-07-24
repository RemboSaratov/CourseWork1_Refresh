package pro.sky.CourseWorkRefresh.service;

import java.util.Collection;
import pro.sky.CourseWorkRefresh.Employee;

public interface EmployeeService {

    Employee addPerson(String firstName, String secondName);

    Employee removePerson(String firstName, String secondName);

    Employee getPerson(String firstName, String secondName);

    Collection<Employee> findAll();
}
