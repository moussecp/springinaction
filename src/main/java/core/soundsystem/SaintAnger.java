package core.soundsystem;

import org.springframework.stereotype.Component;

@Component("saintAnger")
public class SaintAnger extends BlankDisc {
    private String title = "St. Anger";
    private String artist = "Metallica";

    public SaintAnger() {
        super(null, null);
    }

    public SaintAnger(String title, String artist) {
        super(null, null);
        this.title = title;
        this.artist = artist;
    }

    public SaintAnger(String title, String artist, String title1, String artist1) {
        super(title, artist);
        this.title = title1;
        this.artist = artist1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}