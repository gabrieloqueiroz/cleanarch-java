package br.com.queiroz.cleanarch.core.usecase;

import br.com.queiroz.cleanarch.core.dto.CustomerDto;

public interface InsertCustomerUseCase {
    void insert(CustomerDto customer);
}
