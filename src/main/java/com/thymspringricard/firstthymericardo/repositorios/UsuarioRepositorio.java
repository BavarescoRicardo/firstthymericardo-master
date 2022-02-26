package com.thymspringricard.firstthymericardo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.thymspringricard.firstthymericardo.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>
{
    @Query("select u from Usuario u where u.nomelogin = ?1")
    Usuario findByFirstname(String firstname);

    @Query("select u from Usuario u where u.nomelogin = ?1 and  u.senhalogin = ?2")
    Usuario findByNomeSenha(String fNomeirstname, String Senha);
    
}
