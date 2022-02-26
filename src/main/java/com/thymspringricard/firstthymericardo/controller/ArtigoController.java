package com.thymspringricard.firstthymericardo.controller;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import com.thymspringricard.firstthymericardo.model.Artigo;
import com.thymspringricard.firstthymericardo.model.Login;
import com.thymspringricard.firstthymericardo.model.Produto;
import com.thymspringricard.firstthymericardo.model.Usuario;
import com.thymspringricard.firstthymericardo.repositorios.ArtigoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArtigoController{

    @Autowired
    private ArtigoRepositorio artigoDB;

    @GetMapping("/artigos")
    public String getArtigo(Model model)
    {
        List<Artigo> listtaArtigo = this.artigoDB.findAll();
		model.addAttribute("artigos", listtaArtigo);

		return "lista_add_artigos";
    }

    @PostMapping("/salvaartigo")
	public String salvarLogin(@ModelAttribute Artigo artigo)
    {
        this.artigoDB.save(new Artigo(artigo.getTitulo(), artigo.getDescricao()));
        
        return "login";
	}


}



