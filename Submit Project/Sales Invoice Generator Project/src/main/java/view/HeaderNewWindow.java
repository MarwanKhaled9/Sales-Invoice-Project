package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Marwan Khaled
 */

public class HeaderNewWindow extends JDialog {
    
    private JTextField newDateArea;
    private JTextField customerNameArea;
    
    private JLabel newDateTag;
    private JLabel newCustomerNameTag;
    
    private JButton doneKey;
    private JButton dropKey;

    public HeaderNewWindow(SalesInvoiceFrame frame) {
        
        newDateTag = new JLabel(" Insert New Date:(dd-MM-yyyy)");
        newDateArea = new JTextField(25);
        
        newCustomerNameTag = new JLabel(" Insert New Customer Name:");
        customerNameArea = new JTextField(25);
                       
        doneKey = new JButton("Done");
        dropKey = new JButton("Back");
        
        doneKey.setActionCommand("newSalesInvoiceDone");
        dropKey.setActionCommand("newSalesInvoiceDrop");
        
        doneKey.addActionListener(frame.getInvoiceButtonListner());
        dropKey.addActionListener(frame.getInvoiceButtonListner());
        setLayout(new GridLayout(3, 2));
        
        
        add(newCustomerNameTag);
        add(customerNameArea);
        
        add(newDateTag);
        add(newDateArea);
        
        add(doneKey);
        add(dropKey);
        
        pack();
        
    }

    
    public JTextField getNewDateArea() {
        return newDateArea;
    }
    
    
    public JTextField getCustomerNameArea() {
        return customerNameArea;
    }

    
    
}
