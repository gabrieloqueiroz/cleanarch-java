package br.com.queiroz.cleanarch.config;

import br.com.queiroz.cleanarch.core.usecase.impl.DeleteCustomerByIdUseCaseImpl;
import br.com.queiroz.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import br.com.queiroz.cleanarch.core.usecase.impl.UpdateCustomerUseCaseImpl;
import br.com.queiroz.cleanarch.dataprovider.DeleteCustomerImpl;
import br.com.queiroz.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import br.com.queiroz.cleanarch.dataprovider.UpdateCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

  @Bean
  public DeleteCustomerByIdUseCaseImpl deleteCustomerByIdUseCase(
      FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
      DeleteCustomerImpl deleteCustomer
  ) {
    return new DeleteCustomerByIdUseCaseImpl(findCustomerByIdUseCase, deleteCustomer);
  }
}