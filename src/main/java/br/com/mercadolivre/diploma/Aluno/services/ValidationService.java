package br.com.mercadolivre.diploma.Aluno.services;

import br.com.mercadolivre.diploma.Aluno.dto.ResponseDTO;
import br.com.mercadolivre.diploma.Aluno.dto.StudentDTO;
import br.com.mercadolivre.diploma.Aluno.dto.SubjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationService {

    public ResponseDTO execute(StudentDTO studentDTO) {
        double media = 0.0;
        String msg = "";

        media = calculateAverage(studentDTO.getSubjects());

        return writeDiploma(studentDTO, media);
    }

    public double calculateAverage(List<SubjectDTO> subjects) {
        double media;
        double soma;

        soma = subjects.stream()
                .mapToDouble(SubjectDTO::getNote).sum();
        media = soma / subjects.size();
        return media;
    }

    public ResponseDTO writeDiploma(StudentDTO studentDTO, double average) {
        return new ResponseDTO(studentDTO, average, "Sua media foi de " + average);
    }

    public boolean withHonors(double average) {
        return average > 9;
    }
}
