package project.server.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.server.config.ErrorResponse;
import project.server.exception.member.MemberNotFoundException;

@RestControllerAdvice
public class MemberAdvice {

    @ExceptionHandler(MemberNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse MemberNotFoundException(MemberNotFoundException exception){
        return new ErrorResponse(exception.getErrorCode(), exception.getHttpStatus(), exception.getMessage());
    }
}
