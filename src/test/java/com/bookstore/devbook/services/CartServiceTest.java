package com.bookstore.devbook.services;

import com.bookstore.devbook.utils.Cart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.bookstore.devbook.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CartServiceTest {

   @Autowired
   CartService cartService ;

    @Test
    public void addToCartTest(){
        Cart.clearCart();
        Book book1 = new Book("Clean Code" , "Robert Martin", 50.00);
        Book book2 = new Book("The Clean Coder" , "Robert Martin", 50.00);
        Book book3 = new Book("Clean Architecture" , "Robert Martin", 50.00);
        Book book4 = new Book("The Driven Development By Example" , "Kent Beck", 50.00);
        Book book5 = new Book("Working Effectively with Legacy Code " , "Michael C. Feathers", 50.00);
        cartService.addToCart(book1);
        Assertions.assertTrue(Cart.getCart().size()==1);
        cartService.addToCart(book2);
        cartService.addToCart(book3);
        Assertions.assertTrue(Cart.getCart().size()==3);
    }

    @Test
    public void deleteFromCartTest(){
        Cart.clearCart();
        Book book1 = new Book("Clean Code" , "Robert Martin", 50.00);
        Book book2 = new Book("The Clean Coder" , "Robert Martin", 50.00);
        Book book3 = new Book("Clean Architecture" , "Robert Martin", 50.00);
        cartService.addToCart(book1);
        cartService.addToCart(book2);
        cartService.addToCart(book3);

        Optional<Book> book11 = cartService.deleteFromCart(book1);
        Assertions.assertTrue(book11.isPresent());
        Assertions.assertTrue(book11.get().getName() == "Clean Code");
        Assertions.assertTrue(Cart.getCart().size()==2);

        Optional<Book> book22 = cartService.deleteFromCart(book2);
        Assertions.assertTrue(book22.isPresent());
        Assertions.assertTrue(book22.get().getName() == "The Clean Coder");
        Assertions.assertTrue(Cart.getCart().size()==1);

        Optional<Book> book33 = cartService.deleteFromCart(book3);
        Assertions.assertTrue(book33.isPresent());
        Assertions.assertTrue(book33.get().getName() == "Clean Architecture");
        Assertions.assertTrue(Cart.getCart().size()==0);
    }

    @Test
    public void clearCartTest(){
        Book book1 = new Book("Clean Code" , "Robert Martin", 50.00);
        Book book2 = new Book("The Clean Coder" , "Robert Martin", 50.00);
        Book book3 = new Book("Clean Architecture" , "Robert Martin", 50.00);
        Cart.clearCart();
        Assertions.assertTrue(Cart.getCart().size()==0);
        cartService.addToCart(book1);
        Assertions.assertTrue(Cart.getCart().size()==1);
        cartService.addToCart(book2);
        Assertions.assertTrue(Cart.getCart().size()==2);
        cartService.addToCart(book3);
        Assertions.assertTrue(Cart.getCart().size()==3);
        cartService.clearCart();
        Assertions.assertTrue(Cart.getCart().size()==0);

    }


}
