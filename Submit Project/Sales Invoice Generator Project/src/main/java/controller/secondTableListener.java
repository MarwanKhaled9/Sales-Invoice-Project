package controller;

import model.SalesInvoiceHeader;
import view.SalesInvoiceFrame;
import model.LineNewRepresentation;
import model.SalesInvoiceLine;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Marwan Khaled
 */





public class secondTableListener implements ListSelectionListener {

    

    public secondTableListener(SalesInvoiceFrame frame) {
        this.frame = frame;
    }
    
    private SalesInvoiceFrame frame;
    
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int secondInvoice = frame.getHeaderNewRepresentation().getSelectedRow();
        
        
        // validating
        System.out.println("Invoice selected: "+ secondInvoice );
        System.out.println(frame.getInvHeaderArray());
        System.out.println(frame.getInvLinesArray());
        
        
        if (secondInvoice != -1) {
            SalesInvoiceHeader oldHeader = frame.getInvHeaderArray().get(secondInvoice);
            ArrayList<SalesInvoiceLine> itemsLines = oldHeader.getLines();
            LineNewRepresentation lineTableModel = new LineNewRepresentation(itemsLines);
            
            frame.setInvLinesArray(itemsLines);
            frame.getInvLineTable().setModel(lineTableModel);
            
            frame.getInvDateLable().setText(SalesInvoiceFrame.newDate.format(oldHeader.getInvDate()));
            frame.getInvTotalLable().setText("" + oldHeader.getInvoiceTotal());
            
            
            frame.getInvNumberLable().setText("" + oldHeader.getId());
            frame.getInvCustomerLabel().setText(oldHeader.getCustomerName());
            
        }
    }

}
