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
        return repository.salvar(disciplina);
    }

    public List<Disciplina> listarTodas() {
        return repository.listarTodas();
    }

    public Optional<Disciplina> buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

    public Optional<Disciplina> atualizar(Long id, Disciplina dados) {
        return repository.buscarPorId(id).map(existente -> {
            existente.setNome(dados.getNome());
            existente.setSigla(dados.getSigla());
            existente.setCurso(dados.getCurso());
            existente.setSemestre(dados.getSemestre());
            return repository.salvar(existente);
        });
    }

    public boolean excluir(Long id) {
        if (repository.buscarPorId(id).isEmpty()) {
            return false;
        }
        repository.excluir(id);
        return true;
    }
}
