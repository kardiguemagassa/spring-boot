package com.mycompany.invoise.invoice.repository;

import com.mycompany.invoise.core.entity.invoice.Invoice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepositoryInterface extends CrudRepository <Invoice,String>{
    //@EntityGraph(value = "invoice.customer",type= EntityGraph.EntityGraphType.FETCH)
    //Iterable<Invoice> findAll();
    /*Invoice create(Invoice invoice);
    List<Invoice> list();
    Invoice getById(String number);
    avec pring-data-jdbc on supprime les methds de cette interface
    */

}
