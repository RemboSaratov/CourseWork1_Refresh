package pro.sky.CourseWorkRefresh.exeption;

public class EmployeeStorageIsFullException extends RuntimeException {

    public EmployeeStorageIsFullException() {
        super();
    }

    public EmployeeStorageIsFullException(String message) {
        super(message);
    }

    public EmployeeStorageIsFullException(String message, Throwable cause) {
        super(message, cause);
    }
}
