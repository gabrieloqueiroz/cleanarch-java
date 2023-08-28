package br.com.queiroz.cleanarch.core.dataprovider;

import br.com.queiroz.cleanarch.core.domain.Address;

public interface FindAddressByZipCode {
    Address findAddress(String zipCode);
}
