package com.manhnd.cloudnative.books.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Book(
    @NotBlank(message = "ISBN is mandatory")
    @Pattern(regexp = "^(97(8|9))?\\d{9}(\\d|X)$", message = "ISBN is invalid")
    String isbn,

    @NotBlank(message = "Title is mandatory") String title,
    @NotBlank(message = "Author is mandatory") String author,
    @NotNull(message = "Price is mandatory") @Positive(message = "Price must be greater than zero")
        Double price) {}
