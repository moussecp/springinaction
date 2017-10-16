package web.quotes.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import web.quotes.data.quote.Quote;
import web.quotes.data.quote.QuoteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/remote")
public class RemoteQuoteEndPoint {

    public static final String QUOTESONDESIGN_1_OBJETC_URL = "http://quotesondesign.com/wp-json/posts?filter[orderby]=rand&filter[posts_per_page]=1";
    public static final String QUOTESONDESIGN_43_OBJECTS_URL = "http://quotesondesign.com/wp-json/posts?filter[orderby]=rand&filter[posts_per_page]=43";
    public static final String JSON = MediaType.APPLICATION_JSON_VALUE;

    @Autowired
    private QuoteRepository quoteRepository;

    @RequestMapping(method = GET, produces = JSON)
    public Quote getSingleQuote() {
        RestTemplate rest = new RestTemplate();
        Map mappedObject = (Map) (((List) rest.getForObject(
                QUOTESONDESIGN_1_OBJETC_URL,
                Object.class)).get(0));
        Quote quote = addNewQuote(mappedObject);
        return quote;
    }

    @RequestMapping(value = "/all", method = GET, produces = JSON)
    public List<Quote> getAllQuotes() {
        RestTemplate rest = new RestTemplate();
        List mappedObjectsList = (List) rest.getForObject(
                QUOTESONDESIGN_43_OBJECTS_URL,
                Object.class);
        List<Quote> quotes = new ArrayList<>();
        for (Object mappedObject : mappedObjectsList) {
            quotes.add(addNewQuote((Map) mappedObject));
        }
        return quotes;
    }

    private Quote addNewQuote(Map mappedObject) {
        Quote quote = new Quote();
        quote.setAuthor((String) mappedObject.get("title"));
        quote.setMessage((String) mappedObject.get("content"));
        quote.setReference((String) mappedObject.get("link"));
        quoteRepository.add(quote);
        return quote;
    }
}
