package br.com.queiroz.cleanarch.entrypoint.consumer;

import br.com.queiroz.cleanarch.core.dto.CustomerDto;
import br.com.queiroz.cleanarch.core.usecase.UpdateCustomerUseCase;
import br.com.queiroz.cleanarch.entrypoint.consumer.mapper.CustomerMessageMapper;
import br.com.queiroz.cleanarch.entrypoint.consumer.message.CustomerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

  private final UpdateCustomerUseCase updateCustomerUseCase;
  private final CustomerMessageMapper customerMessageMapper;

  @Autowired
  public ReceiveValidatedCpfConsumer(
      UpdateCustomerUseCase updateCustomerUseCase,
      CustomerMessageMapper customerMessageMapper
  ) {
    this.updateCustomerUseCase = updateCustomerUseCase;
    this.customerMessageMapper = customerMessageMapper;
  }

  @KafkaListener(topics = "tp-cpf-validated", groupId = "queiroz")
  public void receive(CustomerMessage customerMessage) throws NotFoundException {
    CustomerDto customer = customerMessageMapper.toCustomerDto(customerMessage);
    updateCustomerUseCase.update(customer);
  }
}