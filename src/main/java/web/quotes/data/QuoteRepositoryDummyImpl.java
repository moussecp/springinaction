package web.quotes.data;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class QuoteRepositoryDummyImpl implements QuoteRepository {

    private static List<Quote> quotes = new ArrayList<>();

    static {
        quotes = DummyData.getBootstrapQuotes();
    }

    @Override
    public List<Quote> findQuotes() {
        return quotes;
    }

    @Override
    public List<Quote> findQuotes(int max) {
        return quotes.subList(0, max);
    }

    @Override
    public Quote find(long quoteId) {
        return quotes.stream()
                .filter(quote -> quote.getId() == quoteId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean deleteQuote(long quoteId) {
        Quote quote = find(quoteId);
        if (quote != null) {
            return quotes.remove(quote);
        }
        return false;
    }

    @Override
    public void add(Quote quote) {
        quotes.add(quote);
    }
}