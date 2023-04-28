package com.bookstore.devbook.processor;

import com.bookstore.devbook.model.Book;
import com.bookstore.devbook.utils.Cart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CartProcessorTest {

    @Autowired
    CartProcessor cartProcessor;


    Book book1;
    Book book2;
    Book book3;
    Book book4;
    Book book5;
    @BeforeEach
    public void  setUp(){
        book1 = new Book("Clean Code" , "Robert Martin", 50.00);
        book2 = new Book("The Clean Coder" , "Robert Martin", 50.00);
        book3 = new Book("Clean Architecture" , "Robert Martin", 50.00);
        book4 = new Book("The Driven Development By Example" , "Kent Beck", 50.00);
        book5 = new Book("Working Effectively with Legacy Code " , "Michael C. Feathers", 50.00);
    }
    
    @Test
    public void processCartWhenGropIsNotEmptyTest(){

        Cart.addBookToCart(book1);
        Cart.addBookToCart(book1);
        Cart.addBookToCart(book1);
        Cart.addBookToCart(book2);
        Cart.addBookToCart(book2);
        Cart.addBookToCart(book2);
        Cart.addBookToCart(book3);
        Cart.addBookToCart(book3);
        Cart.addBookToCart(book4);
        Cart.addBookToCart(book5);
        Cart.addBookToCart(book1);
        Cart.addBookToCart(book2);
        Cart.addBookToCart(book4);
        Cart.addBookToCart(book2);
        Cart.addBookToCart(book4);
        Cart.addBookToCart(book3);
        Cart.addBookToCart(book3);
        List<List> cartData = cartProcessor.processCart();
        Assertions.assertTrue(cartData.get(0).size()==4);
        Assertions.assertTrue(cartData.get(1).size()==4);
        Assertions.assertTrue(cartData.get(2).size()==4);
        Assertions.assertTrue(cartData.get(3).size()==4);
        Assertions.assertTrue(cartData.get(4).size()==1);

    }

    @Test
    public void processCartWhenCartIsEmptyTest() {
        Cart.clearCart();
        List<List> cartData = cartProcessor.processCart();
        Assertions.assertTrue(cartData.isEmpty());
    }

    @Test
    public void processCartWhenGroupsIsEmptyTest() {
        Cart.clearCart();
        List<List> cartData = cartProcessor.processCart();
        Assertions.assertTrue(cartData.isEmpty());
    }

    @Test
    public void processCartSecondTest() {

    }

    @Test
    public void processCartThirdTest() {

        Cart.addBookToCart(book1);
        Cart.addBookToCart(book1);
        Cart.addBookToCart(book2);
        Cart.addBookToCart(book2);
        Cart.addBookToCart(book3);
        Cart.addBookToCart(book3);
        Cart.addBookToCart(book4);

        List<List> cartData = cartProcessor.processCart();
        Assertions.assertTrue(cartData.get(0).size() == 4);
        Assertions.assertTrue(cartData.get(1).size() == 3);
    }


}
