package br.com.queiroz.cleanarch.dataprovider;

import br.com.queiroz.cleanarch.core.dataprovider.UpdateCustomer;
import br.com.queiroz.cleanarch.core.domain.Customer;
import br.com.queiroz.cleanarch.dataprovider.repository.CustomerRepository;
import br.com.queiroz.cleanarch.dataprovider.repository.entity.CustomerEntity;
import br.com.queiroz.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerImpl implements UpdateCustomer {

  private final CustomerRepository customerRepository;
  private final CustomerEntityMapper customerEntityMapper;

  @Autowired
  public UpdateCustomerImpl(
      CustomerRepository customerRepository,
      CustomerEntityMapper customerEntityMapper
  ) {
    this.customerRepository = customerRepository;
    this.customerEntityMapper = customerEntityMapper;
  }

  @Override
  public void update(Customer customer) {
    CustomerEntity customerEntity = customerEntityMapper.toCustomerEntity(customer);
    customerRepository.save(customerEntity);
  }
}