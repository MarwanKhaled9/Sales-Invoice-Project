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

public class LineNewWindow extends JDialog{
    
    private JButton doneKey;
    private JButton dropKey;
    
    
    private JLabel newItemPriceTag;
    private JLabel newItemNameTag;
    private JLabel newItemCountTag;
    
    private JTextField newItemNameArea;
    private JTextField newItemPriceArea;
    private JTextField newItemCountArea;
    
    
    
    public LineNewWindow(SalesInvoiceFrame frame) {
        
        
        newItemPriceTag = new JLabel(" New Item Price");
        newItemPriceArea = new JTextField(20);
        
        
        newItemCountArea = new JTextField(20);
        newItemCountTag = new JLabel(" How Many Items?");
        
        
        newItemNameTag = new JLabel(" New Item Name");
        newItemNameArea = new JTextField(20);
        
        
        doneKey = new JButton("Done");
        dropKey = new JButton("Back");
        
        doneKey.setActionCommand("newItemsLineDone");
        dropKey.setActionCommand("newItemsLineDrop");
        
        doneKey.addActionListener(frame.getInvoiceButtonListner());
        dropKey.addActionListener(frame.getInvoiceButtonListner());
        setLayout(new GridLayout(4, 2));
        
        add(newItemNameTag);
        add(newItemNameArea);
        
        add(newItemCountTag);
        add(newItemCountArea);
        
        add(newItemPriceTag);
        add(newItemPriceArea);
        
        add(doneKey);
        add(dropKey);
        
        pack();
    }

    public JTextField getNewItemNameArea() {
        return newItemNameArea;
    }

    

    public JTextField getNewItemPriceArea() {
        return newItemPriceArea;
    }
    
    public JTextField getNewItemCountArea() {
        return newItemCountArea;
    }
}
