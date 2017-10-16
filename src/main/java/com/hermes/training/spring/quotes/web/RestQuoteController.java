package com.hermes.training.spring.quotes.web;

import com.hermes.training.spring.quotes.data.quote.Quote;
import com.hermes.training.spring.quotes.data.quote.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/rest")
public class RestQuoteController {

    private final QuoteRepository quoteRepository;

    @Autowired
    public RestQuoteController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @RequestMapping(value = "/quotes", method = GET)
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }
}
