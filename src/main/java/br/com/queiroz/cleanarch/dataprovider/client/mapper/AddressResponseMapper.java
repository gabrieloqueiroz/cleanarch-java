package br.com.queiroz.cleanarch.dataprovider.client.mapper;

import br.com.queiroz.cleanarch.core.domain.Address;
import br.com.queiroz.cleanarch.dataprovider.client.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    Address toAddress(AddressResponse addressResponse);
}
