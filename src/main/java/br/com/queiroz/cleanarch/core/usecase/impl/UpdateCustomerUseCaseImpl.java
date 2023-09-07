package br.com.queiroz.cleanarch.core.usecase.impl;

import br.com.queiroz.cleanarch.core.dataprovider.FindAddressByZipCode;
import br.com.queiroz.cleanarch.core.dataprovider.UpdateCustomer;
import br.com.queiroz.cleanarch.core.domain.Address;
import br.com.queiroz.cleanarch.core.domain.Customer;
import br.com.queiroz.cleanarch.core.dto.CustomerDto;
import br.com.queiroz.cleanarch.core.usecase.FindCustomerByIdUseCase;
import br.com.queiroz.cleanarch.core.usecase.UpdateCustomerUseCase;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

  private final UpdateCustomer updateCustomer;
  private final FindCustomerByIdUseCase findCustomerByIdUseCase;
  private final FindAddressByZipCode findAddressByZipCode;

  public UpdateCustomerUseCaseImpl(
      UpdateCustomer updateCustomer,
      FindCustomerByIdUseCase findCustomerByIdUseCase,
      FindAddressByZipCode findAddressByZipCode
  ) {
    this.updateCustomer = updateCustomer;
    this.findCustomerByIdUseCase = findCustomerByIdUseCase;
    this.findAddressByZipCode = findAddressByZipCode;
  }

  @Override
  public void update(CustomerDto customerDto) throws NotFoundException {
    findCustomerByIdUseCase.find(customerDto.getId());
    Address address = findAddressByZipCode.findAddress(customerDto.getZipCode());

    Customer entity = customerDto.toEntity();
    entity.setAddress(address);

    updateCustomer.update(entity);
  }
}
