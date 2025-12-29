# Object-Oriented Relationships in Java
A quick reference guide to understanding Association, Aggregation, and Composition based on code structure and memory lifecycle.

---

## 1. Association (The "Handshake")
**Concept:** Two completely independent objects interacting temporarily.  
**Ownership:** None.  
**Lifecycle:** A and B live and die separately.

### Code Signature
* **Where is `new`?** Both objects are created independently in `main`.
* **How is it passed?** As a **Method Argument**.

### Example Code
```java
// CLASS A (Independent)
class Student {
    String name;
    Student(String name) { this.name = name; }
}

// CLASS B (Independent)
class Teacher {
    String name;
    Teacher(String name) { this.name = name; }

    // ASSOCIATION: Interaction happens via method argument
    void teach(Student s) {
        System.out.println(this.name + " is teaching " + s.name);
    }
}

// USAGE
public class Main {
    public static void main(String[] args) {
        Teacher t = new Teacher("Mr. Smith"); // Created independently
        Student s = new Student("Gaurav");    // Created independently
        
        t.teach(s); // Temporary interaction
    }
}
```



## Aggregation (The "Borrowing")
**Concept:** A "Has-A" relationship where the container holds a reference to an object but does not create it.

**Ownership:** Weak.

**Lifecycle:** If the Container dies, the Part survives.
### Code Signature
* **Where is `new`?** The Part is created OUTSIDE (in main).
* **How is it passed?** Passed into the Constructor (Dependency Injection).

### Example Code
```java
// THE PART
class Book {
    String title;
    Book(String title) { this.title = title; }
}

// THE CONTAINER
class Library {
    Book book; 

    // AGGREGATION: We receive an existing object
    Library(Book book) {
        this.book = book; 
    }
}

// USAGE
public class Main {
    public static void main(String[] args) {
        // 1. Create OUTSIDE
        Book b = new Book("Java Mastery"); 
        
        // 2. Pass INSIDE
        Library lib = new Library(b); 
        
        lib = null; // Delete Library
        // 'b' is still alive and safe here.
    }
}
```

## Composition (The "Creation")
**Concept:** A "Part-Of" relationship where the container is responsible for the creation and destruction of the part.

**Ownership:** Strong.

**Lifecycle:** If the Container dies, the Part dies immediately.

### Code Signature
* **Where is `new`?** Inside the Constructor of the Container.
* **How is it passed?** It is NOT passed. We pass raw data (Strings/Ints) to build it.

### Example Code
```java
// THE PART
class Room {
    String type;
    Room(String type) { this.type = type; }
}

// THE CONTAINER
class House {
    Room room; 

    // COMPOSITION: The Container calls 'new'
    House(String roomType) {
        this.room = new Room(roomType); 
    }
}

// USAGE
public class Main {
    public static void main(String[] args) {
        // We only create the House. The House creates the Room.
        House h = new House("Bedroom");
        
        h = null; // Delete House
        // The Room is destroyed (Garbage Collected) because no one else references it.
    }
}
```

