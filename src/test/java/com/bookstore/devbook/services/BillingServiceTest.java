package com.bookstore.devbook.services;

import com.bookstore.devbook.model.Bill;
import com.bookstore.devbook.model.Book;
import com.bookstore.devbook.utils.Cart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BillingServiceTest {

    @Autowired
    BillingService billingService ;

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
    public void processBillTest(){

        Cart.clearCart();
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

        Bill finalBill = billingService.processBill();
        Assertions.assertTrue(finalBill != null);
        Assertions.assertTrue(finalBill.getActualCost() == 850.00);
        Assertions.assertTrue(finalBill.getFinalCost() == 690);
        Assertions.assertTrue(finalBill.getTotalDiscount() == 160);
    }

    @Test
    public void processBillSecondScenarioTest() {

        Cart.clearCart();
        Cart.addBookToCart(book1);
        Cart.addBookToCart(book1);
        Cart.addBookToCart(book1);
        Cart.addBookToCart(book2);
        Cart.addBookToCart(book2);
        Cart.addBookToCart(book2);
        Cart.addBookToCart(book3);
        Cart.addBookToCart(book3);
        Bill finalBill = billingService.processBill();
        Assertions.assertTrue(finalBill != null);
        Assertions.assertTrue(finalBill.getActualCost() == 400.00);
        Assertions.assertTrue(finalBill.getFinalCost() == 365);
        Assertions.assertTrue(finalBill.getTotalDiscount() == 35);
    }

    @Test
    public void processBillThirdScenarioTest() {

        Cart.clearCart();
        Cart.addBookToCart(book1);
        Cart.addBookToCart(book1);
        Cart.addBookToCart(book1);
        Cart.addBookToCart(book2);
        Cart.addBookToCart(book2);
        Cart.addBookToCart(book2);
        Cart.addBookToCart(book4);
        Cart.addBookToCart(book5);
        Bill finalBill = billingService.processBill();
        Assertions.assertTrue(finalBill != null);
        Assertions.assertTrue(finalBill.getActualCost() == 400.00);
        Assertions.assertTrue(finalBill.getFinalCost() == 350);
        Assertions.assertTrue(finalBill.getTotalDiscount() == 50);
    }
}
