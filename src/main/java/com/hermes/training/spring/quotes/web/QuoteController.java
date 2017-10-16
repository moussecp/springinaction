package com.hermes.training.spring.quotes.web;

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
}