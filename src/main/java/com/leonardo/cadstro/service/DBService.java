package com.leonardo.cadstro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.cadstro.domain.Produto;
import com.leonardo.cadstro.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private ProdutoRepository repo;
	
	public void inicializarBD() {
		Produto produto = new Produto(null, "Camisa", 2, 29.99);
		repo.save(produto);
	}
	
}
