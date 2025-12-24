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
| Access Specifier |  Class |  Package | Subclass (Different Package) | Anywhere |
|------------------|--------|----------|------------------------------|----------|
| Private          |   ✅  |    ❌   |              ❌              |    ❌    |
| Default          |   ✅  |    ✅   |              ❌              |    ❌    |
| Protected        |   ✅  |    ✅   |              ✅              |    ❌    |
| Public           |   ✅  |    ✅   |              ✅              |    ✅    |



