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
    public Employee addPerson (@RequestParam("firstName") String firstName, @RequestParam("lastName") String secondName) {
        return employeeService.addPerson(firstName, secondName);
    }

    @GetMapping("/remove")
    public Employee removePerson (@RequestParam("firstName") String firstName, @RequestParam("lastName") String secondName) {
        return employeeService.removePerson(firstName, secondName);
    }

    @GetMapping("/find")
    public Employee getPerson(@RequestParam("firstName") String firstName, @RequestParam("lastName") String secondName) {
        return employeeService.getPerson(firstName, secondName);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }
}

