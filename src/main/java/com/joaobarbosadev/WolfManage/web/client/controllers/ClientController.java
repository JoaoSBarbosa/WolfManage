package com.joaobarbosadev.WolfManage.web.client.controllers;

import com.joaobarbosadev.WolfManage.core.enums.Country;
import com.joaobarbosadev.WolfManage.core.enums.States;
import com.joaobarbosadev.WolfManage.core.models.Client;
import com.joaobarbosadev.WolfManage.core.repositories.ClientRepository;
import com.joaobarbosadev.WolfManage.core.services.ClientService;
import com.joaobarbosadev.WolfManage.web.client.dtos.ClientForm;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
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
        ModelAndView modelAndView = new ModelAndView("clients/create");
        modelAndView.addObject("client", new ClientForm());
        return modelAndView;
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("client") ClientForm form) {
        clientService.save(form);
        return "redirect:/clients";
    }

    @GetMapping("/delete/{clientId}")
    public String delete(@PathVariable Long clientId) {
        clientService.deleteById(clientId);
        return "redirect:/clients";
    }


    @GetMapping("/edit/{clientId}")
    public ModelAndView edit(@PathVariable Long clientId) {
        var client = clientService.findById(clientId);
        ModelAndView model = new ModelAndView("clients/edit");
        model.addObject("clientForm", client);
        return model;
    }

    @PostMapping("/edit/{clientId}")
    public String edit(@PathVariable Long clientId, @ModelAttribute("clientForm") ClientForm form) {
        clientService.update(clientId, form);
        return "redirect:/clients";
    }
}
