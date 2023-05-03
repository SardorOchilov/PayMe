package jk.uz.pdp.domain.exception;

public enum ServerError {

    // security
    WRONG_PASSWORD("password didn't match"),
    NOT_OWNER("Only owner has access"),

    // validation
    INVALID_PHONE_NUMBER("phone number should only contain numbers");

    // server
    public final String value;
    ServerError(String value) {
        this.value = value;
    }
}
