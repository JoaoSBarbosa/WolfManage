package com.joaobarbosadev.WolfManage.core.services;

import com.joaobarbosadev.WolfManage.core.models.Client;
import com.joaobarbosadev.WolfManage.core.repositories.ClientRepository;
import com.joaobarbosadev.WolfManage.web.client.dtos.ClientForm;
import com.joaobarbosadev.WolfManage.web.client.dtos.ClientViewModel;
import com.joaobarbosadev.WolfManage.web.client.mappers.ClientMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    @Transactional(readOnly = true)
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

    @Override
    @Transactional
    public void deleteById(Long id) {
        try {
            Client client = clientRepository.getReferenceById(id);
            clientRepository.delete(client);
        } catch (EntityNotFoundException e) {
            throw new NoSuchElementException("Client with id " + id + " not found");
        }
    }

    @Override
    @Transactional( readOnly = true)
    public ClientForm findById(Long id) {
        var client = clientRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return  clientMapper.toClientForm(client);
    }

    @Override
    @Transactional
    public void update(Long clientId, ClientForm form) {
        if(clientId == null) throw new RuntimeException("Client id is null");
        if(!clientRepository.existsById(clientId))throw new NoSuchElementException("Cliente com ID " + clientId + " não encontrado");
        form.setId(clientId);
        clientRepository.save(clientMapper.toClient(form));
    }
}
