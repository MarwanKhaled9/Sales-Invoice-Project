package model;

import view.SalesInvoiceFrame;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marwan Khaled
 */


public class HeaderNewRepresentation extends AbstractTableModel {

    
    private ArrayList<SalesInvoiceHeader> invHeaderArray;
    private String[] headerColumns = {"Invoice Number", "Invoice Date", "Customer Name", "Total"};
    
    
    public HeaderNewRepresentation(ArrayList<SalesInvoiceHeader> invoiceHeaderArray) {
        this.invHeaderArray = invoiceHeaderArray;
        
    }

    
    @Override
    public int getRowCount() {
        return invHeaderArray.size();
        
    }

    
    
    @Override
    public int getColumnCount() {
        return headerColumns.length;
        
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        SalesInvoiceHeader inv = invHeaderArray.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return inv.getId();
            case 1: return SalesInvoiceFrame.newDate.format(inv.getInvDate());
            case 2: return inv.getCustomerName();
            case 3: return inv.getInvoiceTotal();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return headerColumns[column];
        
    }
    
    
    
}
