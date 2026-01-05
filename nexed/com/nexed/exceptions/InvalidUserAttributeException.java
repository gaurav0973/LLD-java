package nexed.com.nexed.exceptions;
public class InvalidUserAttributeException extends Exception{
    public InvalidUserAttributeException(String message){
        super("Invalid User Attribute Exception: " + message);
    }
}
