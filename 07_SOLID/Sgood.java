public class Sgood {
    public static void main(String[] args) {
        // Step 1: Create Data
        Invoice invoice = new Invoice("Gaurav", 1000);

        // Step 2: Calculate (Logic)
        InvoiceCalculator calculator = new InvoiceCalculator();
        double finalAmount = calculator.calculateTotalWithTax(invoice);

        // Step 3: Print (Presentation)
        // We pass the RESULT of step 2 into step 3.
        InvoicePrinter printer = new InvoicePrinter();
        printer.printInvoice(invoice, finalAmount);

        // Step 4: Save (Persistence)
        InvoiceRepository repository = new InvoiceRepository();
        repository.saveToDB(invoice);
    }
}

// Pure Data holders
/*
Invoice
    - amount
    - studentName
    - calculateTotalWithTax() => R1 => Class InvoiceCalculator
    - printInvoice() => R2 => Class InvoicePrinter
    - saveToDB() => R3 => Class InvoiceRepository
*/
class Invoice {
    private double amount;
    private String studentName;

    public Invoice(String studentName, double amount) {
        this.studentName = studentName;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getStudentName() {
        return studentName;
    }
}


// Reason to change: Only if the tax rate changes (e.g., from 18% to 20%).
class InvoiceCalculator {
    public double calculateTotalWithTax(Invoice invoice) {
        return invoice.getAmount() * 1.18; // 18% Tax
    }
}

// Reason to change: Only if we want to change the output format (e.g., add currency symbols).
class InvoicePrinter {
    public void printInvoice(Invoice invoice, double totalAmount) {
        System.out.println("---- OFFICIAL INVOICE ----");
        System.out.println("Customer: " + invoice.getStudentName());
        System.out.println("Subtotal: " + invoice.getAmount());
        System.out.println("Total (w/ Tax): " + totalAmount);
        System.out.println("--------------------------");
    }
}

// Reason to change: Only if we switch databases (e.g., MySQL to MongoDB).
class InvoiceRepository {
    public void saveToDB(Invoice invoice) {
        System.out.println(">> [DB Log] Connecting to SQL Database...");
        System.out.println(">> [DB Log] Saved invoice for " + invoice.getStudentName());
    }
}

