package com.sales.invoice.generator;

import com.sales.invoice.generator.controller.InvoiceController;
import com.sales.invoice.generator.model.FileOperations;
import com.sales.invoice.generator.view.InvoiceView;

public class Main {

    public static void main(String[] args) {

        InvoiceView view = new InvoiceView();
        FileOperations fileOperations = new FileOperations();

        InvoiceController controller = new InvoiceController(fileOperations,view);

        controller.printAllInvoices();

    }
}
