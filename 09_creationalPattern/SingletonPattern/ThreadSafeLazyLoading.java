/*
Concept: 
    - Use a "Lock" so only one thread can enter the creation logic at a time. 
    - Status: ✅ Thread Safe.
*/

public class ThreadSafeLazyLoading {
    public static void main(String[] args){
        ThreadSafeSingleton db1 =  ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton db2 =  ThreadSafeSingleton.getInstance();
        System.out.println(db1);
        System.out.println(db2);
        System.out.println(db1 == db2);
    }
}
class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {}
    /*
    🔒 SYNCHRONIZED: Only one thread can execute this method at a time.
                        - Others must wait in line.
    */
    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
