// Authentication => SocialAuth => GoogleLogin
abstract class Authentication {
    protected String platformName;
    public Authentication(String name) {
        this.platformName = name;
        System.out.println(">> [Base] Auth Module Initialized for: " + name);
    }

    // common =>> for all
    public void commonSecurityCheck() {
        System.out.println("   [Security] Checking for SQL Injection...");
    }
    // abstract method => login
    public abstract void login(String credentials);
}
// SocialAuth => Google, Github...
abstract class SocialAuth extends Authentication {
    
    public SocialAuth(String name) {
        super(name);
    }
    
    // We add a new abstract requirement for social apps
    public abstract void getAccessToken();
}

// GoogleLogin => iska object bnaenga
class GoogleLogin extends SocialAuth {
    
    public GoogleLogin() {
        super("Google");
        // super("Google") => Authentication("Google") => platformName = "Google"
    }

    @Override
    public void login(String email) {
        commonSecurityCheck();
        System.out.println("   [Google] Connecting to API for " + email);
        getAccessToken();
    }
    @Override
    public void getAccessToken() {
        System.out.println("   [Google] Token received: xyz-123");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        // Authentication auth = new Authentication("Test"); // ERROR
        
        GoogleLogin userObj = new GoogleLogin();
        userObj.login("gaurav@gmail.com");
    }
}

/*
Q: Can an abstract class extend another abstract class?
- Yes
=> Layered Architecture : Authentication -> SocialAuth -> GoogleLogin.
- Authentication handles generic security.
- SocialAuth handles API tokens
- GoogleLogin handles the specific URL.
This layering allows us to add FacebookLogin later by just extending SocialAuth, without rewriting the security logic from the very top.
*/


