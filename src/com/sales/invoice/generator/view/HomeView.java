package com.sales.invoice.generator.view;

import com.sales.invoice.generator.controller.InvoiceController;

import java.util.Scanner;

public class HomeView {

    public void startHomePage(){
        InvoiceController controller = new InvoiceController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("<<<<<<<<<< Sales Invoice Generator >>>>>>>>>>");
        System.out.println("=============================================");
        System.out.println("Enter 1 or 2 to choose an option:");
        System.out.println("1- Create an Invoice");
        System.out.println("2- Show all Invoices");

        System.out.print(">> ");
        int option = 0;
        try {
            option = scanner.nextInt();
        }catch (Exception e){
            System.out.println("Please enter a valid Number 1 or 2\n");
            startHomePage();
        }
        System.out.println("=============================================");
        switch (option){
            case 1:
                controller.createInvoice();
                break;
            case 2:
                controller.printAllInvoices();
                break;
            default:
                System.out.println("No other option");
                System.out.println("Please enter a valid Number 1 or 2");
        }



    }
}
