class ServerID {
    static int activeServers = 0;
    String serverName;

    /*
    static block
    - Runs EXACTLY ONCE when the class is first loaded by the JVM.
    - Use Case: Complex setup, loading config files, connecting to drivers.
    */
    static {
        System.out.println(">> [JVM] Loading ServerID Class...");
        activeServers = 100;
    }

    public ServerID(String name) {
        this.serverName = name;
        activeServers++;
    }

    // ServerID.getStatus()
    static void getStatus() {
        System.out.println("Total Active Servers: " + activeServers);
        // System.out.println("Server Name: " + serverName); // ERROR
    }

    // non-static : can access both static and non-static
    void decommission() {
        System.out.println("Stopping " + this.serverName);
        activeServers--;
    }
}

public class Static {
    public static void main(String[] args) {
        
        ServerID s1 = new ServerID("Alpha");
        ServerID s2 = new ServerID("Beta");

        ServerID.getStatus(); 

        s1.decommission();
        
        ServerID.getStatus();
    }
}