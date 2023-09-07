package br.com.queiroz.cleanarch.dataprovider;

import br.com.queiroz.cleanarch.core.dataprovider.InsertCustomer;
import br.com.queiroz.cleanarch.core.domain.Customer;
import br.com.queiroz.cleanarch.dataprovider.repository.CustomerRepository;
import br.com.queiroz.cleanarch.dataprovider.repository.entity.CustomerEntity;
import br.com.queiroz.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerImpl implements InsertCustomer {

  private CustomerRepository customerRepository;
  private CustomerEntityMapper customerMapper;

  @Autowired
  public InsertCustomerImpl(CustomerRepository customerRepository, CustomerEntityMapper customerMapper) {
    this.customerRepository = customerRepository;
    this.customerMapper = customerMapper;
  }

  @Override
  public Customer insert(Customer customer) {
    CustomerEntity savedCustomer = customerRepository.save(
        customerMapper.toCustomerEntity(customer));

    return customerMapper.toCustomer(savedCustomer);
  }
}
