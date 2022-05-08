package project.server.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import project.server.config.ErrorCode;

@Getter
public abstract class ApiBaseException extends RuntimeException{
    private final ErrorCode errorCode;
    private final HttpStatus httpStatus;

    public ApiBaseException(ErrorCode errorCode, HttpStatus httpStatus,String message) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }
}
