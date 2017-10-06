package web.quotes.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import web.quotes.data.Quote;
import web.quotes.data.QuoteRepository;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class QuoteControllerTest {
    private static final int MAX = 20;

    @Test
    public void shouldShowRecentQuotes() throws Exception {
        List<Quote> expectedQuotes = createQuoteList(MAX);
        QuoteRepository mockRepository =
                mock(QuoteRepository.class);
        when(mockRepository.findQuotes(MAX))
                .thenReturn(expectedQuotes);
        QuoteController controller =
                new QuoteController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(
                        new InternalResourceView("/WEB-INF/views/quotes.jsp"))
                .build();
        mockMvc.perform(get("/quote"))
                .andExpect(view().name("quote"))
                .andExpect(model().attributeExists("quoteList"))
                .andExpect(model().attribute("quoteList",
                        hasItems(expectedQuotes.toArray())));
    }

    private List<Quote> createQuoteList(int count) {
        List<Quote> quotes = new ArrayList<Quote>();
        for (int i = 0; i < count; i++) {
            quotes.add(new Quote("Quote " + i));
        }
        return quotes;
    }

    @Test
    public void testQuote() throws Exception {
        Quote expectedQuote = new Quote("Hello");
        QuoteRepository mockRepository = mock(QuoteRepository.class);
        when(mockRepository.find(12345)).thenReturn(expectedQuote);
        QuoteController controller = new QuoteController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/quote/12345"))
                .andExpect(view().name("quote"))
                .andExpect(model().attributeExists("quote"))
                .andExpect(model().attribute("quote", expectedQuote));
    }
}