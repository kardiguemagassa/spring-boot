/*
package com.mycompany.invoise.invoiseweb.api;


import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    public InvoiceResource(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    private final InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }


    @PostMapping
    public Invoice create(@RequestBody Invoice invoice){
        return invoiceService.createInvoice(invoice);
    }

    @GetMapping
    public Iterable<Invoice> list(){

        System.out.print("La méthode display Home a été évoquée");
        return invoiceService.getInvoiceList();
    }

    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number){

        System.out.print("La méthode displayInvoice a été évoquée");
        return invoiceService.getInvoiceByNumber(number);
    }
/*
    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice){
        return "invoice-create-form";
    }

}*/
