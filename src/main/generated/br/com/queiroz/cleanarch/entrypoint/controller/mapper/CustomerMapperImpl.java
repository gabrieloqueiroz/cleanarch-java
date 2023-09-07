package br.com.queiroz.cleanarch.entrypoint.controller.mapper;

import br.com.queiroz.cleanarch.core.domain.Customer;
import br.com.queiroz.cleanarch.core.dto.CustomerDto;
import br.com.queiroz.cleanarch.entrypoint.controller.request.CustomerRequest;
import br.com.queiroz.cleanarch.entrypoint.controller.response.CustomerResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-07T02:11:33-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.5 (Azul Systems, Inc.)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto toCustomerDto(CustomerRequest customerRequest) {
        if ( customerRequest == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        return customerDto;
    }

    @Override
    public CustomerResponse toCustomerResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();

        return customerResponse;
    }
}
