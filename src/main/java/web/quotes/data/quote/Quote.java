package web.quotes.data.quote;

import java.time.LocalDateTime;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;


public class Quote {
    public static final int TRUNCATED_THRESHOLD = 75;
    private static Long idSequence = 0L;

    private final Long id = ++idSequence;
    private String message;
    private String author;
    private String reference;
    private final LocalDateTime time = LocalDateTime.now();

    public Quote() {
    }

    public Quote(String message) {
        this(message, null, null);
    }

    public Quote(String message, String author, String reference) {
        checkArgument(!isNullOrEmpty(message), "quote message cannot be null");
        this.message = message;
        this.author = setNotAvailableIfNeeded(author);
        this.reference = setNotAvailableIfNeeded(reference);
    }

    private String setNotAvailableIfNeeded(String string) {
        if (isNullOrEmpty(string)) {
            return "N/A";
        }
        return string;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTruncatedMessage() {
        if (message != null && message.length() > TRUNCATED_THRESHOLD) {
            return message.substring(0, TRUNCATED_THRESHOLD - 3).concat(" ...");
        }
        ;
        return message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, author, reference, time);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", author='" + author + '\'' +
                ", reference='" + reference + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return Objects.equals(id, quote.id) &&
                Objects.equals(message, quote.message) &&
                Objects.equals(author, quote.author) &&
                Objects.equals(reference, quote.reference) &&
                Objects.equals(time, quote.time);
    }
}
