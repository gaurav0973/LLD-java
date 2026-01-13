/*
Concept: 
    - Create the instance immediately when the class loads. 
    - Status: ✅ Thread Safe (JVM handles it).
*/
class EagerSingleton {
    // 1. instant immediatly when the class loads => thread safe
    private static final EagerSingleton instance = new EagerSingleton();

    // 2. Private Constructor
    private EagerSingleton() {
        System.out.println("Instance Created Eagerly");
    }

    // 3. Global Access Point
    public static EagerSingleton getInstance() {
        return instance; 
    }
}

class EagerLoading {
    public static void main(String[] args){
        // EagerSingleton db1 = new EagerSingleton()
        EagerSingleton db1 = EagerSingleton.getInstance();
        EagerSingleton db2 = EagerSingleton.getInstance();
        System.out.println(db1);
        System.out.println(db2);
        System.out.println(db1 == db2);

    }
}