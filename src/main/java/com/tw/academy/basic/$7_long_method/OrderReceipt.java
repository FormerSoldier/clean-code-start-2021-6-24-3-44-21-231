package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    public static final String SALES_TAX = "Sales Tax";
    public static final String TOTAL_AMOUNT = "Total Amount";
    public static final char TAB_CHARACTER = '\t';
    public static final String HEADER = "======Printing Orders======\n";
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    //todo: rename -- Tom
    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(HEADER);

        // print date, bill no, customer name
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getLineItemInfo());
        }

        output.append(SALES_TAX).append(TAB_CHARACTER).append(order.calculateTotSalesTax());
        output.append(TOTAL_AMOUNT).append(TAB_CHARACTER).append(order.calculateAllTotalAmount());
        return output.toString();
    }

}