package web.quotes.web.rest;

import java.util.Objects;

public class RequestError {

    private final int code;
    private final String message;

    public RequestError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestError that = (RequestError) o;
        return code == that.code &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }

    @Override
    public String toString() {
        return "RequestError{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
