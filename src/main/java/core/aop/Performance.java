package core.aop;

public interface Performance {
    void perform();

    default void pay(int amount) {
        System.out.println("paid " + amount + " €");
    }
}
