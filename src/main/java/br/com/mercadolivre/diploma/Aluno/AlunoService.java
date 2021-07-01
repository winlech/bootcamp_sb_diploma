package br.com.mercadolivre.diploma.Aluno;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AlunoService {

    public Diploma getDiploma(Aluno aluno) {
        double soma;
        double media = 0.0;
        String msg = "";

        soma = aluno.getDisplinas().stream().mapToDouble(Disciplina::getNota).sum();

        if (soma > 0.0)
            media = soma / aluno.getDisplinas().size();
        if (media > 9)
            msg = "Parabéns";

        return new Diploma(aluno.getNome(), media, msg);
    }
}
