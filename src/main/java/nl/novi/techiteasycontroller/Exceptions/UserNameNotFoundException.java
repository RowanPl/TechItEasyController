package nl.novi.techiteasycontroller.Exceptions;

public class UserNameNotFoundException extends RuntimeException{

    public UserNameNotFoundException(String message) {
        super(message);
    }
}
