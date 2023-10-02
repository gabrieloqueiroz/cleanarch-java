package br.com.queiroz.cleanarch.entrypoint.controller.mapper;

import br.com.queiroz.cleanarch.core.domain.Customer;
import br.com.queiroz.cleanarch.core.dto.CustomerDto;
import br.com.queiroz.cleanarch.entrypoint.controller.request.CustomerRequest;
import br.com.queiroz.cleanarch.entrypoint.controller.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "validCpf", ignore = true)
    CustomerDto toCustomerDto(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}