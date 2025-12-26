class BankAccount{
    static int counter = 0;
    private String name;
    private int amount;
    BankAccount(String name, int amount){
        this.name = name;
        this.amount = amount;
        counter++;
        System.out.println("Account created for " + name + ". Total accounts: " + counter);
    }
    public String getName(){
        return this.name;
    }
    public int getAmount(){
        return this.amount;
    }
    public static int getTotalAccountCreated(){
        return counter;
    }
}
public class StaticVariable {
    public static void main(String[] args){
        BankAccount acc1 = new BankAccount("Gaurav", 5000);
        BankAccount acc2 = new BankAccount("Gauravi", 7000);
        System.out.println("Total accounts created(Static Variable): " + BankAccount.counter);
        // System.out.println("Total accounts created(Static): " + acc1.counter); // Not recommended but works
        System.out.println("Total accounts created(Static Method): " + BankAccount.getTotalAccountCreated());
    }

}
