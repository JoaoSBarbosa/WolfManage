package com.joaobarbosadev.WolfManage.web.common.handlers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.NoSuchElementException;


@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ModelAndView handleNoSuchElementException(NoSuchElementException e) {
        var model = Map.of("message", e.getMessage() != null ? e.getMessage() : "Elemento não encontrado.");
        return new ModelAndView("error/error", model);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ModelAndView handleEntityNotFoundException(EntityNotFoundException e) {
        var model = Map.of("message", e.getMessage() != null ? e.getMessage() : "Entidade não encontrada.");
        return new ModelAndView("error/error", model);
    }

//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleGenericException(Exception e) {
//        var model = Map.of("message", "Erro inesperado: " + e.getMessage());
//        return new ModelAndView("error/error", model);
//    }
}