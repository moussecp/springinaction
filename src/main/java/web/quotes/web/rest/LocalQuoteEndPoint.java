package web.quotes.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import web.quotes.data.quote.Quote;
import web.quotes.data.quote.QuoteRepository;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequestMapping(value = "/rest")
public class LocalQuoteEndPoint {

    public static final String JSON = MediaType.APPLICATION_JSON_VALUE;
    public static final String XML = MediaType.APPLICATION_XML_VALUE;
    private final QuoteRepository quoteRepository;

    @Autowired
    public LocalQuoteEndPoint(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    // returns XML
    @RequestMapping(value = "/quotes", method = GET, produces = XML)
    public List<Quote> getAllQuotesInXml() {
        return quoteRepository.findAll();
    }

    @RequestMapping(value = "/quotes/{id}", method = GET, produces = XML)
    public ResponseEntity<?> getQuoteInXml(@PathVariable long id) {
        Quote quote = quoteRepository.find(id);
        if (quote == null) {
            return new ResponseEntity<>(new RequestError(42, "quote not found for id: " + id), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    // returns JSON
    @RequestMapping(value = "/quotes", method = GET, produces = JSON)
    public List<Quote> getAllQuotesInJson() {
        return quoteRepository.findAll();
    }

    @RequestMapping(value = "/quotes/{id}", method = GET, produces = JSON)
    public ResponseEntity<?> getQuoteInJson(@PathVariable long id) {
        Quote quote = quoteRepository.find(id);
        if (quote == null) {
            return new ResponseEntity<>(new RequestError(42, "quote not found for id: " + id), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    @RequestMapping(value = "/quotes", method = POST, consumes = JSON, produces = JSON)
    public ResponseEntity<?> addQuote(
            @RequestBody Quote quote,
            UriComponentsBuilder ucb
    ) {
        quoteRepository.add(quote);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ucb.path("/quotes/")
                .path(String.valueOf(quote.getId()))
                .build()
                .toUri());
        return new ResponseEntity<>(quote, httpHeaders, HttpStatus.CREATED);
    }
}
