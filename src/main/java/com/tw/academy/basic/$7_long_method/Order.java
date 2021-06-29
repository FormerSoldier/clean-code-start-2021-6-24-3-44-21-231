package com.tw.academy.basic.$7_long_method;

import java.util.List;

public class Order {
    String customerName;
    String address;
    List<LineItem> lineItems;

    public Order(String customerName, String address, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    double calculateAllTotalAmount() {
        double allTotalAmount = 0d;
        for (LineItem lineItem : getLineItems()) {
            allTotalAmount += lineItem.totalAmount() + lineItem.totalAmount() * .10;
        }
        return allTotalAmount;
    }

    double calculateTotSalesTax() {
        double totSalesTax = 0d;
        for (LineItem lineItem : getLineItems()) {
            totSalesTax += lineItem.totalAmount() * .10;
        }
        return totSalesTax;
    }
}
