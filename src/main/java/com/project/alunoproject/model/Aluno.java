package com.project.alunoproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aluno")
public class Aluno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluno")
	public Long id;	
	@NotEmpty(message = "Preencha um nome válido!")
	@Column(name = "nm_aluno")
	public String name;
	@NotNull(message = "Preencha uma idade valida")
	@Min(value = 1, message = "Preencha uma idade maior que {}")
	@Column(name = "nr_idade")
	public int idade;
}
