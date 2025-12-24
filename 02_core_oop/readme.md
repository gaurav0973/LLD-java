# Core principle of OOP
They are called the four pillars of OOP. They are:
1. Encapsulation
2. Abstraction
3. Inheritance
4. Polymorphism



## Encapsulation
- What is Encapsulation?
    - Wrapping data (variables) and code (methods) together as a single unit.   
- Why Encapsulation?
    - Data Hiding
    - Security
    - Maintainability ☠️
    - modularity
- How to achieve Encapsulation in Java?
    - Access Modifiers
        - Private
        - Default
        - Protected
        - Public
    - Getters and Setters

### Access Specifiers
- What are Access Specifiers?
    - controles the visibility of classes, methods, and variables.
- Purpose of Access Specifiers
    - ensure proper encapsulation
    - Control access to class members
- Types of Access Specifiers in Java
    - Private
        - Accessible only inside the class in which it is defined
        - private class ❌ when it comes to top-level classes but yes for nested classes
    - Protected
        - Accessible within the same package and subclasses
    - Public
        - Accessible from any other class
- What is default access specifier?
    - When no access specifier is defined, it is considered default.
    - Accessible only within the same package
    - package-private => only limited to the package => by default if no access specifier is mentioned
- What is package ? => package = folder
    - folderNameA
        - A.java
        - B.java
    - folderNameB
        - C.java
        - D.java
    - Classes A and B are in the same package (folderNameA)
    - Classes C and D are in the same package (folderNameB)
    - Classes from folderNameA cannot access classes from folderNameB directly if they have default access specifier.
-  What is subclass ?
    - class ABC extends XYZ => ABC is subclass of XYZ
    - Inheritance concept
- Table of Access Specifiers
- | Access Specifier |  Class |  Package | Subclass (Different Package) | Anywhere |
- |------------------|--------|----------|------------------------------|----------|
- | Private          |   ✅  |    ❌   |              ❌              |    ❌    |
- | Default          |   ✅  |    ✅   |              ❌              |    ❌    |
- | Protected        |   ✅  |    ✅   |              ✅              |    ❌    |
- | Public           |   ✅  |    ✅   |              ✅              |    ✅    |


## Inheritance
- What is Inheritance? What are parent? subclass?
    - It is a OOP concept where a class can derive properties and behaviour from another class.
    - Keyword : extends ✅
- Types of Inheritance in Java
    - Single Inheritance
    - Multilevel Inheritance
    - Hierarchical Inheritance
    - Hybrid Inheritance (through interfaces)
- Advantage of Inheritance
    - Code Reusability
    - Code Extension
    - Code Modularity => easier to maintain
    - Code maintainability
- Key points for interview!
    - access modifiers and inheritance  
    - overriding 
    - super keyword ☠️
        - give access to super class = parent class members
        - used to call parent class constructor or methods or variables 
- Can a subclass Inherit private members?
    - No
    - subclass can access private members through public/protected getters and setters of parent class.
- Method Overriding vs Method Overloading
    - Overriding => runtime polymorphism => same method signature (name + parameters) in parent and child class => used in inheritance
    - Overloading => compile time polymorphism => same method name with different parameters in the same class
- Does java allow multiple inheritance?
    - No, to avoid ambiguity (Diamond Problem)
    - Achieved through interfaces



## Polymorphism
- What is Polymorphism?
    - means many forms and allow methods and objects to behave differently based on the context.
- Types of Polymorphism
    - Compile-time = static binding => Inheritance is not must be there =>
        - Method Overloading
    - Runtime = dynamic binding => Inheritance is must be there =>
        - Method Overriding
- Can a return type differentiate overloading?
    - No, method signature is determined by method name and parameters only.
- Can I override static methods?
    - No, static methods belong to the class, not the instance.
- How to trigger a static method from child class ?
    - ChildClassName.staticMethodName();
- Can I overload main method?
    - Yes, main method can be overloaded like any other method.
- Can I override private methods?
    - No, private methods are not visible to subclasses.



