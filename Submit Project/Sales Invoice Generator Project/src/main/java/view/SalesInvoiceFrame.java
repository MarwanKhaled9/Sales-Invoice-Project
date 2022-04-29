package view;

import controller.InvoiceButtonsListener;
import controller.secondTableListener;
import model.HeaderNewRepresentation;
import model.SalesInvoiceHeader;
import model.SalesInvoiceLine;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Marwan Khaled
 */


public class SalesInvoiceFrame extends javax.swing.JFrame {

    public SalesInvoiceFrame() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invHeaderTable = new javax.swing.JTable();
        createNewInvoice = new javax.swing.JButton();
        deleteInvoiceButton = new javax.swing.JButton();
        invoiceNumber = new javax.swing.JLabel();
        invoiceDate = new javax.swing.JLabel();
        invoiceCustomerName = new javax.swing.JLabel();
        invoiceTotal = new javax.swing.JLabel();
        invCustomerLabel = new javax.swing.JLabel();
        invDateLable = new javax.swing.JLabel();
        invNumberLable = new javax.swing.JLabel();
        invTotalLable = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        invLineTable = new javax.swing.JTable();
        createNewLine = new javax.swing.JButton();
        deleteLineButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadButton = new javax.swing.JMenuItem();
        saveButton = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invHeaderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        invHeaderTable.getSelectionModel().addListSelectionListener(selectingListener);
        jScrollPane1.setViewportView(invHeaderTable);

        createNewInvoice.setText("Create New Invoice");
        createNewInvoice.setActionCommand("Create New Invoice List");
        createNewInvoice.addActionListener(invoiceButtonListner);
        createNewInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewInvoiceActionPerformed(evt);
            }
        });

        deleteInvoiceButton.setText("Delete Selected Invoice");
        deleteInvoiceButton.addActionListener(invoiceButtonListner);

        invoiceNumber.setText("Invoice Number");

        invoiceDate.setText("Invoice Date");

        invoiceCustomerName.setText("Customer Name");

        invoiceTotal.setText("Invoice Total");

        invLineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(invLineTable);

        createNewLine.setText("Add Line");
        createNewLine.setActionCommand("Insert New Line");
        createNewLine.addActionListener(invoiceButtonListner);
        createNewLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewLineActionPerformed(evt);
            }
        });

        deleteLineButton.setText("Delete Line");
        deleteLineButton.setActionCommand("Delete Current Line");
        deleteLineButton.addActionListener(invoiceButtonListner);

        jMenu1.setText("File");

        loadButton.setText("Load File");
        loadButton.setActionCommand("Loading Input");
        loadButton.addActionListener(invoiceButtonListner);
        jMenu1.add(loadButton);

        saveButton.setText("Save File");
        saveButton.setActionCommand("Saving Input");
        saveButton.addActionListener(invoiceButtonListner);
        jMenu1.add(saveButton);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(createNewInvoice)
                        .addGap(31, 31, 31)
                        .addComponent(deleteInvoiceButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invoiceCustomerName)
                                    .addComponent(invoiceTotal)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(invoiceDate)
                                            .addComponent(invoiceNumber))))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invTotalLable)
                                    .addComponent(invNumberLable)
                                    .addComponent(invDateLable)
                                    .addComponent(invCustomerLabel))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(createNewLine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteLineButton)
                        .addGap(94, 94, 94))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(invNumberLable))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(invoiceNumber)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoiceDate)
                            .addComponent(invDateLable))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoiceCustomerName)
                            .addComponent(invCustomerLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoiceTotal)
                            .addComponent(invTotalLable))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createNewLine)
                            .addComponent(deleteLineButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteInvoiceButton)
                            .addComponent(createNewInvoice))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createNewLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewLineActionPerformed
        
    }//GEN-LAST:event_createNewLineActionPerformed

    private void createNewInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewInvoiceActionPerformed
        
    }//GEN-LAST:event_createNewInvoiceActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesInvoiceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createNewInvoice;
    private javax.swing.JButton createNewLine;
    private javax.swing.JButton deleteInvoiceButton;
    private javax.swing.JButton deleteLineButton;
    private javax.swing.JLabel invCustomerLabel;
    private javax.swing.JLabel invDateLable;
    private javax.swing.JTable invHeaderTable;
    private javax.swing.JTable invLineTable;
    private javax.swing.JLabel invNumberLable;
    private javax.swing.JLabel invTotalLable;
    private javax.swing.JLabel invoiceCustomerName;
    private javax.swing.JLabel invoiceDate;
    private javax.swing.JLabel invoiceNumber;
    private javax.swing.JLabel invoiceTotal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadButton;
    private javax.swing.JMenuItem saveButton;
    // End of variables declaration//GEN-END:variables
   
    //objects
    
    private InvoiceButtonsListener invoiceButtonListner = new InvoiceButtonsListener(this);
    
    private ArrayList<SalesInvoiceHeader> invHeaderArray;
    private ArrayList<SalesInvoiceLine> invLinesArray;
        
    private HeaderNewRepresentation headerTabelModel;
    
    private secondTableListener selectingListener = new secondTableListener(this);
    public ArrayList<SalesInvoiceLine> getInvLinesArray() {
        return invLinesArray;
    }
    
    
    public static SimpleDateFormat newDate = new SimpleDateFormat("dd-MM-yyyy");
    public void setInvLinesArray(ArrayList<SalesInvoiceLine> invLinesArray) {
        this.invLinesArray = invLinesArray;
    }
    public ArrayList<SalesInvoiceHeader> getInvHeaderArray() {
        return invHeaderArray;
    }
    public void setInvHeaderArray(ArrayList<SalesInvoiceHeader> invHeaderArray) {
        this.invHeaderArray = invHeaderArray;
    }

    
    
    public SalesInvoiceHeader getInvObject(int input) {
        for (SalesInvoiceHeader y : invHeaderArray) {
            if (y.getId() == input) {
                return y;
            }
        }
        return null;
    }

    public HeaderNewRepresentation getHeaderTabelModel() {
        return headerTabelModel;
    }

    public void setHeaderNewRepresentation(HeaderNewRepresentation headerTabelModel) {
        this.headerTabelModel = headerTabelModel;
    }

    public JTable getHeaderNewRepresentation() {
        return invHeaderTable;
    }

    public JTable getInvLineTable() {
        return invLineTable;
    }

    public JLabel getInvCustomerLabel() {
        return invCustomerLabel;
    }

    public JLabel getInvDateLable() {
        return invDateLable;
    }

    public JLabel getInvNumberLable() {
        return invNumberLable;
    }

    public JLabel getInvTotalLable() {
        return invTotalLable;
    }

    public InvoiceButtonsListener getInvoiceButtonListner() {
        return invoiceButtonListner;
    }
    
    
}
