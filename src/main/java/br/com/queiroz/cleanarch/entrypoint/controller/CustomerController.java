package br.com.queiroz.cleanarch.entrypoint.controller;

import static br.com.queiroz.cleanarch.util.ConstantsUtil.BASE_PATH_CUSTOMER;

import br.com.queiroz.cleanarch.core.domain.Customer;
import br.com.queiroz.cleanarch.core.dto.CustomerDto;
import br.com.queiroz.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import br.com.queiroz.cleanarch.core.usecase.FindCustomerByIdUseCase;
import br.com.queiroz.cleanarch.core.usecase.InsertCustomerUseCase;
import br.com.queiroz.cleanarch.core.usecase.UpdateCustomerUseCase;
import br.com.queiroz.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import br.com.queiroz.cleanarch.entrypoint.controller.request.CustomerRequest;
import br.com.queiroz.cleanarch.entrypoint.controller.response.CustomerResponse;
import feign.Response;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(BASE_PATH_CUSTOMER)
public class CustomerController {

  @Autowired
  public CustomerController(
      InsertCustomerUseCase insertCustomerUseCase,
      CustomerMapper customerMapper,
      FindCustomerByIdUseCase findCustomerByIdUseCase,
      UpdateCustomerUseCase updateCustomerUseCase,
      DeleteCustomerByIdUseCase deleteCustomerByIdUseCase
  ) {
    this.insertCustomerUseCase = insertCustomerUseCase;
    this.customerMapper = customerMapper;
    this.findCustomerByIdUseCase = findCustomerByIdUseCase;
    this.updateCustomerUseCase = updateCustomerUseCase;
    this.deleteCustomerByIdUseCase = deleteCustomerByIdUseCase;
  }

  private final InsertCustomerUseCase insertCustomerUseCase;
  private final FindCustomerByIdUseCase findCustomerByIdUseCase;
  private final UpdateCustomerUseCase updateCustomerUseCase;
  private final DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;
  private final CustomerMapper customerMapper;

  @PostMapping
  public ResponseEntity<CustomerResponse> insert(@Valid @RequestBody CustomerRequest customerRequest, UriComponentsBuilder uriBuilder) {
    CustomerDto customerDto = customerMapper.toCustomerDto(customerRequest);
    Customer savedCustomer = insertCustomerUseCase.insert(customerDto);

    CustomerResponse customerResponse = customerMapper.toCustomerResponse(savedCustomer);

    URI uri = uriBuilder.path(BASE_PATH_CUSTOMER + "/{id}").buildAndExpand(savedCustomer.getId()).toUri();
    return ResponseEntity.created(uri).body(customerResponse);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerResponse> findById(@PathVariable String id) throws NotFoundException {
    Customer customer = findCustomerByIdUseCase.find(id);

    CustomerResponse customerResponse = customerMapper.toCustomerResponse(customer);

    return ResponseEntity.ok(customerResponse);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateById(
      @PathVariable String id,
      @Valid @RequestBody CustomerRequest customerRequest
  ) throws NotFoundException {

    CustomerDto customerDto = customerMapper.toCustomerDto(customerRequest);
    customerDto.setId(id);

    updateCustomerUseCase.update(customerDto);

    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable String id) throws NotFoundException {
    deleteCustomerByIdUseCase.delete(id);

    return ResponseEntity.noContent().build();
  }
}