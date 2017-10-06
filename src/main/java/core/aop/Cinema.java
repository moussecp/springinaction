package core.aop;

public class Cinema implements Performance {

    public void perform() {
        System.out.println("Watching a good old movie at the cinema");
        throw new RuntimeException("ERROR: Electricity problems!!");
    }
}
