package com.generation.ApiFarmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.ApiFarmacia.model.ProdutoModel;


@Repository //O @Repository tem como objetivo criar beans para a parte de persistência, além de capturar exceções específicas de persistência e repeti-las novamente como uma das exceções não verificadas e unificadas do Spring
public interface ProdutoRepository extends JpaRepository <ProdutoModel,Long>{
	public List <ProdutoModel> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

}
