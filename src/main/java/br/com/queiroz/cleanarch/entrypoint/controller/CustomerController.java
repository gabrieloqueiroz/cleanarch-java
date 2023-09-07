package br.com.queiroz.cleanarch.entrypoint.controller;

import br.com.queiroz.cleanarch.core.dataprovider.FindCustomer;
import br.com.queiroz.cleanarch.core.domain.Customer;
import br.com.queiroz.cleanarch.core.dto.CustomerDto;
import br.com.queiroz.cleanarch.core.usecase.FindCustomerByIdUseCase;
import br.com.queiroz.cleanarch.core.usecase.InsertCustomerUseCase;
import br.com.queiroz.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import br.com.queiroz.cleanarch.entrypoint.controller.request.CustomerRequest;
import br.com.queiroz.cleanarch.entrypoint.controller.response.CustomerResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

  @Autowired
  public CustomerController(InsertCustomerUseCase insertCustomerUseCase,
      CustomerMapper customerMapper,
      FindCustomerByIdUseCase findCustomerByIdUseCase) {
    this.insertCustomerUseCase = insertCustomerUseCase;
    this.customerMapper = customerMapper;
    this.findCustomerByIdUseCase = findCustomerByIdUseCase;
  }

  private InsertCustomerUseCase insertCustomerUseCase;
  private FindCustomerByIdUseCase findCustomerByIdUseCase;
  private CustomerMapper customerMapper;

  @PostMapping
  public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
    CustomerDto customerDto = customerMapper.toCustomerDto(customerRequest);
    insertCustomerUseCase.insert(customerDto);

    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerResponse> findById(@PathVariable String id) throws NotFoundException {
    Customer customer = findCustomerByIdUseCase.find(id);

    CustomerResponse customerResponse = customerMapper.toCustomerResponse(customer);

    return ResponseEntity.ok(customerResponse);
  }
}