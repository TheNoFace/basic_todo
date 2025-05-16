package castis.career.todo.common.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class CustomErrorResponse {

    private String errorMsg;
    private String errorType;
    private String fieldName;
    private HttpStatus status;
}
