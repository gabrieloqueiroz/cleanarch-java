package br.com.queiroz.cleanarch.entrypoint.controller;

import br.com.queiroz.cleanarch.core.dto.CustomerDto;
import br.com.queiroz.cleanarch.core.usecase.InsertCustomerUseCase;
import br.com.queiroz.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import br.com.queiroz.cleanarch.entrypoint.controller.request.CustomerRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

  private InsertCustomerUseCase insertCustomerUseCase;
  private CustomerMapper customerMapper;

  @PostMapping
  public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
    CustomerDto customerDto = customerMapper.toCustomerDto(customerRequest);
    insertCustomerUseCase.insert(customerDto);

    return ResponseEntity.ok().build();
  }
}
