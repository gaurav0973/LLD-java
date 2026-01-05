## Exceptional Handling
- What is Exception Handling?
    - mechanism to handle runtime errors
- Why it is important?
    - to maintain normal application flow
    - to prevent program crashes
    - improves debugging and error reporting
- try, catch, finally blocks
    - try: code that may throw an exception
    - catch: code to handle the exception
    - finally: code that always executes
- throw and throws keywords
    - throw: used to explicitly throw an exception
    - throws: used in method signature to declare exceptions
- Custom Exceptions
    - creating user-defined exception classes
    ```java
    class MyCustomException extends Exception {
        public MyCustomException(String message) {
            super(message);
        }
    }
    ```
- checked and unchecked exceptions
    - checked: must be declared or handled (e.g., IOException)
        - examples: FileNotFoundException, ClassNotFoundException
    - unchecked: runtime exceptions (e.g., NullPointerException)
        - examples: ArithmeticException, ArrayIndexOutOfBoundsException


## Generics  => Important for interviews 
- What are Generics?
    -  provide a way to write type-safe and resuable code
    - works during run time
    - classes, interfaces, methods
```java
    List<String> list = new ArrayList<>();
    List<Integer> intList = new ArrayList<>();
    list.add("Hello");
    intList.add(100);
```
- Why use Generics?
    - type safety
    - code reusability
    - eliminates the need for type casting
- Generic Classes
    ```java
    class Box<T> {
        private T item;
        public void setItem(T item) {
            this.item = item;
        }
        public T getItem() {
            return item;
        }
    }
    ```
- Generic Methods
    - define in class definition or in the method itself
    ```java
    main(){
        public static <T> void printArray(T[] array) {
            for (T element : array) {
                System.out.println(element);
            }
        }
    }
    ```
- Bounded Type Parameters
    - restrict the types that can be used as type arguments
    ```java
    public <T extends Number> void processNumber(T number) {
        System.out.println("Processing number: " + number);
    }
    ```
- Advantages of genetics 
    - check happens at compile time => I know error while writing code
    - code reusability => write once use multiple times
    - type safety => no need to do type casting
- Wildcards in Generics : <?>
    - Lower bounded wildcard: <? extends T>
        - write access ❌
        - read access ✅
    - Upper bounded wildcard: <? super T>
        - write access ✅
        - read access ❌
    ```java
    public void processList(List<? extends Number> list) {
        for (Number num : list) {
            System.out.println(num);
        }
    }
    ```
    ```java
    public void addToList(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }
    ```

- Raw Types
    - using generic class or interface without type arguments
    - not type safe
    ```java
    List rawList = new ArrayList();
    rawList.add("Hello");
    rawList.add(100);
    ```






## File Handling 
- What is file handling?
    - reading from/writing to the files
- Importance in OOPs
    - manage loggings 
    - configurations
    - data storage
- File Class  
    ```java
    File file = new File("example.txt");
    if (file.exists()) {
        System.out.println("File exists");
    } else {
        System.out.println("File does not exist");
    }
    System.out.println("File size: " + file.length() + " bytes");
    System.out.println("File path: " + file.getAbsolutePath());
    System.out.println("File exists: " + file.exists());
    ```
- File/Buffer - Reader/Writer
    - BufferReader
        ```java
        BufferedReader br = new BufferedReader(new FileReader("example.txt"));
        ```
        - make sure to close/flush the resources
        ```java
        br.close();
        br.flush();
        ```
    - FileReader
        ```java
        FileReader fr = new FileReader("example.txt");
        ```
        

    