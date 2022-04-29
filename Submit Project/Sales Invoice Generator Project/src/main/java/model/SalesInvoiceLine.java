package model;

/**
 * @author Marwan Khaled
 */

public class SalesInvoiceLine {
    
    private SalesInvoiceHeader invoiceHeader;
    private String itemName;
    private double itemPrice;
    private int itemCount;
    

    public SalesInvoiceLine() {
    }

    public SalesInvoiceLine(int itemCount, double itemPrice, String itemName, SalesInvoiceHeader header) {
        
        
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
        this.itemName = itemName;
        this.invoiceHeader = header;
        
    }

    public SalesInvoiceHeader getInvoiceHeader() {
        return invoiceHeader;
    }

    public void setInvoiceHeader(SalesInvoiceHeader invoiceHeader) {
        this.invoiceHeader = invoiceHeader;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
    
    public double calculateLineTotal() {
        return itemPrice * itemCount;
    }

    @Override
    public String toString() {
        return invoiceHeader.getId() + "," + itemName + "," + itemPrice + "," + itemCount;
    }

    
    
}
