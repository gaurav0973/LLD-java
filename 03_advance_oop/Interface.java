//We are building a smart office system for CodeYodha. We have a SmartPrinter that acts as both a Printer and a Scanner.

// Printer
interface Printer {
    //variables (by default, public static final)
    String INK_TYPE = "LaserJet"; 

    //methods (by default, public abstract)
    void print(String content);

    // 3. default method (Java 8+)
    default void printWarmup() {
        System.out.println(">> [Printer] Warming up ink...");
    }
}

// Scanner
interface Scanner {
    void scan(String docName);

    //static method (Java 8+) = belongs to interface, not to object
    static void help() {
        System.out.println(">> [Scanner Info] clean glass before scanning.");
    }
}

// SmartMachine implements both Printer and Scanner interfaces
class SmartMachine implements Printer, Scanner {
    
    @Override
    public void print(String content) {
        System.out.println("Printing: '" + content + "' using " + Printer.INK_TYPE);
    }

    @Override
    public void scan(String docName) {
        System.out.println("Scanning document: " + docName);
    }
}

public class Interface {
    public static void main(String[] args) {
        SmartMachine machine = new SmartMachine();


        Scanner.help(); 

        machine.printWarmup(); 
        machine.scan("Invoice.pdf");
        machine.print("CodeYodha_Logo.png");
    }
}
