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