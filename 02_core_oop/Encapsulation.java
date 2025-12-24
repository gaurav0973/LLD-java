class DigitaWallet{
    private double balance;
    DigitaWallet(){

    }
    DigitaWallet(double balance){
        this.balance = balance;
    }
    public boolean addMoneyInWallet(double amount){
        if(amount <= 0){
            System.out.println("Error: Cannot add zero or negative money.");
            return false;
        }
        this.balance += amount;
        logTransaction("Credit", amount);
        return true;
    }

    private void logTransaction(String type, double amount){
        System.out.println("[LOG] " + type + ": Rs. " + amount);
    }
    public double getBalance() {
        return this.balance;
    }
}


public class Encapsulation {
    public static void main(String[] args){
        DigitaWallet gaurav = new DigitaWallet(0);
        // gaurav.balance = -500;
        gaurav.addMoneyInWallet(2000);
        gaurav.addMoneyInWallet(1000);
        System.out.println(gaurav.getBalance());
        System.out.println(gaurav.getClass());
    }
}