package model;

/**
 * @author Marwan Khaled
 */


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SalesInvoiceHeader {
    private int id;
    private String customerName;
    private Date invDate;
    private ArrayList<SalesInvoiceLine> lines;
    
    private DateFormat newdate = new SimpleDateFormat("dd-MM-yyyy");

    public SalesInvoiceHeader() {
    }

    public SalesInvoiceHeader(String customer, Date invDate, int number ) {
        this.id = number;
        this.customerName = customer;
        this.invDate = invDate;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<SalesInvoiceLine> getLines() {
        if (lines == null) {
            lines = new ArrayList<>();
        }
        return lines;
    }

    public void setLines(ArrayList<SalesInvoiceLine> lines) {
        this.lines = lines;
    }
    
    public double getInvoiceTotal() {
        double total = 0.0;
        
        for (int i = 0; i < getLines().size(); i++) {
            total += getLines().get(i).calculateLineTotal();
        }
        
        return total;
    }

    @Override
    public String toString() {
        return id + "," + newdate.format(invDate) + "," + customerName;
    }

    
    
}
