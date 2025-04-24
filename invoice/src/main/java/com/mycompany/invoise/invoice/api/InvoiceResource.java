package com.mycompany.invoise.invoice.api;

import com.mycompany.invoise.core.entity.customer.Address;
import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.invoice.form.InvoiceForm;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

/**
 * Service de gestion des factures.
 *
 * @author Kara
 * @since 2025-04-22
 */
@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    @Autowired
    private InvoiceServiceInterface invoiceService;
    @Autowired
    private WebClient.Builder webClientBuilder;

    /**
     * webClient asynchronous:: ouvrir une connection avec webService,
     * et envoyer la requête en HTTP de manière asynchronous, c'est à dire effectuer une requête de seveur à serveur
     * et attendre que le fournisseur de la donnée retourne cette information. On utilise WebClient.Builder, ou
     * RestTemplate mais qui est presque deprecier. donc le norme aujourd'hui est WebClient.Builder.
     * @return
     */
    @GetMapping
    public ParallelFlux<Invoice> list(){

        System.out.println("La méthode list a été invoquée");
        Iterable<Invoice> invoices= invoiceService.getInvoiceList();
        final WebClient webClient=webClientBuilder.baseUrl("http://customer-service").build();

        List<Mono<Invoice>> InvoiceMonos=new ArrayList<>();

        invoices.forEach(invoice ->
                InvoiceMonos.add(webClient.get().uri("/customer/" + invoice.getIdCustomer())
                        .retrieve()
                        .bodyToMono(Customer.class)
                        .map(customer -> {
                            invoice.setCustomer(customer);
                            return invoice;
                        }))
        );

        Flux<Invoice> invoiceFlux=Flux.concat(InvoiceMonos);

       return invoiceFlux.parallel().runOn(Schedulers.boundedElastic());
    }

    // webClient synchronous
    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number){

        System.out.println("La méthode displayInvoice a été invoquée");

        Invoice invoice=invoiceService.getInvoiceByNumber(number);

        final WebClient webClient=webClientBuilder.build();

        final Mono<Customer> mono=webClient.get().uri("http://customer-service/customer/"+invoice.getIdCustomer())
                .retrieve()
                .bodyToMono(Customer.class);
        final Customer customer=mono.block();

        final Mono<Address> mono2=webClient.get().uri("http://customer-service/address/"+customer.getAddress().getId())
                .retrieve()
                .bodyToMono(Address.class);

        mono.subscribe(result -> invoice.setCustomer(result));

        final Address address=mono2.block();

        customer.setAddress(address);
        invoice.setCustomer(customer);
        return invoice;
    }

    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice){
        return "invoice-create-form";
    }

    @PostMapping
    public Invoice create(@RequestBody Invoice invoice){
        return invoiceService.createInvoice(invoice);
    }

}
