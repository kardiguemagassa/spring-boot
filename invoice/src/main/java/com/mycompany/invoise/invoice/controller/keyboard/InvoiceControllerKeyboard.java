package com.mycompany.invoise.invoice.controller.keyboard;

import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;

import com.mycompany.invoise.invoice.controller.InvoiceControllerInterface;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;

import java.util.Scanner;

//@Controller
public class InvoiceControllerKeyboard implements InvoiceControllerInterface {

    public InvoiceControllerKeyboard(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    private InvoiceServiceInterface invoiceService;
    public final InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public String createInvoice(Invoice invoice){
        System.out.println("What is the customer name ?" );
        Scanner sc = new Scanner(System.in);
        String customerName = sc.nextLine();
        invoice = new Invoice();
        //invoice.setCustomerName(customerName);
        invoice = new Invoice();
        Customer customer = new Customer(customerName);
        invoice.setCustomer(customer);


        invoiceService.createInvoice(invoice);
        return null;
    }

}
