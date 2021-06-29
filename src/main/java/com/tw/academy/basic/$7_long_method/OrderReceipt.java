package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
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

        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getLineItemInfo());
        }

        // prints the state tax
        output.append("Sales Tax").append(TAB_CHARACTER).append(order.calculateTotSalesTax());

        // print total amount
        output.append("Total Amount").append(TAB_CHARACTER).append(order.calculateAllTotalAmount());
        return output.toString();
    }

}