package com.generation.ApiFarmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity/*A anotação @Entity é utilizada para informar que uma classe também é uma entidade. A partir disso, a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados, onde os dados de objetos desse tipo poderão ser persistidos.*/
@Table(name= "tb_produto") // A anotação @Table sobreescreve o nome da tabela que seria criada com o nome da sua classe e permite que você informe um nome de acordo com o parâmetro que foi passado. 
public class ProdutoModel {
	
	@Id // A anotação @Id é utilizada para informar ao JPA qual campo/atributo de uma entidade estará relacionado à chave primária da respectiva tabela no banco de dados.
	@GeneratedValue(strategy = GenerationType.IDENTITY) /*A anotação @GeneratedValue é usada para especificar como a chave primária deve ser gerada. Em seu exemplo, você está usando:
	Este GenerationType.IDENTITY indica que o provedor de persistência deve atribuir chaves primárias para a entidade usando uma coluna de identidade do banco de dados. Esta coluna de 
	tipo especial é preenchida internamente pela própria tabela, sem usar uma sequência separada.*/
	private Long id; 
	
	@NotBlank(message = "O atributo é Obrigatorio e não pode utilizar espaços  em branco!")
	@Size(min = 2, max = 50, message = "O atributo título deve conter no mínimo 02 e no máximo 50 caracteres!")		
	private String nome;
	
	@NotBlank(message = "O atributo é Obrigatorio e não pode utilizar espaços  em branco!")
	@Size(min = 2, max = 50, message = "O atributo título deve conter no mínimo 02 e no máximo 50 caracteres!")		
	private String marca;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private CategoriaModel categoria;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}
	
    

}
