package co.com.sofka.crud.exception;

public class customExceptions extends RuntimeException{


    public customExceptions() {
    }

    public customExceptions(String message) {
        super(message);
    }

    public customExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public customExceptions(Throwable cause) {
        super(cause);
    }
}
