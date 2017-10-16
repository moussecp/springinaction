package com.hermes.training.spring.quotes.web;

import com.hermes.training.spring.quotes.data.quote.Quote;
import com.hermes.training.spring.quotes.data.quote.QuoteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuoteControllerTest {

    private static final int MAX_RESULTS = 20;
    private static final int QUOTE_ID = 12345;

    private List<Quote> allQuotes;
    private Quote expectedQuote = new Quote("Hello");
    private QuoteController quoteController;

    @Mock
    private QuoteRepository mockedQuoteRepository;
    @Mock
    private Model mockedModel;

    @Before
    public void setup() {
        quoteController = new QuoteController(mockedQuoteRepository);
        allQuotes = createQuoteList(MAX_RESULTS);
        when(mockedQuoteRepository.findAll()).thenReturn(allQuotes);
        when(mockedQuoteRepository.findQuotes(MAX_RESULTS)).thenReturn(allQuotes);
        when(mockedQuoteRepository.find(QUOTE_ID)).thenReturn(expectedQuote);
    }

    private List<Quote> createQuoteList(int count) {
        List<Quote> quotes = new ArrayList<Quote>();
        for (int i = 0; i < count; i++) {
            quotes.add(new Quote("Quote " + i));
        }
        return quotes;
    }

    // use of classic Mockito libraries
    @Test
    public void quotesTestWithMaxResults() throws Exception {
        String result = quoteController.quotes(mockedModel);
        assertEquals("quotes", result);
        verify(mockedModel).addAttribute("quotes", allQuotes);
    }
}