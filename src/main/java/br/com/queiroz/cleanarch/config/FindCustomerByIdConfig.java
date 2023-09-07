package br.com.queiroz.cleanarch.config;

import br.com.queiroz.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import br.com.queiroz.cleanarch.dataprovider.FindCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

  @Bean
  public FindCustomerByIdUseCaseImpl findCustomerByIdUseCase(FindCustomerImpl findCustomer) {
    return new FindCustomerByIdUseCaseImpl(findCustomer);
  }
}