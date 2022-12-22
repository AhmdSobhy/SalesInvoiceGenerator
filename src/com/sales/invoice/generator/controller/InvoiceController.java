package com.sales.invoice.generator.controller;
import com.sales.invoice.generator.model.*;
import com.sales.invoice.generator.view.*;

import java.util.ArrayList;

public class InvoiceController {
    private InvoiceHeader invoiceHeader = new InvoiceHeader() ;
    private InvoiceView invoiceView = new InvoiceView();
    private CreateInvoiceView createInvoiceView = new CreateInvoiceView();
    private FileOperations fileOperations = new FileOperations();
    private ArrayList<InvoiceHeader> headers;
    private ArrayList<InvoiceLine> lines;

    public InvoiceController() {

    }

    public void createInvoice(){
        ArrayList<InvoiceHeader> invoice = createInvoiceView.createInvoiceLayout(invoiceHeader);
        fileOperations.writeFile(invoice);
    }

    public void addInvoicesLines(){
        headers = fileOperations.readFile("InvoiceHeader.csv");
        lines = fileOperations.readLinesFile("InvoiceLine.csv");
        for (InvoiceHeader header:headers) {
            header.addInvoiceLines(lines);
        }
    }

    public void printAllInvoices(){
        addInvoicesLines();
        for (InvoiceHeader header:headers) {
            invoiceView.printInvoice(header);
        }
    }

}
/*
String europeanDatePattern = "dd.MM.yyyy";
DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern(europeanDatePattern);
System.out.println(europeanDateFormatter.format(LocalDate.of(2016, 7, 31)));

 */