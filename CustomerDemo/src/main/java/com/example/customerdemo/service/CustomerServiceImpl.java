package com.example.customerdemo.service;

import com.example.customerdemo.dao.CustomerRepository;
import com.example.customerdemo.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getById(Long id) {
        log.info("IN CustomerServiceImpl method getById()",id);
        Customer customer = null;
        Optional<Customer> customerFromOptional = customerRepository.findById(id);
        if(customerFromOptional.isPresent()){
            customer = customerFromOptional.get();
        }
        return customer;

    }

    @Override
    public void save(Customer customer) {
        log.info("IN CustomerServiceImpl method save()",customer);
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        log.info("IN CustomerServiceImpl method delete()",id);
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        log.info("IN CustomerServiceImpl method getAll");
        return customerRepository.findAll();
    }
}
