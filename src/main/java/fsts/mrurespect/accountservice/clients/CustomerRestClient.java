package fsts.mrurespect.accountservice.clients;

import fsts.mrurespect.accountservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{customerId}")
    @CircuitBreaker(name = "customer-service", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long customerId);

    @CircuitBreaker(name = "customer-service", fallbackMethod = "getDefaultCustomers")
    @GetMapping("/customers")
    PagedModel<Customer> allCustomers();

    default Customer getDefaultCustomer(Long customerId,Exception exception){   // on le transmet l exception qui a declenche le fallback
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setName("Not Available");
        customer.setEmail("Not Available");
        return customer;
    }
    default PagedModel<Customer> getDefaultCustomers(Exception exception){
        return PagedModel.empty();
    }
}
