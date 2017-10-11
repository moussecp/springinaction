package web.quotes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.quotes.data.quote.Quote;
import web.quotes.data.quote.QuoteRepository;

@Controller
@RequestMapping("/quotes")
public class QuoteController {
    public static final String DEFAULT_MAX_VALUE = "15";
    private QuoteRepository quoteRepository;

    @Autowired
    public QuoteController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String quotes(
            @RequestParam(value = "max", defaultValue = DEFAULT_MAX_VALUE) int max,
            Model model) {
        model.addAttribute("quotes", quoteRepository.findQuotes(max));
        return "quotes";
    }

    @RequestMapping(value = "/{quoteId}", method = RequestMethod.GET)
    public String quote(
            @PathVariable("quoteId") long quoteId,
            Model model) {
        model.addAttribute(quoteRepository.find(quoteId));
        return "quote";
    }

    @RequestMapping(value = "/delete-quote/{quoteId}", method = RequestMethod.GET)
    public String deleteQuote(
            @PathVariable("quoteId") long quoteId,
            Model model) {
        quoteRepository.deleteQuote(quoteId);
        model.addAttribute("quotes", quoteRepository.findQuotes());
        return "quotes";
    }

    @RequestMapping(value = "/add-quote/", method = RequestMethod.GET)
    public String addQuoteForm() {
        return "add-quote";
    }

    @RequestMapping(value = "/add-quote/", method = RequestMethod.POST)
    public String addQuote(String message, String author, String reference, Model model) {
        Quote quote = new Quote(message, author, reference);
        quoteRepository.add(quote);
        model.addAttribute("quotes", quoteRepository.findQuotes());
        return "quotes";
    }
}