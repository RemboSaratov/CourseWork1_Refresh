package pro.sky.CourseWorkRefresh.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import pro.sky.CourseWorkRefresh.Employee;
import pro.sky.CourseWorkRefresh.exeption.EmployeeAlreadyAddedException;
import pro.sky.CourseWorkRefresh.exeption.EmployeeNotFoundException;
import pro.sky.CourseWorkRefresh.exeption.EmployeeStorageIsFullException;

@Service
    public class EmployeeServiceImpl implements EmployeeService {

    public static final Integer max_employee = 5;
    List<Employee> employees = new ArrayList<>(max_employee);

        @Override
        public Employee addPerson(String firstName, String secondName) {
            Employee person = new Employee(firstName, secondName);
            System.out.println(employees.size());
                if (employees.size() >= max_employee) {
                    throw new EmployeeStorageIsFullException("В список больше нельзя добавить нового сотрудника");
                }
            if (employees.contains(person)) {
                throw new EmployeeAlreadyAddedException();
            }
            employees.add(new Employee(firstName, secondName));
            return person;
        }

        @Override
        public Employee removePerson(String firstName, String secondName) {
            Employee person = new Employee(firstName, secondName);
            if (employees.contains(person)) {
                employees.remove(person);
                return person;
            }
            throw new EmployeeNotFoundException();
        }

        @Override
        public Employee getPerson(String firstName, String secondName) {
            Employee person = new Employee(firstName, secondName);
            if (employees.contains(person)) {
                return person;
            }
            throw new EmployeeNotFoundException();
        }

    @Override public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employees);
    }
}
