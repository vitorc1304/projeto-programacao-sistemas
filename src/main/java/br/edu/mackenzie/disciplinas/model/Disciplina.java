
package br.edu.mackenzie.disciplinas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sigla;
    private String curso;
    private Integer semestre;

    public Disciplina(Long id, String nome, String sigla,
                      String curso, Integer semestre) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.curso = curso;
        this.semestre = semestre;
    }
}
