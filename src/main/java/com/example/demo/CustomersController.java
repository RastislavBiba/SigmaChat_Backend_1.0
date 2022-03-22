package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomersController{
    private CustomerService customerService;
    public CustomersController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/api/customers")
    public List<CustomerDto> getCustomers(@RequestParam(required = false) String firstName ){
        return customerService.getCustomers(firstName);
    }

    @GetMapping("/api/customers/{customerId}")
    public CustomerDto getCustomer(@PathVariable Long customerId){
        return customerService.getCustomer(customerId);
    }

    @PostMapping("/api/customers")
    public Long createCustomer(@RequestBody CustomerDto customerDto){
      return customerService.createCustomer(customerDto);
    }

   @DeleteMapping("/api/customers{customerId}")
    public void deleteBook(@PathVariable int customerId){
        customerService.deleteCustomer(customerId);
   }

   @PutMapping("/api/books/{customerId}")
    public void updateCustomer(@PathVariable int customerId, @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId, customerDto);
   }
}
