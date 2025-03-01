package com.joaobarbosadev.WolfManage.web.client.controllers;

import com.joaobarbosadev.WolfManage.core.enums.Country;
import com.joaobarbosadev.WolfManage.core.models.Client;
import com.joaobarbosadev.WolfManage.core.repositories.ClientRepository;
import com.joaobarbosadev.WolfManage.core.services.ClientService;
import com.joaobarbosadev.WolfManage.web.client.dtos.ClientForm;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/create")
    public ModelAndView create() {
        var clientForm = new ClientForm(
                "João Barbosa",
                "contato@barbosa.com",
                "11998585858",
                "Avenida Industrial primeira",
                "52",
                "São Paulo",
                "SP",
                "Vila Prudente",
                Country.BRAZIL
        );
        var model = Map.of("clientForm", clientForm);
        return new ModelAndView("clients/create", model);
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("client") ClientForm form) {
        clientService.save(form);
        return "redirect:/clients";
    }
}
