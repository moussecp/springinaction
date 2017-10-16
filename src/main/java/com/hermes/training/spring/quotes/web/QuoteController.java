package com.hermes.training.spring.quotes.web;

import com.hermes.training.spring.quotes.data.quote.Quote;
import com.hermes.training.spring.quotes.data.quote.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/quotes")
public class QuoteController {
    public static final String DEFAULT_MAX_VALUE = "15";
    private QuoteRepository quoteRepository;

    @Autowired
    public QuoteController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    // get quotes list
    @RequestMapping(method = RequestMethod.GET)
    public String quotes(
            @RequestParam(value = "max", defaultValue = DEFAULT_MAX_VALUE) int max,
            Model model) {
        model.addAttribute("quotes", quoteRepository.findQuotes(max));
        return "quotes";
    }

    // get quote detail for given id
    @RequestMapping(value = "/{quoteId}", method = RequestMethod.GET)
    public String quote(
            @PathVariable("quoteId") long quoteId,
            Model model) {
        model.addAttribute(quoteRepository.find(quoteId));
        return "quote";
    }

    // delete quote and call back quotes list
    @RequestMapping(value = "/delete-quote/{quoteId}", method = RequestMethod.GET)
    public String deleteQuote(
            @PathVariable("quoteId") long quoteId,
            Model model) {
        quoteRepository.deleteQuote(quoteId);
        model.addAttribute("quotes", quoteRepository.findAll());
        return "quotes";
    }

    // add quote form getter
    @RequestMapping(value = "/add-quote/", method = RequestMethod.GET)
    public String addQuoteForm() {
        return "add-quote";
    }

    // addQuote without exception handler
    @RequestMapping(value = "/add-quote/", method = RequestMethod.POST)
    public String addQuote(String message, String author, String reference, Model model) {
        Quote quote = new Quote(message, author, reference);
        quoteRepository.add(quote);
        model.addAttribute("quotes", quoteRepository.findAll());
        return "quotes";
    }
}