package br.com.queiroz.cleanarch.dataprovider.client;

import br.com.queiroz.cleanarch.dataprovider.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressByZipCodeClient",
        url = "${queiroz.client.address.url}"
)
public interface FindAddressByZipCodeClient {

    @GetMapping(value = "/{zipCode}")
    AddressResponse find(@PathVariable(value = "zipCode") String zipCode);
}
