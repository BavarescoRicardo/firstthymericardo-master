package com.thymspringricard.firstthymericardo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thymspringricard.firstthymericardo.model.Login;

public interface LoginRepositorio extends JpaRepository<Login, Long>
{
    // @Query("select u from User u where u.nomelogin = ?1")
    // Login findByFirstname(String firstname);
    
}
