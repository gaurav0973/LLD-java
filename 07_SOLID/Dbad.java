public class Dbad {
    public static void main(String[] args){
        Store store = new Store();   // High-level object created
        CreditCard card = new CreditCard(); // Low-level object created

        // Direct use of CreditCard
        card.processPayment(2000);

        // Indirect use via Store
        store.buyCourse();
    }
}

// Low Level (The Worker)
class CreditCard {
    public void processPayment(int amount) {
        System.out.println("Payment of $" + amount + " made with Credit Card.");
    }
}

// High Level (The Boss)
class Store {
    // DEPENDENCY: The Store creates the CreditCard itself.
    // It is impossible to use PayPal or UPI here.
    private CreditCard payment = new CreditCard();

    public void buyCourse() {
        payment.processPayment(5000);
    }
}