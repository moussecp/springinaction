package core.soundsystem;

import org.springframework.beans.factory.annotation.Value;

public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;

    public BlankDisc() {}

    public BlankDisc(
            @Value("#{systemProperties['disc.title']}") String title,
            @Value("#{systemProperties['disc.artist']}") String artist) {
        this.title = title;
        this.artist = artist;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}