package com.sales.invoice.generator.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations {

    public ArrayList<InvoiceHeader> readFile(String fileName){
        ArrayList<InvoiceHeader> headers = new ArrayList<>();
        try {
            Scanner lineInput;
            Scanner input = new Scanner(new File(fileName));
            input.useDelimiter("\n");
            while (input.hasNext()){
                lineInput = new Scanner(input.next());
                lineInput.useDelimiter(",");

                while (lineInput.hasNext()){
                    headers.add(new InvoiceHeader(Integer.parseInt(lineInput.next()),lineInput.next(),lineInput.next(),null));
                }
                lineInput.close();
            }
            input.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return headers;
    }

    public ArrayList<InvoiceLine> readLinesFile(String fileName){
        ArrayList<InvoiceLine> lines = new ArrayList<>();
        try {
            Scanner lineInput;
            Scanner input = new Scanner(new File(fileName));
            input.useDelimiter("\n");

            while (input.hasNext()){
                lineInput = new Scanner(input.next());
                lineInput.useDelimiter(",");

                while (lineInput.hasNext()){
                    lines.add(new InvoiceLine(Integer.parseInt(lineInput.next()),lineInput.next(),Integer.parseInt(lineInput.next()),lineInput.next()));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return lines;
    }

    public void writeFile(ArrayList<InvoiceHeader> invoiceHeaders){

        File headerFile = new File("InvoiceHeader.csv");
        File lineFile = new File("InvoiceLine.csv");
        try {
            PrintWriter headerOut = new PrintWriter(headerFile);
            PrintWriter lineOut = new PrintWriter(lineFile);
            for (InvoiceHeader invoice : invoiceHeaders) {
                headerOut.printf("%s,%s,%s\n", invoice.getInvoiceNum(), invoice.getInvoiceDate(), invoice.getCustomerName(), invoice.getInvoiceNum());
                for (InvoiceLine line: invoice.getInvoiceLines()) {
                    lineOut.printf("%d,%s,%d,%s\n",line.getInvoiceNum(),line.getItemName(),line.getItemPrice(),line.getCount());
                }
            }
            lineOut.close();
            headerOut.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
