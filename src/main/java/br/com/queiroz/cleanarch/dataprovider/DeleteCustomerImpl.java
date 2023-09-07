package br.com.queiroz.cleanarch.dataprovider;

import br.com.queiroz.cleanarch.core.dataprovider.DeleteCustomer;
import br.com.queiroz.cleanarch.dataprovider.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerImpl implements DeleteCustomer {

  private final CustomerRepository customerRepository;

  @Autowired
  public DeleteCustomerImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public void delete(String id) {
    customerRepository.deleteById(id);
  }
}
