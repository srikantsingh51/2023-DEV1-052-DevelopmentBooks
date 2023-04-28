package com.bookstore.devbook.services;

import com.bookstore.devbook.model.Book;
import com.bookstore.devbook.model.DiscountDetails;

import java.util.List;
import java.util.Optional;

public interface DiscountService {

    public Optional<DiscountDetails> calculate(List<Book> books);
}
