package br.com.queiroz.cleanarch.core.dto;

import br.com.queiroz.cleanarch.core.domain.Customer;

public class CustomerDto {
    private String id;
    private String name;
    private String cpf;
    private String zipCode;
    private Boolean isValidCpf;

    public CustomerDto() {
        this.isValidCpf = false;
    }

    public CustomerDto(String id, String name, String cpf, String zipCode) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.zipCode = zipCode;
        this.isValidCpf = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Boolean getValidCpf() {
        return isValidCpf;
    }

    public void setValidCpf(Boolean validCpf) {
        isValidCpf = validCpf;
    }

    public Customer toEntity(){
        Customer customer = new Customer();
        customer.setId(this.getId());
        customer.setCpf(this.getCpf());
        customer.setName(this.getName());
        customer.setValidCpf(this.getValidCpf());

        return customer;
    }
}
