package com.mycompany.invoise.customer.repository;

import com.mycompany.invoise.core.entity.customer.Address;
import com.mycompany.invoise.core.entity.customer.Customer;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepositoryInterface extends CrudRepository <Address,Long>{

    /*Invoice create(Invoice invoice);
    List<Invoice> list();
    Invoice getById(String number);
    avec pring-data-jdbc on supprime les methds de cette interface
    */

}
