package br.com.queiroz.cleanarch.core.usecase;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface DeleteCustomerByIdUseCase {
  void delete(String id) throws NotFoundException;
}
