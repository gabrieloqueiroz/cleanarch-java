package br.com.queiroz.cleanarch.core.usecase.impl;

import br.com.queiroz.cleanarch.core.dataprovider.FindCustomer;
import br.com.queiroz.cleanarch.core.domain.Customer;
import br.com.queiroz.cleanarch.core.usecase.FindCustomerByIdUseCase;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {

  private FindCustomer findCustomer;

  public FindCustomerByIdUseCaseImpl(FindCustomer findCustomer) {
    this.findCustomer = findCustomer;
  }

  @Override
  public Customer find(String id) throws NotFoundException {
    return findCustomer.find(id).orElseThrow(NotFoundException::new);
  }
}
