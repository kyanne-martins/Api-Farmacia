package com.generation.ApiFarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.ApiFarmacia.model.CategoriaModel;
import com.generation.ApiFarmacia.repository.CategoriaRepository;



@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriarepository;
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>>GetAll(){
		return ResponseEntity.ok(categoriarepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> GetById(@PathVariable Long id){
		return categoriarepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<CategoriaModel>> GetByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(categoriarepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<CategoriaModel> postTema (@RequestBody CategoriaModel tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriarepository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<CategoriaModel> putPostagem (@RequestBody CategoriaModel tema){
		return ResponseEntity.ok(categoriarepository.save(tema));
	}
	
	@DeleteMapping("/{id}")
	public void deleteTema(@PathVariable Long id) {
		categoriarepository.deleteById(id);
	}	

}
