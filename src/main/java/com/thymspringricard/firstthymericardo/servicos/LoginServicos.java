package com.thymspringricard.firstthymericardo.servicos;

import com.thymspringricard.firstthymericardo.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServicos 
{    
    @Autowired
    private UsuarioRepositorio userDB;

    public String Logar(String nome, String senha){
        String result = "naum deu";
        try {
            result =  " Encontrado:  ";
            result += userDB.findByNomeSenha(nome,  senha).toString();            
        } catch (Exception e) {
            //TODO: handle exception
            result =  " :Exceção:  ";
        }

        return result;
    }
}
    

