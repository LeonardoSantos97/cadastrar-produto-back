package com.leonardo.cadstro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.cadstro.domain.Produto;
import com.leonardo.cadstro.repositories.ProdutoRepository;
import com.leonardo.cadstro.service.exception.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	public Produto findById(Integer id) {
		Optional<Produto> produto = repo.findById(id);
		return produto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + "Tipo: " + Produto.class.getName()));
	}
	
	public List<Produto> findAll(){
		return repo.findAll();
	}
	
	public Produto save(Produto produto) {
		produto.setId(null);
		return repo.save(produto);
	}
	
	public Produto update(Produto produto) {
		//Produto newProduto = new Produto();
		Produto newProduto = findById(produto.getId());
		updateProduto(produto, newProduto);
		return repo.save(newProduto);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);

	}
	
	private void updateProduto(Produto oldProduto, Produto newProduto) {
		newProduto.setNome(oldProduto.getNome());
		newProduto.setQuantidade(oldProduto.getQuantidade());
		newProduto.setValor(oldProduto.getValor());
	}
	
}
