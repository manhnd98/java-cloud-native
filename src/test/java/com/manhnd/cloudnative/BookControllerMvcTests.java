package com.manhnd.cloudnative;


import com.manhnd.cloudnative.books.command.BookHttpController;
import com.manhnd.cloudnative.books.command.BookService;
import com.manhnd.cloudnative.books.domain.exception.BookNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BookHttpController.class)
public class BookControllerMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void whenGetBookNotExistsThenReturn404() throws Exception {
       String isbn = "1234567890";

       given(bookService.viewBookDetails(isbn))
               .willThrow(new BookNotFoundException(isbn));

       mockMvc.perform(get("/books/{isbn}", isbn))
               .andExpect(status().isNotFound());
    }

}
