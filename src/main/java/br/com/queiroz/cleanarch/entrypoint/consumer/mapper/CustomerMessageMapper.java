package br.com.queiroz.cleanarch.entrypoint.consumer.mapper;

import br.com.queiroz.cleanarch.core.dto.CustomerDto;
import br.com.queiroz.cleanarch.entrypoint.consumer.message.CustomerMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

  CustomerDto toCustomerDto(CustomerMessage customerMessage);
}
