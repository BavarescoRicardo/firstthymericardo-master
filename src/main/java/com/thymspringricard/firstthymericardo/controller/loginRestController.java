package com.thymspringricard.firstthymericardo.controller;

import java.util.List;

import com.thymspringricard.firstthymericardo.model.Usuario;
import com.thymspringricard.firstthymericardo.repositorios.UsuarioRepositorio;
import com.thymspringricard.firstthymericardo.servicos.LoginServicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "http://localhost:3033", maxAge = 3600)
@CrossOrigin
@RestController
public class loginRestController {

    @Autowired
    private UsuarioRepositorio userDB;
    @Autowired
    private LoginServicos loginServicos;
    // Spring Security

    @RequestMapping(value = "/salvaloginapi", method =  RequestMethod.POST)
	public String salvarLogin(@RequestBody Usuario user)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        this.userDB.save(user);
        
        return "certo";
	}

    @RequestMapping(value = "/fazerloginapi", method =  RequestMethod.POST)
    public String fazerlogin(@RequestBody Usuario user)
    {
        String resultado;
		resultado = "ponto de controle  ";
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        resultado = loginServicos.Logar(user.getNomelogin(), user.getSenhalogin());
        return resultado;

	}
        
    @RequestMapping(value = "/loginsapi", method = RequestMethod.GET)
    public List<Usuario> listagenLog() 
    {        
        return this.userDB.findAll();
    }

}