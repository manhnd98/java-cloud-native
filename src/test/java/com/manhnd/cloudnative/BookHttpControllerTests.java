package com.manhnd.cloudnative;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.manhnd.cloudnative.books.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookHttpControllerTests {

  @Autowired private WebTestClient webTestClient;

  @Test
  void whenPostRequestThenBookIsCreated() {
    Book expectedBook = new Book("1234567890", "Title", "Author", 9.90);

    webTestClient
        .post()
        .uri("/books")
        .bodyValue(expectedBook)
        .exchange()
        .expectStatus()
        .isCreated()
        .expectBody(Book.class)
        .value(
            actualBook -> {
              assertThat(actualBook).isNotNull();
              assertThat(actualBook.isbn()).isEqualTo(expectedBook.isbn());
            });
  }
}
