package nexed.com.nexed.models;
import nexed.com.nexed.exceptions.InvalidUserAttributeException;
public abstract class NexUser {
    private final String userId;
    private String username;
    private String email;
    static int userCounter = 1;
    public NexUser (String username, String email) throws InvalidUserAttributeException {
        if(username == null || username.isEmpty()){
            throw new InvalidUserAttributeException("username cannot be empty");
        }
        if(!email.contains("@")){
            throw new InvalidUserAttributeException("Invalid email format");
        }
        this.userId = "NEX-" + userCounter;
        userCounter++;
        this.username = username;
        this.email = email;
    }
    public abstract String getRolePermission();
    public void getProfileDetails(){
        System.out.println("------------- User Details -----------------");
        System.out.println("UserId: " + userId);
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
    }
}
