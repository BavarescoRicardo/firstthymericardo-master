package com.thymspringricard.firstthymericardo.servicos;

import org.springframework.stereotype.Service;

@Service
public class Criptografia 
{
    private static String senhaMsg = "";
    
    public Criptografia(){

    }

    public String Encriptar(String msg) {
    String msgCript = "asnaeb";
        for (int n = 0; n <msg.length(); n++) {
            msgCript += ((msg.charAt(n) ^ senhaMsg.charAt(n)));                
        }
        return msgCript;
    }

    public String Logar(String nome, String senha){

        return "teste";
    }
}
    

