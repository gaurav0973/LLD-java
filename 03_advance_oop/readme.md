## Abstraction
- What is Absutraction?
    - Hiding the implementation details and exposing only the essential features of the object
- Why use Abstraction?
    - Code Understanding
    - Code Reusability
    - Maintainability ☠️
- How to achieve Abstraction in Java?
    - Abstract Classes
    - Interfaces
- Why default and static methods in Interface?
    - Default methods
        - allows to add new methods to interfaces without breaking the existing implementation of these interfaces.
    - Static methods
        - can be called independently without an instance of the interface.
- Can a absract class extends another abstract class?
    - Yes, an abstract class can extend another abstract class.
- Can we have a constructor and create instance of abstract class?
    - An abstract class can have a constructor, but you cannot create an instance of an abstract class directly.
    - The constructor of the abstract class is called when a subclass is instantiated
    - Top to Bottom => Superclass to Subclass


## Interfaces
- What is Interface?
    - blueprint of class that defines a contract for what a class can do, but does not provide the implementation details.
- Can it have instance variables?
    - No, interfaces cannot have instance variables.
    - They can only have constants (static final variables).
    - static final cnt = 0;
- Can they have constructors?
    - No
    - Because interfaces cannot be instantiated directly.
- Can a class implement multiple interfaces?
    - Yes
    - Java supports multiple inheritance through interfaces.
- Why use Interfaces?
    - Multiple Inheritance
    - Contracts 
    - Loose Coupled => not tightly bound, can be changed easily
- Interface inheritance
    - Yes, an interface can extend another interface.
- Default and Static methods in Interface
    - Default methods
        - allows to add new methods to interfaces without breaking the existing implementation of these interfaces.
    - Static methods
        - can be called independently without an instance of the interface.

## Static Keyword
- What does the static keyword mean?
    - belongs to the class rather than the objects
    - 
- Static Variables
- Static Methods
- Static Blocks
    - used for static initialization of a class
    - Not commonly used
- Can a static method access non-static methods?
    - No 
```java
class Eample {
    public static void doSum() {
        System.out.println("This is a static method.");
        sum(); // Error: Cannot make a static reference to the non-static method sum()
    }

    public int sum() {
        System.out.println("This is a non-static method.");
    }
}
class Main {
    public static void main(String[] args) {
        Eample.staticMethod();
    }
}
```
- Can a non-static method access static methods?
    - Yes
    - A non-static method can directly call static methods and access static variables.
- Advantages
    - Memory Efficiency
    - Common Across all instance
    - Utility Methods => Math.sqrt() 
    - initilization of class level data => static block


## Inner Classes
- What are inner classes?
    - A class defined within another class
- Types of inner classes
    - 4 types
- static nested class
    - static
    - can access static members of outer class directly
    - cannot access non-static members of outer class directly
    - can be instantiated without an instance of the outer class
- Non-static inner class
    - in order to create instance of inner class, we need an instance of outer class
    - can access both static and non-static members of outer class
- local inner class
    - class defined within method/block
    - can access final or effectively final variables from enclosing method/block
    - cannot have access modifiers (like public, private)
- ananymous inner class
    - class without a name
    - used to create a one-time use class that implements an interface or extends a class
    - often used in event handling and callbacks
```java
interface Greeting {
    void sayHello();
}
public class Main {
    public static void main(String[] args) {
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello, World!");
            }
        };
        greeting.sayHello();
    }
}


```
```java
public static void main(String[] args){
    ArrayList<Integer> list = new ArrayList<>(){
        @Override
        public boolean add(Integer va) {
            System.out.println("Adding element: " + val);
            super.add(va);
            return true;
        };
    }
    list.add(10);
}
```