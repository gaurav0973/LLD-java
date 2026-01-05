package nexed.com.nexed;
import nexed.com.nexed.exceptions.InvalidUserAttributeException;
import nexed.com.nexed.models.Educator;
import nexed.com.nexed.models.FamilyMember;
import nexed.com.nexed.models.Student;

public class NexEdApp {
    public static void main(String[] args) {
        System.out.println("=== Booting NexEd System ===");

        try {
            // Case 1: Student
            Student s1 = new Student("Gaurav", "gaurav@nexed.com", 2026);
            s1.getProfileDetails();

            // Case 2: Educator
            Educator e1 = new Educator("Prof. Maurya", "maurya@nexed.com", "Maths");
            e1.getProfileDetails();

            // System.out.println("\n--- Testing Error Handling ---");
            // // Case 3: INVALID Family Member (Should crash nicely)
            // FamilyMember f1 = new FamilyMember("Dad", "dad_gmail.com", new String[]{"NEX-1"});
            // f1.getProfileDetails(); // This line should never run

        } catch (InvalidUserAttributeException e) {
            // 8. Catching our custom error
            System.err.println("REGISTRATION FAILED: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("UNEXPECTED ERROR: " + e.getMessage());
        }
    }
}