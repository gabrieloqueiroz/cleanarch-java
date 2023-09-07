package br.com.queiroz.cleanarch.config;

import br.com.queiroz.cleanarch.core.usecase.impl.InsertCustomerUseCaseImpl;
import br.com.queiroz.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import br.com.queiroz.cleanarch.dataprovider.InsertCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

  @Bean
  public InsertCustomerUseCaseImpl insertCustomerUseCase(
      FindAddressByZipCodeImpl findAddressByZipCode,
      InsertCustomerImpl insertCustomer
  ) {
    return new InsertCustomerUseCaseImpl(findAddressByZipCode, insertCustomer);
  }
}