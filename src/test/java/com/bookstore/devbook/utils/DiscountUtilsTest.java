package com.bookstore.devbook.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DiscountUtilsTest {

    @Test
    public void calculateDiscountTest(){
       double discount =  DiscountUtils.calculateDiscount(100,5);
       Assertions.assertTrue(discount==5);
        discount =  DiscountUtils.calculateDiscount(250,25);
        Assertions.assertTrue(discount==62.5);
    }

    @Test
    public void calculatePercentageTest(){

        double percentage =  DiscountUtils.calculatePercentage(5);
        Assertions.assertTrue(percentage==25);
        percentage =  DiscountUtils.calculatePercentage(4);
        Assertions.assertTrue(percentage==20);
        percentage =  DiscountUtils.calculatePercentage(3);
        Assertions.assertTrue(percentage==10);
        percentage =  DiscountUtils.calculatePercentage(2);
        Assertions.assertTrue(percentage==5);
        percentage =  DiscountUtils.calculatePercentage(1);
        Assertions.assertTrue(percentage==0);
        percentage =  DiscountUtils.calculatePercentage(-5);
        Assertions.assertTrue(percentage==0);
    }
}
