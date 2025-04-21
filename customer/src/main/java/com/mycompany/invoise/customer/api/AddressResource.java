package com.mycompany.invoise.customer.api;


import com.mycompany.invoise.core.entity.customer.Address;
import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.customer.repository.AddressRepositoryInterface;
import com.mycompany.invoise.customer.repository.CustomerRepositoryInterface;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/customer")
public class AddressResource {

    private final AddressRepositoryInterface addressRepository;

    public AddressResource(AddressRepositoryInterface addressRepository) {

        this.addressRepository = addressRepository;
    }


    @GetMapping("/{id}")
    public Address get(@PathVariable("id") Long id){
        return addressRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
