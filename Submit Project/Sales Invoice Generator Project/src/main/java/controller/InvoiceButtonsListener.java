//main folder for action listners
package controller;

//imports
import view.SalesInvoiceFrame;
import model.SalesInvoiceHeader;
import model.SalesInvoiceLine;
import model.HeaderNewRepresentation;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.LineNewRepresentation;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import view.HeaderNewWindow;
import view.LineNewWindow;
import java.text.ParseException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 *
 * @author Marwan Khaled
 */
public class InvoiceButtonsListener implements ActionListener {

    private SalesInvoiceFrame frame;
    
    
/* 
    constructor to access the frame
*/
    public InvoiceButtonsListener(SalesInvoiceFrame frame) {
        this.frame = frame;
    }
    
    private HeaderNewWindow newHeaderWindow;
    private LineNewWindow newLineWindow;

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Loading Input":
                LoadingInputData();
                break;
            
            case "Saving Input":
                SavingInputData();
                break;
                
            case "newSalesInvoiceDone":
                newInvoiceWindowDone();
                break;

            case "newSalesInvoiceDrop":
                newInvoiceWindowDrop();
                break;
                
            case "Create New Invoice List":
                createNewInvButton();
                break;

            case "Delete Selected Invoice":
                deleteSelectedInvLine();
                break;

            case "Insert New Line":
                insertNewItemsLine();
                break;

            case "Delete Current Line":
                deleteCurrentItemsLine();
                break;
                
             case "newItemsLineDrop":
                newLineWindowDrop();
                break;

