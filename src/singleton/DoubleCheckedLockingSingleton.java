package singleton;

public class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {}

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) { // first check
           synchronized (DoubleCheckedLockingSingleton.class) {
               if (instance == null) { // Double check
                   instance = new DoubleCheckedLockingSingleton();
               }
           }
        }
        return instance;
    }
}
