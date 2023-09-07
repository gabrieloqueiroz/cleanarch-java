package br.com.queiroz.cleanarch.core.usecase.impl;

import br.com.queiroz.cleanarch.core.dataprovider.FindAddressByZipCode;
import br.com.queiroz.cleanarch.core.dataprovider.InsertCustomer;
import br.com.queiroz.cleanarch.core.dataprovider.SendCpfForValidation;
import br.com.queiroz.cleanarch.core.domain.Address;
import br.com.queiroz.cleanarch.core.domain.Customer;
import br.com.queiroz.cleanarch.core.dto.CustomerDto;
import br.com.queiroz.cleanarch.core.usecase.InsertCustomerUseCase;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {

    private FindAddressByZipCode findAddressByZipCode;
    private InsertCustomer insertCustomer;
    private final SendCpfForValidation sendCpfForValidation;

    public InsertCustomerUseCaseImpl(
        FindAddressByZipCode findAddressByZipCode,
        InsertCustomer insertCustomer,
        SendCpfForValidation sendCpfForValidation
    ) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.insertCustomer = insertCustomer;
        this.sendCpfForValidation = sendCpfForValidation;
    }

    @Override
    public Customer insert(CustomerDto customerDto) {
        Address address = findAddressByZipCode.findAddress(customerDto.getZipCode());
        Customer customer = customerDto.toEntity();
        customer.setAddress(address);
        Customer insertedCustomer = insertCustomer.insert(customer);
        sendCpfForValidation.send(insertedCustomer.getCpf());
        return insertedCustomer;
    }
}