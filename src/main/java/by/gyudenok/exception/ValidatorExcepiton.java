package by.gyudenok.exception;

public class ValidatorExcepiton extends Exception {

    public ValidatorExcepiton() {

    }

    public ValidatorExcepiton(String message) {
        super(message);
    }

    public ValidatorExcepiton(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidatorExcepiton(Throwable cause) {
        super(cause);
    }
}
