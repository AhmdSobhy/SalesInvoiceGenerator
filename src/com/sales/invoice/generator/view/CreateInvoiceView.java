package com.sales.invoice.generator.view;

import com.sales.invoice.generator.model.InvoiceHeader;
import com.sales.invoice.generator.model.InvoiceLine;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateInvoiceView {

    public ArrayList<InvoiceHeader> createInvoiceLayout(InvoiceHeader invoiceHeader){
        ArrayList<InvoiceHeader> header = new ArrayList<>();
        ArrayList<InvoiceLine> lines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Invoice Num: ");
        int invoiceNum = scanner.nextInt();
        invoiceHeader.setInvoiceNum(invoiceNum);
        System.out.println("{");
        System.out.print("Invoice Date:");
        String invoiceDate = scanner.next();
        invoiceHeader.setInvoiceDate(invoiceDate);
        System.out.print("Customer : ");
        String customer = scanner.next();
        invoiceHeader.setCustomerName(customer);

        System.out.print("How many items you want to add : ");
        int itemCount = scanner.nextInt();
        System.out.println("=============================================");

        for (int i=0; i<itemCount; i++) {
            System.out.print("Item Name : ");
            String itemName = scanner.next();
            System.out.print("Item Price : ");
            int itemPrice = scanner.nextInt();
            System.out.print("Item Count : ");
            String count = scanner.next();
            lines.add(new InvoiceLine(invoiceNum,itemName,itemPrice,count));
            System.out.println("=============================================");
        }
        System.out.println("}\n");

        invoiceHeader.setInvoiceLines(lines);

        header.add(invoiceHeader);

        return header;
    }
}
