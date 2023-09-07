package br.com.queiroz.cleanarch.core.dataprovider;

import br.com.queiroz.cleanarch.core.domain.Customer;
import java.util.Optional;

public interface FindCustomer {
  Optional<Customer> find(Integer id);
}
