public class Dgood {
    public static void main(String[] args){
        // 1. Inject Credit Card
        Store store1 = new Store(new CreditCard());
        store1.buyCourse(100); // ✅ Now this works!

        // 2. Inject UPI
        Store store2 = new Store(new UPI());
        store2.buyCourse(100); // ✅ Works perfectly.
    }
}

// THE INTERFACE (The Contract)
interface PaymentMethod{
    void makePayment(int amount);
}

// WORKER 1
class CreditCard implements PaymentMethod {
    public void makePayment(int amount) {
        System.out.println("Payment of $" + amount + " made with Credit Card.");
    }
}

// WORKER 2
class UPI implements PaymentMethod {
    public void makePayment(int amount) {
        System.out.println("Payment of $" + amount + " made with UPI.");
    }
}

// THE BOSS (The Store)
class Store {
    private PaymentMethod paymentMethod;

    // INJECTION (Hiring)
    public Store(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    // ⬇️ THIS WAS MISSING
    // The Boss delegates the work to the worker.
    public void buyCourse(int amount) {
        this.paymentMethod.makePayment(amount);
    }
}