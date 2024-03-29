package com.project.alunoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.alunoproject.model.Aluno;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
