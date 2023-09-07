package br.com.queiroz.cleanarch.dataprovider.repository.mapper;

import br.com.queiroz.cleanarch.core.domain.Customer;
import br.com.queiroz.cleanarch.dataprovider.repository.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    CustomerEntity toCustomerEntity(Customer customer);
    Customer toCustomer(CustomerEntity customerEntity);
}
