package com.sales.invoice.generator.view;
import com.sales.invoice.generator.model.*;

public class InvoiceView {

    public void printInvoice(InvoiceHeader invoiceHeader){
        System.out.println(invoiceHeader.getInvoiceNum());
        System.out.println("{");
        System.out.print("Invoice Date: "+ invoiceHeader.getInvoiceDate()+ " - ");
        System.out.println("Customer : "+ invoiceHeader.getCustomerName());
        for (InvoiceLine item : invoiceHeader.getInvoiceLines()) {
            System.out.println(item.getItemName()+ ", " +item.getItemPrice()+ ", " + item.getCount());
        }
        System.out.println("}\n");
    }

}
