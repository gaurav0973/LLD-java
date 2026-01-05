// custom exception => Can mould as per our need
class UserNotFoundException extends Exception {
    public UserNotFoundException(String userId) {
        super("Could not find user with ID: " + userId);
    }
}
class UserProfileService {
    // throws => I might fail => handle it
    public void getUserData(String userId) throws UserNotFoundException {
        
        if (userId == null || userId.isEmpty()) {
            // build in checks
            throw new IllegalArgumentException("User ID cannot be empty"); 
        }
        // db call here 
        boolean userExists = false; 

        if (!userExists) {
            // custom exception
            throw new UserNotFoundException(userId); 
        }

        System.out.println("User found!");
    }
}

// 3. THE CONSUMER (Main)
public class ExceptionHandling {
    public static void main(String[] args) {
        UserProfileService service = new UserProfileService();
        try {
            service.getUserData("Gaurav123");
        } catch (UserNotFoundException e) {
            System.err.println("LOG: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("LOG: Coding Error - " + e.getMessage());
        } finally {
            System.out.println(">> Cleanup operations (closing connections)...");
        }
    }
}