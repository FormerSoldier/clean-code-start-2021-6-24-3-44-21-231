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
        double allTotalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append(TAB_CHARACTER);
            output.append(lineItem.getPrice());
            output.append(TAB_CHARACTER);
            output.append(lineItem.getQuantity());
            output.append(TAB_CHARACTER);
            output.append(lineItem.totalAmount());
            output.append('\n');

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            allTotalAmount += lineItem.totalAmount() + lineItem.totalAmount() * TEN_PERCENT;
        }

        double totSalesTax = calculateTotSalesTax();


        // prints the state tax
        output.append("Sales Tax").append(TAB_CHARACTER).append(totSalesTax);

        // print total amount
        output.append("Total Amount").append(TAB_CHARACTER).append(allTotalAmount);
        return output.toString();
    }

    private double calculateTotSalesTax() {
        double totSalesTax = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            totSalesTax += lineItem.totalAmount() * TEN_PERCENT;
        }
        return totSalesTax;
    }
}