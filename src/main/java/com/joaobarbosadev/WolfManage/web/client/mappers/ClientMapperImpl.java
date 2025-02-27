package com.joaobarbosadev.WolfManage.web.client.mappers;

import com.joaobarbosadev.WolfManage.core.models.Client;
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
        clientViewModel.setPhone(client.getPhone());
        return clientViewModel;
    }
}
