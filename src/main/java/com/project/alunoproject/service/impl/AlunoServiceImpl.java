package com.project.alunoproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.project.alunoproject.model.Aluno;
import com.project.alunoproject.repository.AlunoRepository;
import com.project.alunoproject.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {
	@Autowired private AlunoRepository alunoRepository;

	@Override
	public Aluno findById(Long id) throws ResourceNotFoundException {		
		return alunoRepository.findById(id)
				  .map(a -> a)
				  .orElseThrow(() -> new ResourceNotFoundException("Aluno não existe!"));
	}

	@Override
	public List<Aluno> findAll() {		
		return alunoRepository.findAll();
	}
	
	@Override
	public Aluno create(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@Override
	public Aluno save(Aluno aluno) throws ResourceNotFoundException {
		alunoRepository.findById(aluno.id)
		  .map(a -> a)
		  .orElseThrow(() -> new ResourceNotFoundException("Aluno não existe!"));
		return alunoRepository.save(aluno);
	}

	@Override
	public void deleteById(Long id) {
		alunoRepository.deleteById(id);
	}
	
	
}
