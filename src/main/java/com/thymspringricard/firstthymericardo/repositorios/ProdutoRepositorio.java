package com.thymspringricard.firstthymericardo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thymspringricard.firstthymericardo.model.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long>
{
    
}
