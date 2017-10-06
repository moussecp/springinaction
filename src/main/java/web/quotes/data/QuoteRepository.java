package web.quotes.data;

import java.util.List;

public interface QuoteRepository {
    List<Quote> findQuotes();
    List<Quote> findQuotes(int max);

    Quote find(long id);
}