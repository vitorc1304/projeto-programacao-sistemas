package br.edu.mackenzie.disciplinas.repository;

import br.edu.mackenzie.disciplinas.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository
        extends JpaRepository<Disciplina, Long> {
        }
