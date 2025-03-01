package com.joaobarbosadev.WolfManage.core.services;

import com.joaobarbosadev.WolfManage.core.models.Client;
import com.joaobarbosadev.WolfManage.core.repositories.ClientRepository;
import com.joaobarbosadev.WolfManage.web.client.dtos.ClientForm;
import com.joaobarbosadev.WolfManage.web.client.dtos.ClientViewModel;
import com.joaobarbosadev.WolfManage.web.client.mappers.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;
    @Transactional( readOnly = true )
    public Page<Client> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public List<ClientViewModel> findAll() {
        var clients = clientRepository.findAll();
        return clients.stream().map(clientMapper::toClientViewModel).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public ClientViewModel save(ClientForm form) {
        Client client = clientMapper.toClient(form);
        return clientMapper.toClientViewModel(clientRepository.save(client));
    }
}
