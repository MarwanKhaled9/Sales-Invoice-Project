package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marwan Khaled
 */


public class LineNewRepresentation extends AbstractTableModel {

    
    private ArrayList<SalesInvoiceLine> invLinesArray;
    private String[] linesColumns = {"Unit Name", "Unit Price", "Unit Count", "Line Total"};

    
    public LineNewRepresentation(ArrayList<SalesInvoiceLine> invoiceLinesArray) {
        this.invLinesArray = invoiceLinesArray;
    }

    
    
    @Override
    public int getRowCount() {
        return invLinesArray == null ? 0 : invLinesArray.size();
    }

    
    @Override
    public int getColumnCount() {
        return linesColumns.length;
    }

    
    @Override
    public Object getValueAt(int rowsData, int columnsData) {
        if (invLinesArray == null) {
            return "";
        } else {
            SalesInvoiceLine line = invLinesArray.get(rowsData);
            switch (columnsData) {
                case 0: return line.getItemName();
                case 1: return line.getItemPrice();
                case 2: return line.getItemCount();
                case 3: return line.calculateLineTotal();
                default: return ""; 
            }
            
        }
        
    }
    

    @Override
    public String getColumnName(int column) {
        return linesColumns[column];
    }

    
    
}
