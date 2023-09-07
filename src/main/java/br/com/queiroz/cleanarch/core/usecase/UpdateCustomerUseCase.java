package br.com.queiroz.cleanarch.core.usecase;

import br.com.queiroz.cleanarch.core.dto.CustomerDto;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface UpdateCustomerUseCase {
    void update(CustomerDto customerDto) throws NotFoundException;
}
