package com.bookstore.devbook.services;

import com.bookstore.devbook.model.Book;
import com.bookstore.devbook.model.DiscountDetails;
import com.bookstore.devbook.utils.DiscountUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DiscountServiceImpl implements DiscountService {
    @Override
    public Optional<DiscountDetails> calculate(List<Book> books) {
        if(books.size() == 0)
            return Optional.of(null);


        double actualCost = 0;
        double discountedCost = 0;
        double percentage = DiscountUtils.calculatePercentage(books.size());
        for(Book book: books)
            actualCost += book.getPrice();

        double discount = DiscountUtils.calculateDiscount(actualCost,percentage);
        discountedCost = actualCost - discount;

        DiscountDetails discountDetails = new DiscountDetails();
        discountDetails.setBooks(books);
        discountDetails.setActualPrice(actualCost);
        discountDetails.setDiscountedPrice(discountedCost);
        discountDetails.setTotalDiscount(discount);
        return Optional.of(discountDetails);

    }
}
