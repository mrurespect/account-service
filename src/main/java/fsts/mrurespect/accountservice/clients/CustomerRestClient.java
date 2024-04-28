package fsts.mrurespect.accountservice.clients;

import fsts.mrurespect.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{customerId}")
    Customer findCustomerById(@PathVariable Long customerId);
    @GetMapping("/customers")
    List<Customer> allCustomers();
}
