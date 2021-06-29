package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    public static final double TEN_PERCENT = .10;
    public static final char TAB_CHARACTER = '\t';
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    //todo: rename -- Tom
    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        // print headers
        output.append("======Printing Orders======\n");

        // print date, bill no, customer name
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        // prints lineItems
        for (LineItem lineItem : order.getLineItems()) {
            String str = getLineItemInfo(lineItem);
            output.append(str);
        }

        // prints the state tax
        output.append("Sales Tax").append(TAB_CHARACTER).append(calculateTotSalesTax());

        // print total amount
        output.append("Total Amount").append(TAB_CHARACTER).append(calculateAllTotalAmount());
        return output.toString();
    }

    private String getLineItemInfo(LineItem lineItem) {
        return lineItem.getDescription() + TAB_CHARACTER +
                        lineItem.getPrice() + TAB_CHARACTER +
                        lineItem.getQuantity() + TAB_CHARACTER +
                        lineItem.totalAmount() + '\n';
    }

    private double calculateAllTotalAmount() {
        double allTotalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            allTotalAmount += lineItem.totalAmount() + lineItem.totalAmount() * TEN_PERCENT;
        }
        return allTotalAmount;
    }

    private double calculateTotSalesTax() {
        double totSalesTax = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            totSalesTax += lineItem.totalAmount() * TEN_PERCENT;
        }
        return totSalesTax;
    }
}