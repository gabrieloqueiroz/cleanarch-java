package br.com.queiroz.cleanarch.dataprovider;

import br.com.queiroz.cleanarch.core.dataprovider.FindCustomer;
import br.com.queiroz.cleanarch.core.domain.Customer;
import br.com.queiroz.cleanarch.dataprovider.repository.CustomerRepository;
import br.com.queiroz.cleanarch.dataprovider.repository.entity.CustomerEntity;
import br.com.queiroz.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindCustomerImpl implements FindCustomer {

  private CustomerRepository customerRepository;
  private CustomerEntityMapper customerMapper;

  @Autowired
  public FindCustomerImpl(CustomerRepository customerRepository, CustomerEntityMapper customerMapper) {
    this.customerRepository = customerRepository;
    this.customerMapper = customerMapper;
  }

  @Override
  public Optional<Customer> find(String id) {

    Optional<CustomerEntity> customerEntity = customerRepository.findById(id);

    return customerEntity.map(entity -> customerMapper.toCustomer(entity));
  }
}