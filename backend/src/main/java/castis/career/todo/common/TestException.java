package castis.career.todo.common;

import org.springframework.http.HttpStatus;

public class TestException extends CustomException {

    public TestException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
