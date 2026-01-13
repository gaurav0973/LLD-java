/*
Problem: 
    - Every time I use new, I get a completely different object.
*/
class Bad {
    public static void main(String[] args) {
        Database db1 = new Database(); 
        Database db2 = new Database(); 
        
        System.out.println(db1);
        System.out.println(db2);
        System.out.println(db1 == db2); // false
    }
}

class Database {
    public Database() {
        System.out.println("Connected to DB");
    }
}
