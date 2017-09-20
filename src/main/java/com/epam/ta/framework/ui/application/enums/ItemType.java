package com.epam.ta.framework.ui.application.enums;

public enum ItemType {
    BT("Business Trips", "Business Trip", "businesstrip"),
    PR("Payment Requests", "Payment Request", "paymentrequest");

    private final String itemName;
    private final String itemNameInSingular;
    private String itemNameInUrl;

    ItemType(String itemName, String itemNameInSingular, String itemNameInUrl) {
        this.itemName = itemName;
        this.itemNameInSingular = itemNameInSingular;
        this.itemNameInUrl = itemNameInUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemNameInSingular() {
        return itemNameInSingular;
    }

    public String getItemNameInUrl() {
        return itemNameInUrl;
    }
}
