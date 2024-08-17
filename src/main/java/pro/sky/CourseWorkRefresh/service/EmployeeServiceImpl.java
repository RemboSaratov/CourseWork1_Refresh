package pro.sky.CourseWorkRefresh.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import pro.sky.CourseWorkRefresh.Employee;
import pro.sky.CourseWorkRefresh.exeption.EmployeeAlreadyAddedException;
import pro.sky.CourseWorkRefresh.exeption.EmployeeCheckNameExeption;
import pro.sky.CourseWorkRefresh.exeption.EmployeeNotFoundException;
import pro.sky.CourseWorkRefresh.exeption.EmployeeStorageIsFullException;
import org.apache.commons.lang3.StringUtils;

@Service
    public class EmployeeServiceImpl implements EmployeeService {

    public static final Integer max_employee = 10;
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Anton", "Petrov", 1, 25000),
            new Employee("Anna", "Sedocova", 2, 40000),
            new Employee("Igor", "Corolev", 3, 15000),
            new Employee("Olga", "Topol", 4, 10000),
            new Employee("Oleg", "Ivanov", 1 , 40000)

    ));


        @Override
        public Employee addPerson(String firstName, String lastName, int departmentId, int salary) {
            Employee person = new Employee(firstName, lastName, departmentId, salary);
            System.out.println(employees.size());
                if (employees.size() >= max_employee) {
                    throw new EmployeeStorageIsFullException("В список больше нельзя добавить нового сотрудника");
                }
            if (employees.contains(person)) {
                throw new EmployeeAlreadyAddedException();
            }
            StringUtils.capitalize(firstName);
            StringUtils.capitalize(lastName);
            employees.add(new Employee(StringUtils.capitalize(firstName),
                                       StringUtils.capitalize(lastName),
                                       departmentId,
                                       salary));
            return person;
        }

        @Override
        public Employee removePerson(String firstName, String lastName, int departmentId, int salary) {
            Employee person = new Employee(StringUtils.capitalize(firstName),
                                           StringUtils.capitalize(lastName),
                                           departmentId,
                                           salary);
            if (employees.contains(person)) {
                employees.remove(person);
                return person;
            }
            throw new EmployeeNotFoundException();
        }

        @Override
        public Employee getPerson(String firstName, String lastName, int departmentId, int salary) {
            Employee person = new Employee(StringUtils.capitalize(firstName),
                                           StringUtils.capitalize(lastName),
                                           departmentId,
                                           salary);
            if (employees.contains(person)) {
                return person;
            }
            throw new EmployeeNotFoundException();
        }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employees);
    }

    public void checkName(String firstName, String lastName) {
        if (!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName)) {
            throw new EmployeeCheckNameExeption();
        }
    }
}
