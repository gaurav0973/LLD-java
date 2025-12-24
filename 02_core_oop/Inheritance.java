class User{
    protected String username;
    private String password;
    User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public void login() {
        System.out.println(this.username + " logged in.");
    }

}
class Admin extends User{
    private String adminLevel;
    public Admin(String username, String password, String adminLevel){
        super(username, password);
        this.adminLevel = adminLevel;
    }
    public void banUser(User u){
        System.out.println("Admin " + this.username + " banned " + u.username);
    }
}


public class Inheritance {
    public static void main(String[] args){
        User user1 = new User("Gaurav", "password123");
        user1.login();
        Admin admin1 = new Admin("AdminGaurav", "adminpass", "Super");
        admin1.login();
        admin1.banUser(user1);
    }
}
