package pro.sky.CourseWorkRefresh.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.BAD_REQUEST)

public class EmployeeAlreadyAddedException extends RuntimeException{

    public EmployeeAlreadyAddedException() {
        super();
    }

    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }

    public EmployeeAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }
}
