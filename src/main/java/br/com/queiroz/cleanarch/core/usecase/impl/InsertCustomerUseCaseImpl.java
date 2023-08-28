package br.com.queiroz.cleanarch.core.usecase.impl;

import br.com.queiroz.cleanarch.core.dataprovider.FindAddressByZipCode;
import br.com.queiroz.cleanarch.core.dataprovider.InsertCustomer;
import br.com.queiroz.cleanarch.core.domain.Address;
import br.com.queiroz.cleanarch.core.domain.Customer;
import br.com.queiroz.cleanarch.core.dto.CustomerDto;
import br.com.queiroz.cleanarch.core.usecase.InsertCustomerUseCase;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {

    private FindAddressByZipCode findAddressByZipCode;
    private InsertCustomer insertCustomer;

    public InsertCustomerUseCaseImpl(FindAddressByZipCode findAddressByZipCode, InsertCustomer insertCustomer) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.insertCustomer = insertCustomer;
    }

    @Override
    public void insert(CustomerDto customerDto) {
        Address address = findAddressByZipCode.findAddress(customerDto.getZipCode());
        Customer customer = customerDto.toEntity();
        customer.setAddress(address);
        insertCustomer.insert(customer);
    }
}