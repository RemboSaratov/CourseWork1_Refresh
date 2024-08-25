package pro.sky.CourseWorkRefresh;

import java.util.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.CourseWorkRefresh.service.EmployeeService;

@RestController
@RequestMapping ("/employee")
public class EmployeeController {

    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/hello")
    public String hello () {
        return "Привет";
    }

    @GetMapping("/add")
    public Employee addPerson (@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam int departmentId,
                               @RequestParam int salary) {
        employeeService.checkName(firstName, lastName);
        return employeeService.addPerson(firstName, lastName, departmentId, salary);
    }

    @GetMapping("/remove")
    public Employee removePerson (@RequestParam String firstName,
                                  @RequestParam String lastName,
                                  @RequestParam int departmentId,
                                  @RequestParam int salary) {
        employeeService.checkName(firstName, lastName);
        return employeeService.removePerson(firstName, lastName, departmentId, salary);
    }

    @GetMapping("/find")
    public Employee getPerson(@RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam int departmentId,
                              @RequestParam int salary) {
        employeeService.checkName(firstName, lastName);
        return employeeService.getPerson(firstName, lastName, departmentId, salary);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }
}

