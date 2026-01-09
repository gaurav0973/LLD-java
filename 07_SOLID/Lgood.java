import java.util.ArrayList;
import java.util.List;

public class Lgood {
    public static void main(String[] args) {
        PayrollService payroll = new PayrollService();

        // bonus => only permanent employes
        List<BonusEligible> bonusList = new ArrayList<>();
        bonusList.add(new PermanentEmployee("Gaurav"));
        
        // bonusList.add(new Contractor("maurya")); // =>  COMPILER ERROR! 
        // I cannot accidentally add maurya to the bonus list. The system is bulletproof.

        payroll.payBonuses(bonusList);
    }
}

//1. parent
abstract class StaffMember {
    protected String name;
    public StaffMember(String name){ 
        this.name = name; 
    }
    public abstract double getSalary();
}

interface BonusEligible{
    double getBonus();
}

//2. parmanent employes => gets the bonus 
class PermanentEmployee extends StaffMember implements BonusEligible{
    public PermanentEmployee(String name){ 
        super(name); 
    }
    public double getSalary() { 
        return 5000; 
    }
    @Override
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
}

class PayrollService {
    public void payBonuses(List<BonusEligible> eligibleStaff) {
        for (BonusEligible e : eligibleStaff) {
            System.out.println("Paying bonus: " + e.getBonus());
        }
    }
}