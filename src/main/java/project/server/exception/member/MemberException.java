package project.server.exception.member;

import org.springframework.http.HttpStatus;
import project.server.config.ErrorCode;
import project.server.exception.ApiBaseException;

public class MemberException extends ApiBaseException {

    public MemberException(ErrorCode errorCode, HttpStatus httpStatus, String message) {
        super(errorCode, httpStatus, message);
    }
}
