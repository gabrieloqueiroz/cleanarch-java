package br.com.queiroz.cleanarch.core.usecase;

import br.com.queiroz.cleanarch.core.domain.Customer;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface FindCustomerByIdUseCase {
  Customer find(String id) throws NotFoundException;
}
