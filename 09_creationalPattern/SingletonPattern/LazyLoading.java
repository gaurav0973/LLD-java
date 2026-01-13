/*
Concept: 
    - Create the instance only when asked (getInstance). 
    - Status: ❌ NOT Thread Safe (Race Condition possible).
*/

class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("Instance Created Lazyly");
    }

    public static LazySingleton getInstance() {
        // 🚨 DANGER ZONE: 
        // If Thread A and Thread B enter here at the exact same time,
        // BOTH will see 'instance == null' and create TWO objects.
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}


class LazyLoading {
    public static void main(String[] args){
        // LazySingleton db1 = new LazySingleton();
        LazySingleton db1 = LazySingleton.getInstance();
        LazySingleton db2 = LazySingleton.getInstance();
        System.out.println(db1);
        System.out.println(db2);
        System.out.println(db1==db2);
    }
}