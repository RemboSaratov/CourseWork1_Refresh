package pro.sky.CourseWorkRefresh.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeCheckNameExeption extends RuntimeException {

}
