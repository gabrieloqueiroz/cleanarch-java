package br.com.queiroz.cleanarch.core.dataprovider;

import br.com.queiroz.cleanarch.core.domain.Customer;

public interface InsertCustomer {
    Customer insert(Customer customer);
}