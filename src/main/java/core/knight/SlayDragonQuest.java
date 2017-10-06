package core.knight;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest {
    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
        stream.println("Embarking on a quest to slay a dragon!");
    }
}
