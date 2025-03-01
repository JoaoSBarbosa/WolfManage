package com.joaobarbosadev.WolfManage.web.client.mappers;

import com.joaobarbosadev.WolfManage.core.models.Client;
import com.joaobarbosadev.WolfManage.web.client.dtos.ClientForm;
import com.joaobarbosadev.WolfManage.web.client.dtos.ClientViewModel;

public interface ClientMapper {

    ClientViewModel toClientViewModel(Client client);
    Client toClient(ClientForm form);
}
