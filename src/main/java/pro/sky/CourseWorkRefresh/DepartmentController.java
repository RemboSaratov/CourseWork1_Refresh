package pro.sky.CourseWorkRefresh;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.CourseWorkRefresh.service.DepartmentService;

@RestController
@RequestMapping("/departments")

public class DepartmentController {

    public final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam int departmentId) {
        return departmentService.getMaxSalary(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam int departmentId) {
        return departmentService.getMinSalary(departmentId);
    }
    @GetMapping(value = "/all", params = "departmentId")
    public Collection<Employee> getByDepartment(@RequestParam int departmentId) {
        return departmentService.getByDepartment(departmentId);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> groupByDepartment() {
        return departmentService.groupByDepartment();
    }

}


