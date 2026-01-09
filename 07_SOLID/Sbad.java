// ⚠️ BAD DESIGN: This class handles EVERYTHING.
class Invoice {
    private double amount;
    private String studentName;

    public Invoice(String studentName, double amount) {
        this.studentName = studentName;
        this.amount = amount;
    }

    // Responsibility 1: Business Logic (Calculation)
    public double calculateTotalWithTax() {
        return amount * 1.18; // 18% Tax
    }

    // Responsibility 2: Presentation Logic (Printing)
    public void printInvoice() {
        System.out.println("---- INVOICE ----");
        System.out.println("User: " + studentName);
        System.out.println("Total: " + calculateTotalWithTax());
    }

    // Responsibility 3: Persistence Logic (Database)
    public void saveToDB() {
        System.out.println("Connecting to MySQL...");
        System.out.println("INSERT INTO invoices...");
    }
}


class Sbad{
    public static void main(String[] args) {
        Invoice invoice = new Invoice("Gaurav", 1000);
        invoice.printInvoice();
        invoice.saveToDB();
    }
}