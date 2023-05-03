package jk.uz.pdp.domain.exception;

public class EPAMPaymentSecurityException extends RuntimeException{
    private ServerError error;

    public EPAMPaymentSecurityException(String message, ServerError error) {
        super(message);
        this.error = error;
    }

    public EPAMPaymentSecurityException(String message) {
        super(message);
    }

    public ServerError getError() {
        return error;
    }

    public void setError(ServerError error) {
        this.error = error;
    }
}
