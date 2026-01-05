package nexed.com.nexed.models;
import nexed.com.nexed.exceptions.InvalidUserAttributeException;

public class Educator extends NexUser {
    private String subject;
    public Educator(String username, String email, String subject) throws InvalidUserAttributeException {
        super(username, email);
        this.subject = subject;
    }
    // role => using abstract method from NexUser
    @Override
    public String getRolePermission() {
        return "ADMIN";
    }
    
}
