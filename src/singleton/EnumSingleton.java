package singleton;

public enum EnumSingleton {
    INSTANCE;
    public void doSomething(){
        System.out.println("Doing Something");
    }

    public static void main(String[] args) {
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        enumSingleton.doSomething();
    }
}
