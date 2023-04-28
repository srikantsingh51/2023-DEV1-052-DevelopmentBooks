package com.bookstore.devbook.services;

import com.bookstore.devbook.model.Bill;
import com.bookstore.devbook.model.DiscountDetails;
import com.bookstore.devbook.processor.CartProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingServiceImpl implements BillingService{
    @Autowired
    DiscountService discountService;

    @Autowired
    CartProcessor cartProcessor;


    @Override
    public Bill processBill() {

        List<List> groups = cartProcessor.processCart();
        Bill finalBill = new Bill();
        for(List list: groups){
            Optional<DiscountDetails> discountDetails =  discountService.calculate(list);
            if(discountDetails.isPresent()){
                DiscountDetails  discountDetail =  discountDetails.get();
                finalBill.getGroups().add(discountDetail);
                finalBill.setActualCost(finalBill.getActualCost()+discountDetail.getActualPrice());
                finalBill.setFinalCost(finalBill.getFinalCost()+discountDetail.getDiscountedPrice());
                finalBill.setTotalDiscount(finalBill.getTotalDiscount()+discountDetail.getTotalDiscount());
            }
        }
        return finalBill;
    }
}
