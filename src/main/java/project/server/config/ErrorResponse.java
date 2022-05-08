package project.server.config;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponse<T> {
    ErrorCode errorCode;
    HttpStatus httpStatus;
    String message;

    public ErrorResponse(ErrorCode errorCode, HttpStatus httpStatus, String message) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
