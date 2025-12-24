class Parent {
    static void show() { System.out.println("Parent Static"); }
    void print() { System.out.println("Parent Print"); }
}

class Child extends Parent {
    static void show() { System.out.println("Child Static"); } // Method Hiding
    @Override
    void print() { System.out.println("Child Print"); }
}

public class Test {
    public static void main(String[] args) {
        Parent obj = new Child();
        obj.show();  // What does this print?
        obj.print(); // What does this print?
    }
}