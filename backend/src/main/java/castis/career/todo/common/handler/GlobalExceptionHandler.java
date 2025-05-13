package castis.career.todo.common.handler;

import castis.career.todo.common.CustomException;
import castis.career.todo.common.response.CustomErrorResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private CustomErrorResponse buildErrorResponseList(CustomException e, String fieldName) {
        return CustomErrorResponse.builder()
                .errorMsg(e.getMessage())
                .errorType(e.getClass().getTypeName())
                .fieldName(fieldName)
                .status(e.getStatus())
                .build();
    }
}
