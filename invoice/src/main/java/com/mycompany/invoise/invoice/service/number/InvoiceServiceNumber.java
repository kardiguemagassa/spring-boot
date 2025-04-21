package com.mycompany.invoise.invoice.service.number;

import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.invoice.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {

    private final InvoiceRepositoryInterface invoiceRepository;

    //private final CustomerRepositoryInterface customerRepository;


    public InvoiceServiceNumber(InvoiceRepositoryInterface invoiceRepository /*CustomerRepositoryInterface customerRepository*/) {
        this.invoiceRepository = invoiceRepository;
        //this.customerRepository = customerRepository;
    }

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    // faire un rollback si jamais l'ensemble de champ ne sont pas satisfaits
    @Transactional
    public Invoice createInvoice(Invoice invoice){
        //ustomerRepository.save(invoice.getCustomer());
        return invoiceRepository.save(invoice);
    }

    @Override
    public Iterable <Invoice> getInvoiceList() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepository.findById(number).orElseThrow();
    }

}
