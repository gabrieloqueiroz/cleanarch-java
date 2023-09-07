package br.com.queiroz.cleanarch.dataprovider;

import br.com.queiroz.cleanarch.core.dataprovider.FindAddressByZipCode;
import br.com.queiroz.cleanarch.core.domain.Address;
import br.com.queiroz.cleanarch.dataprovider.client.FindAddressByZipCodeClient;
import br.com.queiroz.cleanarch.dataprovider.client.mapper.AddressResponseMapper;
import br.com.queiroz.cleanarch.dataprovider.client.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeImpl implements FindAddressByZipCode {

    private FindAddressByZipCodeClient findAddressByZipCodeClient;
    private AddressResponseMapper mapper;

    @Autowired
    public FindAddressByZipCodeImpl(FindAddressByZipCodeClient findAddressByZipCodeClient, AddressResponseMapper mapper) {
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
        this.mapper = mapper;
    }

    @Override
    public Address findAddress(String zipCode) {
        AddressResponse addressResponse = findAddressByZipCodeClient.find(zipCode);
        return mapper.toAddress(addressResponse);
    }
}