package web.quotes.data.quote;

import java.time.LocalDateTime;


public class NewQuote {

    private final LocalDateTime time = LocalDateTime.now();
    private Long id;
    private String title;
    private String content;
    private String link;
    private Object customMeta;

    public NewQuote() {
    }

    public NewQuote(Long id, String title, String content, String link, Object customMeta) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.link = link;
        this.customMeta = customMeta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Object getCustomMeta() {
        return customMeta;
    }

    public void setCustomMeta(Object customMeta) {
        this.customMeta = customMeta;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
