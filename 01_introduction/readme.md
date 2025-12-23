# Index
1. Basics(Java)
2. OOP Concepts


## 1. Basics.java

- simple code(print "Hello, World!")
    - explain main
    - explain static
    - explain command line
    - sample output 

- Data types
    - primitive
        - int, float, double, char, boolean
    - non-primitive
        - String, Arrays, Classes

- Strings
    - define, immutable
    - char array to string
    - concatenation, length, charAt, substring, equals
    ```java
    String str = "Hello";
    String str2 = str + " World";
    int len = str.length();
    char ch = str.charAt(0);
    String sub = str.substring(0, 2);
    boolean isEqual = str.equals("Hello");
    ```

- input/output
    - BufferedReader class - faster
    - scanner class
    ```java
    import java.util.Scanner;
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    String str = scanner.nextLine();
    String str2 = scanner.next();
    scanner.close();
    ```

- Type casting
    - implicit
    - explicit
    ```java
    int i = 100;
    double d = i; // implicit casting

    double d2 = 9.78;
    int i2 = (int) d2; // explicit casting
    ```

- Constants
    - final keyword
    ```java
    final int MAX_VALUE = 100;
    ```

- Array 
    - declaration, length, accessing
    - for each loop
    - 2D array
    ```java
    int[] arr = new int[5]; // declaration
    arr[0] = 10; // accessing
    int len = arr.length; // length
    for (int num : arr) { // for each loop
        System.out.println(num);
    }
    int[][] matrix = new int[3][4]; // 2D array
    ```

- Conditional Statements
    - if, if-else, switch
    ```java
    int num = 10;
    if (num > 0) {
        System.out.println("Positive");
    } else if (num < 0) {
        System.out.println("Negative");
    } else {
        System.out.println("Zero");
    }

    switch (num) {
        case 1:
            System.out.println("One");
            break;
        case 2:
            System.out.println("Two");
            break;
        default:
            System.out.println("Other");
    }
    ```

- loops
    - for loop
    - while loop
    - do-while loop
    ```java
    for (int i = 0; i < 5; i++) {
        System.out.println(i);
    }

    int j = 0;
    while (j < 5) {
        System.out.println(j);
        j++;
    }

    int k = 0;
    do {
        System.out.println(k);
        k++;
    } while (k < 5);
    ```

- error handling
    - try-catch-finally
    ```java
    try {
        int result = 10 / 0;
    } catch (ArithmeticException e) {
        System.out.println("Cannot divide by zero");
    } finally {
        System.out.println("Execution completed");
    }
    ```

## 2. OOP Concepts.java
- What is OOP ?
- Difference between Procedural and OOP ? 
- Why use OOP ?
    - Modularity
    - Reusability
    - Scalability
    - Security
- Why is OOP better for large scale applications ?

## 3. Classes and Objects
- What is a Class ?
    - Logical Representation
    - Blueprint
- What is an Object ?
    - Instance of a class
    - Physical Representation
- What is attributes and behaviour ?
    - Attributes - properties/characteristics (variables)
    - Behaviour - methods/functions (functions)
- How are objects created and distroyed in memory ?
    - Stack and Heap Memory
        - Stack - Primitive data types and references
        - Heap - Objects
    - Creation - new keyword
    - Destruction - Garbage Collector

## 4. Attributes and Methods
- What are attributes and methods ?
    - Attributes - properties/characteristics (variables)
    - Methods - behaviour/functions (functions)
- How Attributes and methods works together ?
    - getters and setters

## 5. Constructors
- What is a constructor ?
    - Special method to initialize objects
- Key features of constructors
    - Same name as class
    -  No return type = void
    - Called automatically during object creation

- Purpose of constructors
    - create and initialize objects
    - reuse code
    - set some default values
- Types of constructors
    - non-parameterized constructor (default constructor)
    - Parameterized constructor
    - Copy constructor (not directly supported in Java, but can be mimicked)
- can a constructor call another constructor ?
    - Yes, using this() keyword
- can a constructor be overloaded ?
    - Yes, by defining multiple constructors with different parameter lists
