package com.thymspringricard.firstthymericardo.controller;

import java.util.List;
import com.thymspringricard.firstthymericardo.model.Artigo;
import com.thymspringricard.firstthymericardo.repositorios.ArtigoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
public class ArtigoRestController {
    @Autowired
    private ArtigoRepositorio artigoRepositorio;

    @RequestMapping(value = "/artigosapi", method = RequestMethod.GET)
    public List<Artigo> Get() {
        return artigoRepositorio.findAll();
    }
}