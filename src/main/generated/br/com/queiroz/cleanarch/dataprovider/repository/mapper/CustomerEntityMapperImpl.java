package br.com.queiroz.cleanarch.dataprovider.repository.mapper;

import br.com.queiroz.cleanarch.core.domain.Customer;
import br.com.queiroz.cleanarch.dataprovider.repository.entity.CustomerEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-07T02:11:33-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.5 (Azul Systems, Inc.)"
)
@Component
public class CustomerEntityMapperImpl implements CustomerEntityMapper {

    @Override
    public CustomerEntity toCustomerEntity(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        return customerEntity;
    }

    @Override
    public Customer toCustomer(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        Customer customer = new Customer();

        return customer;
    }
}
