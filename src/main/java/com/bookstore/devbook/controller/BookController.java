package com.bookstore.devbook.controller;

import com.bookstore.devbook.model.Bill;
import com.bookstore.devbook.services.BillingService;
import com.bookstore.devbook.services.CartService;
import com.bookstore.devbook.model.Book;
import com.bookstore.devbook.utils.Cart;
import com.bookstore.devbook.utils.GlobalConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    CartService  cartService;

    @Autowired
    BillingService billingService;

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book){
        if(Cart.getCart().size() == GlobalConstant.CART_MAX_CAPACITY)
            return "Cart is full. Please clear the Cart";
        cartService.addToCart(book);
        return book.getName()+" Sucessfully Added.";
    }

    @GetMapping("/getBill")
    public Bill getBill(){
       return  billingService.processBill();
    }

    @DeleteMapping("/clearCart")
    public String deleteCart(){
        Cart.clearCart();
        return "Cart clear Sucessfully";
    }

}
