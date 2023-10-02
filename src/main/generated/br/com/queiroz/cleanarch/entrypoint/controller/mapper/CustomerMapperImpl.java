package br.com.queiroz.cleanarch.entrypoint.controller.mapper;

import br.com.queiroz.cleanarch.core.domain.Address;
import br.com.queiroz.cleanarch.core.domain.Customer;
import br.com.queiroz.cleanarch.core.dto.CustomerDto;
import br.com.queiroz.cleanarch.entrypoint.controller.request.CustomerRequest;
import br.com.queiroz.cleanarch.entrypoint.controller.response.AddressResponse;
import br.com.queiroz.cleanarch.entrypoint.controller.response.CustomerResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-02T00:16:01-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4.1 (Azul Systems, Inc.)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto toCustomerDto(CustomerRequest customerRequest) {
        if ( customerRequest == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setName( customerRequest.getName() );
        customerDto.setCpf( customerRequest.getCpf() );
        customerDto.setZipCode( customerRequest.getZipCode() );

        return customerDto;
    }

    @Override
    public CustomerResponse toCustomerResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setName( customer.getName() );
        customerResponse.setCpf( customer.getCpf() );
        customerResponse.setAddress( addressToAddressResponse( customer.getAddress() ) );

        return customerResponse;
    }

    protected AddressResponse addressToAddressResponse(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressResponse addressResponse = new AddressResponse();

        addressResponse.setStreet( address.getStreet() );
        addressResponse.setCity( address.getCity() );
        addressResponse.setState( address.getState() );

        return addressResponse;
    }
}
