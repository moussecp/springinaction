package web.quotes.data;

import java.time.LocalDateTime;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;


public class Quote {
    public static final int TRUNCATED_THRESHOLD = 75;
    private static Long idSequence = 0L;

    private final Long id;
    private final String message;
    private final String author;
    private final String reference;
    private final LocalDateTime time = LocalDateTime.now();

    public Quote(String message) {
        this(message, null, null);
    }

    public Quote(String message, String author, String reference) {
        checkArgument(!isNullOrEmpty(message), "quote message cannot be null");
        this.id = ++idSequence;
        this.message = message;
        this.author = setNotAvailableIfNeeded(author);
        this.reference = setNotAvailableIfNeeded(reference);
    }

    private String setNotAvailableIfNeeded(String string) {
        if(isNullOrEmpty(string)) {
            return "N/A";
        }
        return string;
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

    @Override
    public int hashCode() {
        return Objects.hash(id, message, author, reference, time);
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getTruncatedMessage() {
        if(message.length() > TRUNCATED_THRESHOLD) {
            return message.substring(0, TRUNCATED_THRESHOLD-3).concat(" ...");
        };
        return message;
    }

    public String getAuthor() {
        return author;
    }

    public String getReference() {
        return reference;
    }

    public LocalDateTime getTime() {
        return time;
    }
}