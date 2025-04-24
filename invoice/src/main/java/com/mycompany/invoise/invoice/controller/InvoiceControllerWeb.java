package com.mycompany.invoise.invoice.controller;

import com.mycompany.invoise.invoice.form.InvoiceForm;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

@Controller
public class InvoiceControllerWeb {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    @GetMapping("/home")
    public String displayHome(Model model) {
        System.out.println("La méthode display Home a été invoquée");
        return "invoice-home";
    }

    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice) {
        //vous pourriez même supprimer l'annotation @ModelAttribute si vous ne comptez
        //pas donner un identifiant personnalisé au backing bean
        return "invoice-create-form";
    }

//    @PostMapping("/create")
//    public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult results) {
//        //vous pourriez même supprimer l'annotation @ModelAttribute si vous ne comptez
//        //pas donner un identifiant personnalisé au backing bean
//        if (results.hasErrors()) {
//            return "invoice-create-form";
//        }
//        Invoice invoice = new Invoice();
//        Customer customer = new Customer(invoiceForm.getCustomerName());
//        invoice.setCustomer(customer);
//        invoice.setOrderNumber(invoiceForm.getOrderNumber());
//        invoiceService.createInvoice(invoice);
//        return "invoice-created";
//    }

    @GetMapping("/{id}")
    public String displayInvoice(@PathVariable("id") String number, Model model){
        System.out.println("La méthode displayInvoice a été invoquée");

        model.addAttribute("invoice",invoiceService.getInvoiceByNumber(number));
        //List<Invoice> invoices=invoiceService.getInvoiceList();
        return "invoice-details";
    }


}