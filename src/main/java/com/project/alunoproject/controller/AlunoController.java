package com.project.alunoproject.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.alunoproject.model.Aluno;
import com.project.alunoproject.service.AlunoService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
 
  @Autowired
  AlunoService alunoService;
  @PostConstruct
  public void Mock() throws NotFoundException {
	for(int alunoIndex = 1; alunoIndex <= 10; alunoIndex++) {
		Aluno aluno = new Aluno();
		aluno.setIdade(10 + alunoIndex);
		aluno.setName("Aluno " + alunoIndex);
		alunoService.create(aluno);
	}	
  }
  
  @GetMapping("/{id}")
  public Aluno get(@PathVariable Long id) throws ResourceNotFoundException {
	  return alunoService.findById(id);
  }
   
  @GetMapping
  public List<Aluno> get() {
    return alunoService.findAll();
  }
  
  @PostMapping
  public Aluno put(@RequestBody Aluno aluno) {
    return alunoService.create(aluno);
  }   
  
  @PutMapping
  public Aluno post(@RequestBody Aluno aluno) throws ResourceNotFoundException {
	return alunoService.save(aluno);
  }
 
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
	  alunoService.deleteById(id);
  }
  
}