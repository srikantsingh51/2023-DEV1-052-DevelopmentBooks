package com.bookstore.devbook.utils;
import com.bookstore.devbook.model.Book;

import java.util.List;

public class DiscountUtils {

    public static double calculateDiscount(double amount , double percentage){
        return (amount * percentage/100);
    }

    public static double calculatePercentage(int size){
        if(size == 5){
            return 25;
        }else if(size == 4){
            return 20;
        }else if(size == 3){
            return 10;
        }else if(size == 2){
            return 5;
        }else if(size == 1){
            return 0;
        }
        return 0;
    }
}
