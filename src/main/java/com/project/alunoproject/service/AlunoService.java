package com.project.alunoproject.service;

import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.project.alunoproject.model.Aluno;

public interface AlunoService {
	
	Aluno findById(Long id) throws ResourceNotFoundException;
	List<Aluno> findAll();
	Aluno create(Aluno aluno);
	Aluno save(Aluno id) throws ResourceNotFoundException;
	void deleteById(Long id);	
}
