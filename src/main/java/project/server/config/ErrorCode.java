package project.server.config;

import lombok.Getter;

@Getter
public enum ErrorCode {

    SUCCESS("1000"),

    //
    MEMBER_NOT_FOUND("U0001"),
    DTO_NOT_FIT_SPEC("U002");







    private final String code;

    private ErrorCode(String code) {
        this.code = code;
    }
}
