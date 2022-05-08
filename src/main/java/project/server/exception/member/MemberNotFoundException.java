package project.server.exception.member;


import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.HttpStatus;
import project.server.config.ErrorCode;

public class MemberNotFoundException extends MemberException {


    private static final ErrorCode ERROR_CODE = ErrorCode.MEMBER_NOT_FOUND;
    private static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;
    private static final String MESSAGE = "해당하는 멤버를 찾을 수 없습니다.";

    public MemberNotFoundException() {
        super(ERROR_CODE,HTTP_STATUS,MESSAGE);
    }

    public MemberNotFoundException(ErrorCode errorCode, HttpStatus httpStatus, String message) {
        super(errorCode, httpStatus, message);
    }
}
