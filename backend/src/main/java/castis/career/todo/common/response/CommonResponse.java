package castis.career.todo.common.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CommonResponse<T> {

    private final int status;

    @Builder.Default
    private final String message = "Success";

    @Builder.Default
    private final LocalDateTime timestamp = LocalDateTime.now();

    private final T data;
}
