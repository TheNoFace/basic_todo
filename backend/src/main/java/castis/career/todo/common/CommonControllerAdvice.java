package castis.career.todo.common;

import castis.career.todo.common.response.CommonResponse;
import castis.career.todo.common.response.CustomErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@RestControllerAdvice
public class CommonControllerAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return !Void.TYPE.equals(returnType.getParameterType());
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if (isErrorResponse(body)) {
            CustomErrorResponse errorResponse = (CustomErrorResponse) body;
            return wrapResponse(errorResponse.getStatus(), errorResponse);
        }
        return wrapResponse(HttpStatusCode.valueOf(HttpStatus.OK.value()), body);
    }

    private boolean isErrorResponse(Object body) {
        return body instanceof ErrorResponse;
    }

    private CommonResponse wrapResponse(HttpStatusCode status, Object data) {

        return CommonResponse.builder()
                .message("error")
                .status(status.value())
                .data(data)
                .build();
    }
}
