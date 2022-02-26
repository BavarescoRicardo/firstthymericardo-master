package com.thymspringricard.firstthymericardo.controller;

import com.thymspringricard.firstthymericardo.repositorios.UsuarioRepositorio;
import com.thymspringricard.firstthymericardo.servicos.LoginServicos;

import java.util.List;
import com.thymspringricard.firstthymericardo.model.Login;
import com.thymspringricard.firstthymericardo.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepositorio userDB;
    @Autowired
    private LoginServicos loginServicos;
    // Spring Security

    @PostMapping("/salvalogin")
	public String salvarLogin(@ModelAttribute Login login)
    {
        this.userDB.save(new Usuario(login.getId(),login.getNome_login(),login.getSenha_login(),login.getPermit()));
        
        return "login";
	}

    @PostMapping("/fazerlogin")
    public String fazerlogin(@ModelAttribute Login login, Model model)
    {
        String resultado;
		resultado = login.getSenha_login();
        resultado = loginServicos.Logar(login.getNome_login(), login.getSenha_login());
        System.out.print(resultado);

        model.addAttribute("resultado", resultado);

        return "resultado_login";
	}

    public List<Usuario> listagenLog() 
    {        
        return this.userDB.findAll();
    }

}



