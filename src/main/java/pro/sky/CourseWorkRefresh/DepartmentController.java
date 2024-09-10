package pro.sky.CourseWorkRefresh;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.CourseWorkRefresh.service.DepartmentService;

@RestController
@RequestMapping("/department")

public class DepartmentController {

    public final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/salary/sum")
    public int sumSalary(@PathVariable int id) {
        return departmentService.getSumSalaryByDepartment(id);
    }
    @GetMapping("/{id}/salary/max")
    public Employee maxSalary(@PathVariable int id) {
        return departmentService.getMaxSalary(id);
    }
    @GetMapping("/{id}/salary/min")
    public Employee minSalary(@PathVariable int id) {
        return departmentService.getMinSalary(id);
    }
    @GetMapping(value = "/{id}/employees", params = "id")
    public Collection<Employee> getByDepartment(@PathVariable int id) {
        return departmentService.getByDepartment(id);
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> groupByDepartment() {
        return departmentService.groupByDepartment();
    }

}


