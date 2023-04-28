package com.bookstore.devbook.utils;

import com.bookstore.devbook.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class  Cart {


    private static List<Book> CART = new ArrayList(GlobalConstant.CART_MAX_CAPACITY);

    public static void addBookToCart(Book book){
        if(Objects.nonNull(book) && CART.size() <= GlobalConstant.CART_MAX_CAPACITY)
            CART.add(book);

    }

    public static boolean removeBookFromCart(Book book){
       return CART.remove(book);
    }

    public static void clearCart(){
        CART.clear();
    }

    public static List<Book> getCart(){
        return CART;
    }
}
