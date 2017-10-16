package com.hermes.training.spring.quotes.data.quote;

import java.util.List;

public interface QuoteRepository {
    List<Quote> findAll();

    List<Quote> findQuotes(int max);

    Quote find(long id);

    boolean deleteQuote(long quoteId);

    void add(Quote quote);
}