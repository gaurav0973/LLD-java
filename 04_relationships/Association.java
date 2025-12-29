class Patient {
    String name;
    public Patient(String name){ 
        this.name = name; 
    }
}

class Doctor {
    String name;
    public Doctor(String name){ 
        this.name = name; 
    }

    // ASSOCIATION: The Doctor interacts with the Patient here.
    // The Doctor does NOT store the Patient permanently as a field.
    public void consult(Patient p) {
        System.out.println("Doctor " + this.name + " is checking pulse of " + p.name);
    }
}

public class Association{

    public static void main(String[] args) {
        Doctor doc = new Doctor("Maurya");
        Patient pat = new Patient("Gaurav");

        // Interaction happens here
        doc.consult(pat);
        
        // If we delete the doctor...
        doc = null; 
        
        // ...the patient is perfectly fine.
        System.out.println(pat.name + " is still alive."); 
    }
}