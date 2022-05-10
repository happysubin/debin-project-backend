package project.server.advice;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.server.config.ErrorCode;
import project.server.config.ErrorResponse;
import project.server.exception.member.MemberNotFoundException;

import java.util.Locale;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalDtoAdvice {

    private final MessageSource ms;
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse MemberNotFoundException(MethodArgumentNotValidException exception){
        BindingResult bindingResult = exception.getBindingResult();

        ObjectError error = bindingResult.getAllErrors().get(0);
        String code = error.getCodes()[0];

        return new ErrorResponse(ErrorCode.DTO_NOT_FIT_SPEC, HttpStatus.BAD_REQUEST, ms.getMessage(code,null,null));
    }
}
