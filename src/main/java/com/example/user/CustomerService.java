package com.example.user;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    private static CustomerDto maptoCustomerDto(CustomerEntity customerEntity){
        CustomerDto customerDto = new CustomerDto();

        customerDto.setFirstName(customerEntity.getFirstName());
        customerDto.setLastName(customerEntity.getLastName());
        customerDto.setEmail(customerEntity.getEmail());
        customerDto.setLogin(customerEntity.getLogin());
        return customerDto;
    }
    @Transactional
    public List<CustomerDto> getCustomers(String customerName){
        List<CustomerDto> ret = new LinkedList<>();
        for (CustomerEntity c1 : customerRepository.findAll()){
            CustomerDto c2 = maptoCustomerDto(c1);
            ret.add(c2);
        }
        return ret;
    }

    @Transactional
    public CustomerDto getCustomer(Long customerId){
        Optional<CustomerEntity> byId = customerRepository.findById(customerId);
        if (byId.isPresent()){
            return maptoCustomerDto(byId.get());
        }
        return null;
    }

    @Transactional
    public Long createCustomer(CustomerDto customerDto){
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setFirstName(customerDto.getFirstName());
        customerEntity.setLastName(customerDto.getLastName());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setLogin(customerDto.getLogin());

        this.customerRepository.save(customerEntity);

        return customerEntity.getId();
    }
    @Transactional
    public void updateCustomer(int customerId, CustomerDto customerDto){
        Optional<CustomerEntity> byId = customerRepository.findById((long)customerId);
        if (byId.isPresent()){
            byId.get().setFirstName(customerDto.getFirstName());
            byId.get().setLastName(customerDto.getLastName());
            byId.get().setEmail(customerDto.getEmail());
            byId.get().setLogin(customerDto.getLogin());
        }
    }

    @Transactional
    public void deleteCustomer(int customerId){
        Optional<CustomerEntity> byId = customerRepository.findById((long)customerId);
        if (byId.isPresent()){
            customerRepository.delete(byId.get());
        }
    }

    /*
    public Integer createCustomer(@RequestBody User com.example.user){
        this.users.add(com.example.user);
        return this.users.size()-1;
    }
    public User listCustomers(@PathVariable int customerId){
        return this.users.get(customerId);
    }
    public List<User> getList(@RequestParam(required = false) String firstName){
        List<User> filteredUsers = new ArrayList<>();
        for (User com.example.user : users){
            if (com.example.user.getFirstName().equals(firstName)){
                filteredUsers.add(com.example.user);
            }
        }
        User com.example.user = new User();
        return this.users;
    }
    public List<User> getUserId(@RequestParam(required = false) Integer customerId){
        List<User> filteredUsers = new ArrayList<>();
        for (User com.example.user : users){
            if (com.example.user.getId() == customerId){
                filteredUsers.add(com.example.user);
            }
        }
        User com.example.user = new User();
        return this.users;
    }
    public void deleteCustomer(@PathVariable Integer userId){
        this.users.remove(this.users.get(userId));
    } */

}
