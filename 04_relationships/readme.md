## Association, Aggregation, and Composition
In object-oriented programming, relationships between classes can be categorized into three main types: association, aggregation, and composition. Understanding these relationships is crucial for designing robust and maintainable software systems.

- What are relationship between classes?
  - This is a way how objects interact with each other
- Tyoes of relationships
  - Association
  - Aggregation
  - Composition
- Association
    - A relationship where one class interacts with another class.
    - General relationship
    - No ownership implied.
    - Classes can exist independently.
- Types of Association
    - One-to-One
        - Student and Passport
    - One-to-Many
        - Student and Subjects 
    - Many-to-Many
        - Student and Courses
- Aggregation
    - A class contains another class within it but does not own it.
    - Weak relationship
    - The contained class can exist independently of the container class.
    - Example: A `Library` class contains `Book` objects. If the `Library` is deleted, the `Book` objects can still exist.
- Composition
    - A class contains another class and owns it.
    - Strong relationship
    - The contained class(two classes one in another) cannot exist independently of the container class.
    - Example: A `House` class contains `Room` objects. If the `House` is deleted, the `Room` objects are also deleted.
- Can a class participate in multiple types of relationships?
    - Yes, a class can be involved in different types of relationships with other classes depending on the context.


## Object Cloning 
- What is Object Cloning?
  - process of creating an (exact copy)🌟 of an existing object.
- Why use object cloning?
  - To create a new object with the same state as an existing object without affecting the original object.
- How does cloning works in java?
- Types of Cloning
    - Shallow Cloning
        - Copies the object's primitive fields and (references to objects)
        - The cloned object shares references to the same objects as the original.
        - Changes made to the referenced objects in the cloned object will affect the original object.
    ```java
        class Address {
            String city;
            String country;

            Address(String city, String country) {
                this.city = city;
                this.country = country;
            }
        }

        class Person implements Cloneable {
            String name;
            Address address;

            Person(String name, Address address) {
                this.name = name;
                this.address = address;
            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone(); // Shallow copy
            }
        }

        public class Main {
            public static void main(String[] args) throws CloneNotSupportedException {
                Address address = new Address("New York", "USA");
                Person originalPerson = new Person("John", address);
                Person clonedPerson = (Person) originalPerson.clone();

                // Modifying the address of the cloned person
                clonedPerson.address.city = "Los Angeles";

                System.out.println("Original Person's City: " + originalPerson.address.city); // Outputs "Los Angeles"
                System.out.println("Cloned Person's City: " + clonedPerson.address.city);     // Outputs "Los Angeles"
            }
        }
    ```
    - Deep Cloning
        - Copies everything, including the objects referenced by the original object.
        - The cloned object has its own copies of the referenced objects.
        - Changes made to the referenced objects in the cloned object do not affect the original object.
    ```java
        class Address {
            String city;
            String country;

            Address(String city, String country) {
                this.city = city;
                this.country = country;
            }

            // Copy constructor for deep cloning
            Address(Address address) {
                this.city = address.city;
                this.country = address.country;
            }
        }
        class Person implements Cloneable {
            String name;
            Address address;

            Person(String name, Address address) {
                this.name = name;
                this.address = address;
            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                Person clonedPerson = (Person) super.clone();
                clonedPerson.address = new Address(this.address); // Deep copy
                return clonedPerson;
            }
        }
        public class Main {
            public static void main(String[] args) throws CloneNotSupportedException {
                Address address = new Address("New York", "USA");
                Person originalPerson = new Person("John", address);
                Person clonedPerson = (Person) originalPerson.clone();

                // Modifying the address of the cloned person
                clonedPerson.address.city = "Los Angeles";

                System.out.println("Original Person's City: " + originalPerson.address.city); // Outputs "New York"
                System.out.println("Cloned Person's City: " + clonedPerson.address.city);     // Outputs "Los Angeles"
            }
        }

