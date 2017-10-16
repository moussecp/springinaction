package com.hermes.training.spring.quotes.web;

import com.hermes.training.spring.quotes.data.quote.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/quotes")
public class QuoteController {
    private QuoteRepository quoteRepository;

    @Autowired
    public QuoteController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    // get quotes list
    @RequestMapping(method = RequestMethod.GET)
    public String quotes(Model model) {
        model.addAttribute("quotes", quoteRepository.findAll());
        return "quotes";
    }
}