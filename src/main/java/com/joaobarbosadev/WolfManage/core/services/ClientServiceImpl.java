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
            throw new RuntimeException("Client with id " + id + " not found");
        }

    }

    @Override
    @Transactional( readOnly = true)
    public ClientForm findById(Long id) {
        var client = clientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return  clientMapper.toClientForm(client);
    }

    @Override
    @Transactional
    public void update(Long clientId, ClientForm form) {

        if(clientId == null){
            throw new RuntimeException("Client id is null");
        }
        try {
            Client client = clientRepository.getReferenceById(clientId);

            if ( form.getAddress() != null ) client.setAddress(form.getAddress());
            if ( form.getEmail() != null ) client.setEmail(form.getEmail());
            if ( form.getName() != null ) client.setName(form.getName());
            if ( form.getPhone() != null ) client.setPhone(clientMapper.cleanPhoneFormat(form.getPhone()));
            if ( form.getCity() != null ) client.setCity(form.getCity());
            if ( form.getState() != null ) client.setState(form.getState());
            if ( form.getCountry() != null ) client.setCountry(form.getCountry());
            if ( form.getAddressNumber() != null ) client.setAddressNumber(form.getAddressNumber());
            if ( form.getNeighbourhood() != null) client.setNeighbourhood(form.getNeighbourhood());
            clientRepository.save(client);
        }catch (EntityNotFoundException e) {
            throw new RuntimeException("Cliente com ID " + clientId + " não encontrado");
        }
    }
}
