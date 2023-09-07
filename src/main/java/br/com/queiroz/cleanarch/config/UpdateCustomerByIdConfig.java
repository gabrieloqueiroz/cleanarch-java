package br.com.queiroz.cleanarch.config;

import br.com.queiroz.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import br.com.queiroz.cleanarch.core.usecase.impl.UpdateCustomerUseCaseImpl;
import br.com.queiroz.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import br.com.queiroz.cleanarch.dataprovider.FindCustomerImpl;
import br.com.queiroz.cleanarch.dataprovider.UpdateCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerByIdConfig {

  @Bean
  public UpdateCustomerUseCaseImpl updateCustomerUseCase(
      UpdateCustomerImpl updateCustomer,
      FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
      FindAddressByZipCodeImpl findAddressByZipCode
  ) {
    return new UpdateCustomerUseCaseImpl(updateCustomer,findCustomerByIdUseCase,findAddressByZipCode);
  }
}