            case "newItemsLineDone":
                newLineWindowDone();
                break;  

            
        }
    }

    
    private void createNewInvButton() {
        newHeaderWindow = new HeaderNewWindow(frame);
        newHeaderWindow.setVisible(true);
    }
    
    private void SavingInputData() {
        
        ArrayList<SalesInvoiceHeader> savingInvoices = frame.getInvHeaderArray();
        
        JFileChooser savefile = new JFileChooser();
        try {
        int result = savefile.showSaveDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION){
            File savingHeaderData = savefile.getSelectedFile();
            FileWriter headerWriter = new FileWriter(savingHeaderData);
            String headers = "";
            String lines = "";
            
            for (SalesInvoiceHeader invoice : savingInvoices ){
                headers += invoice.toString();
                headers += "\n";
                for (SalesInvoiceLine line : invoice.getLines()){
                    lines += line.toString();
                    lines += "\n";
                }
            }
            
            headers = headers.substring(0, headers.length()-1);
            lines = lines.substring(0, lines.length()-1);
                    
                    
            result = savefile.showSaveDialog(frame);
            File lineFile = savefile.getSelectedFile();
            FileWriter lineWriter = new FileWriter(lineFile);
            
            headerWriter.write(headers);
            lineWriter.write(lines);
            
            headerWriter.close();
            lineWriter.close();
            
        }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void LoadingInputData() {
        JFileChooser fileChooser = new JFileChooser();
        try {
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerData = fileChooser.getSelectedFile();
                Path headerPath = Paths.get(headerData.getAbsolutePath());
                List<String> invHeaderLines = Files.readAllLines(headerPath);
                ArrayList<SalesInvoiceHeader> headersArray = new ArrayList<>();
                for (String headerLine : invHeaderLines) {
                    String[] arr = headerLine.split(",");
                    String part1 = arr[0];
                    String part2 = arr[1];
                    String part3 = arr[2];
                    int x = Integer.parseInt(part1);
                    Date invoiceDate = SalesInvoiceFrame.newDate.parse(part2);
                    SalesInvoiceHeader invoiceHeader = new SalesInvoiceHeader(part3, invoiceDate, x );
                    headersArray.add(invoiceHeader);
                }
                frame.setInvHeaderArray(headersArray);

                result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineData = fileChooser.getSelectedFile();
                    Path linePath = Paths.get(lineData.getAbsolutePath());
                    List<String> invLineLines = Files.readAllLines(linePath);
                    ArrayList<SalesInvoiceLine> linesArray = new ArrayList<>();
                    for (String lineLine : invLineLines) {
                        String[] arr = lineLine.split(",");
                        String part1 = arr[0];    // invoice num (int)
                        String part2 = arr[1];    // item newItemName   (String)
                        String part3 = arr[2];    // itemPrice       (double)
                        String part4 = arr[3];    // itemCount       (int)
                        int invoiceSystem = Integer.parseInt(part1);
                        double itemPrice = Double.parseDouble(part3);
                        int itemCount = Integer.parseInt(part4);
                        SalesInvoiceHeader inv = frame.getInvObject(invoiceSystem);
                        SalesInvoiceLine line = new SalesInvoiceLine(itemCount, itemPrice, part2, inv);
                        inv.getLines().add(line);
                    }
                }
                HeaderNewRepresentation newHeader = new HeaderNewRepresentation(headersArray);
                frame.setHeaderNewRepresentation(newHeader);
                frame.getHeaderNewRepresentation().setModel(newHeader);
                
                // validating
                System.out.println("Working");
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void newLineWindowDrop() {
        newLineWindow.setVisible(false);
        newLineWindow.dispose();
        newLineWindow = null;
    }

    private void newLineWindowDone() {
        newLineWindow.setVisible(false);
        
        String newItemName = newLineWindow.getNewItemNameArea().getText();
        String part1 = newLineWindow.getNewItemCountArea().getText();
        String part2 = newLineWindow.getNewItemPriceArea().getText();
        
        int newItemCount = 1;
        double newItemPrice = 1;
        
        try {
            newItemCount = Integer.parseInt(part1);
        } catch(NumberFormatException ex) {
            
            JOptionPane.showMessageDialog(frame, "Incorrect Count Number Try Again", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        try {
            newItemPrice = Double.parseDouble(part2);
        } catch(NumberFormatException ex) {
            
            JOptionPane.showMessageDialog(frame, "Incorrect Price Try Again", "Error", JOptionPane.ERROR_MESSAGE);
        }
        int selectedInvHeader = frame.getHeaderNewRepresentation().getSelectedRow();
        if (selectedInvHeader != -1) {
            SalesInvoiceHeader newHeader = frame.getInvHeaderArray().get(selectedInvHeader);
            SalesInvoiceLine line = new SalesInvoiceLine(newItemCount, newItemPrice, newItemName, newHeader);
            
            frame.getInvLinesArray().add(line);
            LineNewRepresentation lineNew = (LineNewRepresentation) frame.getInvLineTable().getModel();
            lineNew.fireTableDataChanged();
            frame.getHeaderTabelModel().fireTableDataChanged();
        }
        
        frame.getHeaderNewRepresentation().setRowSelectionInterval(selectedInvHeader, selectedInvHeader);
        newLineWindow.dispose();
        newLineWindow = null;
    }
    

    private void insertNewItemsLine() {
        newLineWindow = new LineNewWindow(frame);
        newLineWindow.setVisible(true);
    }
    
    private void deleteSelectedInvLine() {
        int selectedInvoiceIndex = frame.getHeaderNewRepresentation().getSelectedRow();
        if (selectedInvoiceIndex != -1) {
            
            frame.getInvHeaderArray().remove(selectedInvoiceIndex);
            frame.getHeaderTabelModel().fireTableDataChanged();

            frame.getInvLineTable().setModel(new LineNewRepresentation(null));
            frame.setInvLinesArray(null);
            
            
            frame.getInvTotalLable().setText("");
            frame.getInvDateLable().setText("");
            frame.getInvCustomerLabel().setText("");
            frame.getInvNumberLable().setText("");
            
            
        }
    }
    
    private void newInvoiceWindowDrop() {
        newHeaderWindow.setVisible(false);
        newHeaderWindow.dispose();
        newHeaderWindow = null;
    }
    
    
    private void newInvoiceWindowDone() {
        newHeaderWindow.setVisible(false);

        String newCustomerName = newHeaderWindow.getCustomerNameArea().getText();
        String x = newHeaderWindow.getNewDateArea().getText();
        Date newDate = new Date();
        try {
            newDate = SalesInvoiceFrame.newDate.parse(x);
            
        } catch (ParseException ex) {
            
            JOptionPane.showMessageDialog(frame, "Date will be set automatically", "Incorrect Date Format", JOptionPane.ERROR_MESSAGE);
        }

        int invNum = 0;
        
        for (SalesInvoiceHeader inv : frame.getInvHeaderArray()) {
            if (inv.getId() > invNum) {
                invNum = inv.getId();
            }
        }
        invNum++;
        
        SalesInvoiceHeader newInv = new SalesInvoiceHeader(newCustomerName, newDate, invNum);
        
        frame.getInvHeaderArray().add(newInv);
        frame.getHeaderTabelModel().fireTableDataChanged();
        
        newHeaderWindow.dispose();
        newHeaderWindow = null;
    }
    
    private void deleteCurrentItemsLine() {
        
        int selectedLineIndex = frame.getInvLineTable().getSelectedRow();
        int selectedInvoiceIndex = frame.getHeaderNewRepresentation().getSelectedRow();
        
        if (selectedLineIndex != -1) {
            
            frame.getInvLinesArray().remove(selectedLineIndex);
            
            LineNewRepresentation lineTableModel = (LineNewRepresentation) frame.getInvLineTable().getModel();
            lineTableModel.fireTableDataChanged();
            
            frame.getInvTotalLable().setText(""+frame.getInvHeaderArray().get(selectedInvoiceIndex).getInvoiceTotal());
            frame.getHeaderTabelModel().fireTableDataChanged();
            frame.getHeaderNewRepresentation().setRowSelectionInterval(selectedInvoiceIndex, selectedInvoiceIndex);
        }
    }

    

    
    
    
}
