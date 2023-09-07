package br.com.queiroz.cleanarch.dataprovider.client.mapper;

import br.com.queiroz.cleanarch.core.domain.Address;
import br.com.queiroz.cleanarch.dataprovider.client.response.AddressResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-27T23:31:46-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.5 (Azul Systems, Inc.)"
)
@Component
public class AddressResponseMapperImpl implements AddressResponseMapper {

    @Override
    public Address toAddress(AddressResponse addressResponse) {
        if ( addressResponse == null ) {
            return null;
        }

        Address address = new Address();

        return address;
    }
}
