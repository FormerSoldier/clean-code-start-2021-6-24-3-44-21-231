package com.tw.academy.basic.$7_long_method;

public class LineItem {
	public static final char TAB_CHARACTER = '\t';
	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double p, int quantity) {
		super();
		this.description = description;
		this.price = p;
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    double totalAmount() {
        return price * quantity;
    }

    String getLineItemInfo() {
        return getDescription() + TAB_CHARACTER +
                        getPrice() + TAB_CHARACTER +
                        getQuantity() + TAB_CHARACTER +
                        totalAmount() + '\n';
    }
}