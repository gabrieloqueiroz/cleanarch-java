package br.com.queiroz.cleanarch.core.usecase;

import br.com.queiroz.cleanarch.core.domain.Customer;
import br.com.queiroz.cleanarch.core.dto.CustomerDto;

public interface InsertCustomerUseCase {
    Customer insert(CustomerDto customer);
}
