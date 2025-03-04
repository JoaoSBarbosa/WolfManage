package com.joaobarbosadev.WolfManage.web.client.mappers;

import com.joaobarbosadev.WolfManage.core.models.Client;
import com.joaobarbosadev.WolfManage.web.client.dtos.ClientForm;
import com.joaobarbosadev.WolfManage.web.client.dtos.ClientViewModel;
import org.springframework.stereotype.Component;

@Component
public class ClientMapperImpl implements ClientMapper {
    @Override
    public ClientViewModel toClientViewModel(Client client) {
        if (client == null) return null;

        ClientViewModel clientViewModel = new ClientViewModel();

        clientViewModel.setId(client.getId());
        clientViewModel.setName(client.getName());
        clientViewModel.setEmail(client.getEmail());
        clientViewModel.setCity(client.getCity());
        clientViewModel.setState(client.getState());
        clientViewModel.setNeighbourhood(client.getNeighbourhood());
        clientViewModel.setAddress(client.getAddress());
        clientViewModel.setAddressNumber(client.getAddressNumber());
        clientViewModel.setPhone(getPhoneFormat(client.getPhone()));
        clientViewModel.setZip(getZipCodeFormat(client.getZip()));
        return clientViewModel;
    }

    @Override
    public Client toClient(ClientForm form) {
        if (form == null) return null;

        return Client.builder()
                .id(form.getId())
                .email(form.getEmail())
                .name(form.getName())
                .city(form.getCity())
                .state(form.getState())
                .neighbourhood(form.getNeighbourhood())
                .address(form.getAddress())
                .addressNumber(form.getAddressNumber())
                .phone(cleanNumberFormat(form.getPhone()))
                .country(form.getCountry())
                .zip( cleanNumberFormat(form.getZip()))
                .build();
    }

    @Override
    public ClientForm toClientForm(Client client) {
        if (client == null) return null;

        return ClientForm.builder()
                .email(client.getEmail())
                .name(client.getName())
                .city(client.getCity())
                .state(client.getState())
                .neighbourhood(client.getNeighbourhood())
                .address(client.getAddress())
                .addressNumber(client.getAddressNumber())
                .phone(getPhoneFormat(client.getPhone()))
                .country(client.getCountry())
                .id(client.getId())
                .zip(getZipCodeFormat(client.getZip()))
                .build();
    }

    @Override
    public String getPhoneFormat(String phone) {
        if (phone == null) return null;
        return phone.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
    }

    @Override
    public String cleanNumberFormat(String stringNumber) {
        if (stringNumber == null) return null;
        return stringNumber.replaceAll("[^0-9]","");
    }

    @Override
    public String getZipCodeFormat(String zipCode) {
        if (zipCode == null || zipCode.length() != 8) return zipCode;
        return zipCode.replaceAll("(\\d{5})(\\d{3})", "$1-$2");
    }


}
