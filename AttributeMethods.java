// import java.utils.*;

class BankAccount{
    private double amount;
    private String name;
    BankAccount(double a, String s){
        this.amount = a;
        this.name = s;
    }
    public void setName(String s){
        this.name = s;
    }
    public String getName(){
        return this.name; 
    }
    public double getAmount(){
        return this.amount;
    }
    public boolean withdrawMoney(double withdrawAmount){
        if(withdrawAmount<0){
            System.out.println("Cannot withdraw money, please check your account balance");
            return false;
        }
        if(withdrawAmount > amount){
            System.out.println("There is no enough balance in your account");
            return false;
        }
        amount -= withdrawAmount;
        System.out.println("Amount debited, current balance : " + amount);
        return true;
    }
}

class AttributeMethods {
    public static void main(String[] args){
        BankAccount gaurav = new BankAccount(100000, "gaurav");
        gaurav.setName("Gaurav");
        System.out.println(gaurav.getAmount());
        gaurav.withdrawMoney(20000);



    }
}
