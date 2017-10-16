package com.hermes.training.spring.quotes.data.quote;

import com.hermes.training.spring.quotes.data.DummyData;
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
    public List<Quote> findAll() {
        return quotes;
    }

    @Override
    public List<Quote> findQuotes(int max) {
        return quotes.subList(0, Math.min(quotes.size(), max));
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
        //TODO
        return false;
    }

    @Override
    public Quote add(Quote quote) {
        //TODO
        return null;
    }

}