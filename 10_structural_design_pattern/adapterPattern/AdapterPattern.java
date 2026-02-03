public class AdapterPattern {
    public static void main(String[] args) {
        CheckoutService checkoutService = new CheckoutService(new RazorpayAdapter(new Razorpay()));
        checkoutService.checkout("abc123", 1000.95);
    }
}

class CheckoutService{
    private Paymentgateway paymentgateway;
    public CheckoutService(Paymentgateway paymentgateway){
        this.paymentgateway = paymentgateway;
    }

    public void checkout(String orderId, double amt){
        paymentgateway.pay(orderId, amt);
    }
}

interface Paymentgateway{
    void pay(String orderId, double amount);
}
class Stripe implements Paymentgateway{
    @Override
    public void pay(String orderId, double amount){
        System.out.println("Paid Rs. " + amount + " using Stripe for orderId: " + orderId);
    }
}

class RazorpayAdapter implements Paymentgateway{
    private Razorpay razorpay;
    public RazorpayAdapter(Razorpay razorpay){
        this.razorpay = razorpay;
    }
    @Override
    public void pay(String orderId, double amt){
        razorpay.makePayment(orderId, amt);
    }
}

class Razorpay{
    public void makePayment(String orderId, double amt) {
        System.out.println("Razorpay processed payment of Rs. " + amt + " for OrderID: " + orderId);
    }
}