package com.hermes.training.spring.quotes.web;

import com.hermes.training.spring.quotes.data.quote.Quote;
import com.hermes.training.spring.quotes.data.quote.QuoteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

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
        String result = quoteController.quotes(MAX_RESULTS, mockedModel);
        assertEquals("quotes", result);
        verify(mockedModel).addAttribute("quotes", allQuotes);
    }

    // use of Spring test libraries
    @Test
    public void testQuote() throws Exception {
        MockMvc mockMvc = standaloneSetup(quoteController).build();
        mockMvc.perform(get("/quotes/12345"))
                .andExpect(view().name("quote"))
                .andExpect(model().attributeExists("quote"))
                .andExpect(model().attribute("quote", expectedQuote));
    }
}