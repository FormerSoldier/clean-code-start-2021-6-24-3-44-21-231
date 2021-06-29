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
        double totSalesTax = 0d;
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

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * TEN_PERCENT;
            totSalesTax += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            allTotalAmount += lineItem.totalAmount() + salesTax;
        }

        // prints the state tax
        output.append("Sales Tax").append(TAB_CHARACTER).append(totSalesTax);

        // print total amount
        output.append("Total Amount").append(TAB_CHARACTER).append(allTotalAmount);
        return output.toString();
    }
}