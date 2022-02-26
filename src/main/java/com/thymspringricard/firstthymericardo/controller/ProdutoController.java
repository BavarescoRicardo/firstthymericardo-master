package com.thymspringricard.firstthymericardo.controller;
import com.thymspringricard.firstthymericardo.repositorios.ProdutoRepositorio;

import java.util.List;
import com.thymspringricard.firstthymericardo.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

	@Autowired
    private ProdutoRepositorio prodDB;

	public Produto salvarLogin(@RequestBody Produto produto)
    {
		return this.prodDB.save(produto);
	}

    public List<Produto> listagenProd() 
    {        
        return this.prodDB.findAll();
    }

}
