import java.util.*;

class Developer {
    String name;
    public Developer(String name){ 
        this.name = name; 
    }
}

class Team {
    String teamName;
    // AGGREGATION: The Team holds a list of Developers
    private List<Developer> members;

    public Team(String name, List<Developer> devs) {
        this.teamName = name;
        this.members = devs; // Just storing the reference!
    }
}

public class Aggrigation {
    public static void main(String[] args) {
        // 1. Create Developers (Independent existence)
        Developer dev1 = new Developer("Gaurav");
        Developer dev2 = new Developer("Maurya");
        
        List<Developer> initialDevs = new ArrayList<>();
        initialDevs.add(dev1);
        initialDevs.add(dev2);

        // 2. Create Team (Aggregation)
        Team backendTeam = new Team("Backend Squad", initialDevs);

        // 3. delete the team.
        backendTeam = null; 

        // 4. CHECK: Do the developers still exist?
        System.out.println("Team is gone, but " + dev1.name + " is still hired.");
    }
}


/*
Code Pattern: 
=> You usually 
    - pass the child objects into the parent's constructor
    - a setter method
The parent borrows them.
 */