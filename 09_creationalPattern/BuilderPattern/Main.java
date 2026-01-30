public class Main{
    public static void main(String[] args){
        User gaurav = new User.UserBuilder("Gaurav", "Maurya").build();

        User abcd = new User.UserBuilder("abcd", "efggh")
                                                                            .setAge(22)
                                                                            .setEmail("abc@gmail.com")
                                                                            .build();
    }
}

class User {
    //required 
    private final String firstName;
    private final String lastName;

    // optional 
    private final String email;
    private final String phone;
    private final String address;
    private final int age;

    private User(UserBuilder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
        this.age = builder.age;
    }

    public static class UserBuilder{
        // required 
        private  String firstName;
        private  String lastName;

        // optional 
        private  String email;
        private  String phone;
        private  String address;
        private int age;

        // required constructor
        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        // setters => returns UserBuilder class => this 
        public UserBuilder setEmail(String email){
            this.email = email;
            return this;
        }
        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }
        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }
        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        // build method => return User object => user
        public User build(){
            User user = new User(this);
            return user;
        }
    }
}