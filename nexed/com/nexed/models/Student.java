package nexed.com.nexed.models;
import nexed.com.nexed.exceptions.InvalidUserAttributeException;

public class Student extends NexUser {
    private int gradeYear;
    public Student(String username, String email, int gradeYear) throws InvalidUserAttributeException {
        super(username, email);
        this.gradeYear = gradeYear;
    }

    // role => using abstract method from NexUser
    @Override
    public String getRolePermission() {
        return "CONTRIBUTOR";
    }
}