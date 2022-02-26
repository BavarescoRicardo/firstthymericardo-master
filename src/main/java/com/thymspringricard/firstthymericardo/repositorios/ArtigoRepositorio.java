package com.thymspringricard.firstthymericardo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thymspringricard.firstthymericardo.model.Artigo;

public interface ArtigoRepositorio extends JpaRepository<Artigo, Long>
{
    // @Query("select u from User u where u.nomelogin = ?1")
    // Login findByFirstname(String firstname);
    
}
