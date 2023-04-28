package com.bookstore.devbook.services;
import com.bookstore.devbook.model.Book;

import java.util.Optional;


public interface CartService {

    public void addToCart(Book book);

    public Optional<Book> deleteFromCart(Book book);

    public void clearCart();
}

