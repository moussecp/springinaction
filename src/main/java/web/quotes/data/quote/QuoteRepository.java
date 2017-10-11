package web.quotes.data.quote;

import java.util.List;

public interface QuoteRepository {
    List<Quote> findQuotes();

    List<Quote> findQuotes(int max);

    Quote find(long id);

    boolean deleteQuote(long quoteId);

    void add(Quote quote);
}