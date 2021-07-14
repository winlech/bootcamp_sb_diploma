package br.com.mercadolivre.diploma.Aluno.services;

import br.com.mercadolivre.diploma.Aluno.entities.Disciplina;
import br.com.mercadolivre.diploma.Aluno.entities.Aluno;
import br.com.mercadolivre.diploma.Aluno.entities.Diploma;
import org.springframework.stereotype.Service;

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
