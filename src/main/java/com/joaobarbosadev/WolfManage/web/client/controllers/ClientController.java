package com.joaobarbosadev.WolfManage.web.client.controllers;

import com.joaobarbosadev.WolfManage.core.models.Client;
import com.joaobarbosadev.WolfManage.core.repositories.ClientRepository;
import com.joaobarbosadev.WolfManage.core.services.ClientService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    private final ClientRepository clientRepository;
    @GetMapping
    public ModelAndView index(){
        var clients = clientService.findAll();
        var modal = Map.of("clients", clients);
        return new ModelAndView("clients/index", modal);
    }
}
