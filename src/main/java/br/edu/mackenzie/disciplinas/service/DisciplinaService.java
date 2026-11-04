
package br.edu.mackenzie.disciplinas.service;

import br.edu.mackenzie.disciplinas.model.Disciplina;
import br.edu.mackenzie.disciplinas.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    private final DisciplinaRepository repository;

    public DisciplinaService(DisciplinaRepository repository) {
        this.repository = repository;
    }

    public Disciplina criar(Disciplina disciplina) {
        disciplina.setId(null);
        return repository.save(disciplina);
    }

    public List<Disciplina> listarTodas() {
        return repository.findAll();
    }

    public Optional<Disciplina> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Disciplina> atualizar(Long id, Disciplina dados) {
        return repository.findById(id).map(disciplina -> {
            disciplina.setNome(dados.getNome());
            disciplina.setSigla(dados.getSigla());
            disciplina.setCurso(dados.getCurso());
            disciplina.setSemestre(dados.getSemestre());
            return repository.save(disciplina);
        });
    }

    public boolean excluir(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}
