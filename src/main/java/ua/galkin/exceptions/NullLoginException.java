package ua.galkin.exceptions;

public class NullLoginException extends RuntimeException {
    public NullLoginException(String message){
        super(message);
    }
}
