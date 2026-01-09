import java.util.ArrayList;
import java.util.List;

public class Lbad {
    public static void main(String[] args) {
        // 1. Create the Service
        PayrollService payroll = new PayrollService();

        // 2. Create the List of Staff
        List<StaffMember> myTeam = new ArrayList<>();
        
        myTeam.add(new PermanentEmployee("Gaurav"));   // Works fine
        myTeam.add(new Contractor("John"));           // Works fine (for now)

        // 3. EXECUTE THE CRASH
        // This method accepts 'StaffMember', so it thinks everyone is safe.
        // It will crash when it hits 'John' because of the exception.
        payroll.payBonuses(myTeam); 
    }
}
// ... (The rest of your class definitions were correct)

//1. parent
abstract class StaffMember {
    protected String name;
    public StaffMember(String name){ 
        this.name = name; 
    }
    public abstract double getSalary();

    // The Dangerous Assumption: "Everyone gets a bonus"
    public abstract double getBonus(); 
}

//2. parmanent employes => gets the bonus 
class PermanentEmployee extends StaffMember {
    public PermanentEmployee(String name){ 
        super(name); 
    }
    public double getSalary() { 
        return 5000; 
    }
    public double getBonus() { 
        return 500; 
    }
}

//3. contractual => do not get the bonus => but extends parent => voilates Liskov Substitution
class Contractor extends StaffMember {
    public Contractor(String name) { 
        super(name); 
    }
    public double getSalary() { 
        return 3000; 
    }
    // contractor => does not get bonus => voilates parents contract
    @Override
    public double getBonus() {
        throw new UnsupportedOperationException("Contractors do not get bonuses!");
    }
}

// 4. THE CRASH
class PayrollService {
    public void payBonuses(List<StaffMember> staffList) {
        for (StaffMember s : staffList) {
            // CRASH when it hits a Contractor
            System.out.println("Paying bonus: " + s.getBonus()); 
        }
    }
}