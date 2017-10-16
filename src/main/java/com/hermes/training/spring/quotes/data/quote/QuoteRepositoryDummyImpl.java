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

//    @Override
//    public Quote find(long quoteId) {
//        return quotes.stream()
//                .filter(quote -> quote.getId() == quoteId)
//                .findFirst()
//                .orElse(null);
//    }

    // throws exception if not found
    @Override
    public Quote find(long quoteId) {
        Quote foundQuote = quotes.stream()
                .filter(quote -> quote.getId() == quoteId)
                .findFirst()
                .orElse(null);
        if (foundQuote == null) {
            throw new QuoteNotFoundException();
        }
        return foundQuote;
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
    public Quote add(Quote quote) {
        quotes.add(quote);
        return quote;
    }
}