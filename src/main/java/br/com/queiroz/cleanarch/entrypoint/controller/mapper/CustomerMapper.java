package br.com.queiroz.cleanarch.entrypoint.controller.mapper;

import br.com.queiroz.cleanarch.core.dto.CustomerDto;
import br.com.queiroz.cleanarch.entrypoint.controller.request.CustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    CustomerDto toCustomerDto(CustomerRequest customerRequest);


}
