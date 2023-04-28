package com.bookstore.devbook.model;

import java.util.ArrayList;
import java.util.List;

public class Bill {

    private List<DiscountDetails> groups = new ArrayList<>();

    private double actualCost;

    private double finalCost;

    private double totalDiscount;

    public List<DiscountDetails> getGroups() {
        return groups;
    }

    public void setGroups(List<DiscountDetails> groups) {
        this.groups = groups;
    }

    public double getActualCost() {
        return actualCost;
    }

    public void setActualCost(double actualCost) {
        this.actualCost = actualCost;
    }

    public double getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(double finalCost) {
        this.finalCost = finalCost;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }
}
