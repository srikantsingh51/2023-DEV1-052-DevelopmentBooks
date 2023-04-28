package com.bookstore.devbook.services;

import com.bookstore.devbook.model.Book;
import com.bookstore.devbook.utils.Cart;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{

    @Override
    public void addToCart(Book book){
        if(Objects.nonNull(book)){
            Cart.addBookToCart(book);
        }
    }

    @Override
    public Optional<Book> deleteFromCart(Book book) {
        if(Objects.nonNull(book)){
            if(Cart.removeBookFromCart(book))
                return Optional.of(book);
        }
        return Optional.of(null);
    }

    @Override
    public void clearCart() {
        Cart.clearCart();
    }

}
