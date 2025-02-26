package com.joaobarbosadev.WolfManage.core.services;

import com.joaobarbosadev.WolfManage.core.models.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {

    Page<Client> findAll(Pageable pageable);
    List<Client> findAll();
}
