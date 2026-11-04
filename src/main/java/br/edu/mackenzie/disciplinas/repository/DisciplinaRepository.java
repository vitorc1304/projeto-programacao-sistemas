package br.edu.mackenzie.disciplinas.repository;

import br.edu.mackenzie.disciplinas.model.Disciplina;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class DisciplinaRepository {
    private final ConcurrentMap<Long, Disciplina> disciplinas = new ConcurrentHashMap<>();
    private final AtomicLong proximoId = new AtomicLong(1);

    public Disciplina salvar(Disciplina disciplina) {
        if (disciplina.getId() == null) {
            disciplina.setId(proximoId.getAndIncrement());
        }
        disciplinas.put(disciplina.getId(), disciplina);
        return disciplina;
    }

    public List<Disciplina> listarTodas() {
        return new ArrayList<>(disciplinas.values());
    }

    public Optional<Disciplina> buscarPorId(Long id) {
        return Optional.ofNullable(disciplinas.get(id));
    }

    public void excluir(Long id) {
        disciplinas.remove(id);
    }
}
