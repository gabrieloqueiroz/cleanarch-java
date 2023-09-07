package br.com.queiroz.cleanarch.core.usecase.impl;

import br.com.queiroz.cleanarch.core.dataprovider.DeleteCustomer;
import br.com.queiroz.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import br.com.queiroz.cleanarch.core.usecase.FindCustomerByIdUseCase;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public class DeleteCustomerByIdUseCaseImpl implements DeleteCustomerByIdUseCase {

  private final FindCustomerByIdUseCase findCustomerByIdUseCase;
  private final DeleteCustomer deleteCustomer;

  public DeleteCustomerByIdUseCaseImpl(
      FindCustomerByIdUseCase findCustomerByIdUseCase,
      DeleteCustomer deleteCustomer
  ) {
    this.findCustomerByIdUseCase = findCustomerByIdUseCase;
    this.deleteCustomer = deleteCustomer;
  }

  @Override
  public void delete(String id) throws NotFoundException {
    findCustomerByIdUseCase.find(id);
    deleteCustomer.delete(id);
  }
}
