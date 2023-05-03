package jk.uz.pdp.domain.exception;

public class EPAMPaymentValidationException extends RuntimeException{
    private ServerError error;

    public EPAMPaymentValidationException(String message) {
        super(message);
    }

    public EPAMPaymentValidationException(ServerError error) {
        this.error = error;
    }

    public EPAMPaymentValidationException(String message, ServerError error) {
        super(message);
        this.error = error;
    }
}
