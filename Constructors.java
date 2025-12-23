class Account{
    private String name;
    private double amount;
    //1. Default constructor
    Account(){

    }
    // paramarerised constructor
    Account(String name, double amount){
        this.name = name;
        this.amount = amount;
    }
    //  copy constructor
    Account(Account account){
        // Account(account.getName(), account.getAmount());
        this(account.getName(), account.getAmount());
    }
    public String getName(){
        return this.name;
    }
    public double getAmount(){
        return this.amount;
    }
}


class Constructors {
    public static void main(String[] args){
        //1. default constructor
        // Account obj1 = new Account();
        // System.out.println(obj1.getName()); // null

        // 2. paramererised constructor
        // Account obj2 = new Account("Gaurav", 100000);
        // System.out.println(obj2.getName()); // Gaurav

        // 3. copy constructor
        Account obj3 = new Account("Gaurav", 100000);
        Account obj4 = new Account(obj3);
        System.out.println("Object-3 : " + obj3.getName());
        System.out.println("Object-4 : " + obj4.getName());
    }
}
