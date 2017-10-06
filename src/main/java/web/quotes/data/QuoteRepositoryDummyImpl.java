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
    public Quote find(long sentId) {
        return quotes.stream().filter(quote -> quote.getId() == sentId).findFirst().orElse(quotes.get(0));
    }
}