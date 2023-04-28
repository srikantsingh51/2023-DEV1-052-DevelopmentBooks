package com.bookstore.devbook.services;

import com.bookstore.devbook.model.Book;
import com.bookstore.devbook.model.DiscountDetails;
import com.bookstore.devbook.utils.Cart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class DiscountServiceTest {

    @Autowired
    private DiscountServiceImpl discountServiceImpl;

    @Test
    public void addToCartTest(){
        Book book1 = new Book("Clean Code" , "Robert Martin", 50.00);
        Book book2 = new Book("The Clean Coder" , "Robert Martin", 50.00);
        Book book3 = new Book("Clean Architecture" , "Robert Martin", 50.00);
        Book book4 = new Book("The Driven Development By Example" , "Kent Beck", 50.00);
        Book book5 = new Book("Working Effectively with Legacy Code " , "Michael C. Feathers", 50.00);
        Cart.clearCart();
        List<Book> books = new ArrayList();
        books.add(book1);
        books.add(book5);
        books.add(book4);
        books.add(book3);
        books.add(book2);

        Optional<DiscountDetails> discountDetails =  discountServiceImpl.calculate(books);
        DiscountDetails discountDetail = null  ;
        if(discountDetails.isPresent()) {
            discountDetail = discountDetails.get();

            Assertions.assertTrue(discountDetail.getBooks().size() == 5);
            Assertions.assertTrue(discountDetail.getActualPrice()== 250);
            Assertions.assertTrue(discountDetail.getDiscountedPrice() == 187.5);
            Assertions.assertTrue(discountDetail.getTotalDiscount() == 62.5);
        }

    }

    }
