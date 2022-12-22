package com.sales.invoice.generator.model;

import java.util.ArrayList;

public class InvoiceHeader {

    private int  invoiceNum;
    private String invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine> invoiceLines;

    public InvoiceHeader(){}
    public InvoiceHeader(int invoiceNum, String invoiceDate, String customerName, ArrayList<InvoiceLine> invoiceLines) {
        this.invoiceNum = invoiceNum;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
        this.invoiceLines = invoiceLines;
    }

    public void addInvoiceLines(ArrayList<InvoiceLine> invoiceLines){
        ArrayList<InvoiceLine> lines = new ArrayList<>();
        for (InvoiceLine line:invoiceLines) {
            if(line.getInvoiceNum() == this.getInvoiceNum())
                lines.add(line);
        }
        this.invoiceLines = lines;
    }
    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLines(ArrayList<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }
}
