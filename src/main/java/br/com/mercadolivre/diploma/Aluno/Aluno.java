package br.com.mercadolivre.diploma.Aluno;

import java.util.List;
import java.util.Map;

public class Aluno {

    private String nome;
    private List<Disciplina> disciplinas;

    public Aluno(String nome, List<Disciplina> disciplinas) {
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisplinas() {
        return disciplinas;
    }

    public void setDisplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
