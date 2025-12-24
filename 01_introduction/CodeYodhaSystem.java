import java.util.Scanner;

/*
We are building a Student Registration System.
Rules:
- Students must have a valid ID.
- We need to track the total number of students (Static).
- We need to handle "Guest" users (Overloading).
- We need to prevent data corruption when copying users (Copy Constructor).
*/


class Student {
    private final int studentId;      // 'final': ID never changes once set
    private String name;
    private double feeBalance;

    // Static => Shared by all objects
    public static int totalStudents = 0; 
    public static final String PLATFORM = "CodeYodha"; // Constant

    public Student(int id, String name, double fee) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive!");
        }
        
        this.studentId = id;
        this.name = name;
        this.feeBalance = fee;
        
        // Static => increase on every counter
        totalStudents++; 
    }
    public Student(int id) {
        this(id, "Guest User", 0.0); // Default name and fee
    }

    // copy constructor
    public Student(Student other) {
        this(other.studentId, other.name, other.feeBalance);
    }

    public void payFee(double amount) {
        if (amount < 0) {
            System.out.println("Error: Cannot pay negative amount.");
            return;
        }
        this.feeBalance -= amount;
    }

    public String getDetails() {
        return "ID: " + this.studentId + " | Name: " + this.name + " | Due: $" + this.feeBalance;
    }
}

public class CodeYodhaSystem {
    
    // Static method (Can be called without creating an object of this class)
    public static void printBanner() {
        System.out.println("=== Welcome to " + Student.PLATFORM + " System ===");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printBanner();


        Student[] batch = new Student[3];
        int count = 0;
        while (count < batch.length) {
            try {
                System.out.println("\nRegistering Student #" + (count + 1));
                
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();

                scanner.nextLine(); 
                System.out.print("Enter Name (or type 'GUEST' for default): ");
                String inputName = scanner.nextLine();

                if (inputName.equalsIgnoreCase("GUEST")) {
                    // overloaded constructor
                    batch[count] = new Student(id);
                } else {
                    //Main Constructor
                    batch[count] = new Student(id, inputName, 500.0);
                }

                System.out.println("Success! Total Students: " + Student.totalStudents);
                count++;

            } catch (IllegalArgumentException e) {
                System.out.println("Registration Failed: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid Input! Please try again.");
                scanner.nextLine();
            }
        }

        // COPY CONSTRUCTOR DEMO
        System.out.println("\n--- Testing Copy Constructor ---");
        Student original = batch[0];
        Student copyCat = new Student(original); // Create a clone

        // Prove they are different objects in memory
        copyCat.payFee(100); // Change the copy
        
        System.out.println("Original: " + original.getDetails()); // Should be unchanged
        System.out.println("Copy:     " + copyCat.getDetails());  // Should have less fee

        // FINAL ARRAY TRAVERSAL (For-Each Loop)
        System.out.println("\n--- Final Batch Report ---");
        for (Student s : batch) {
            if (s != null) {
                System.out.println(s.getDetails());
            }
        }
        
        scanner.close();
    }
}