package br.com.mercadolivre.diploma.Aluno.dto;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class StudentDTO {

    @Size(min=8, max=50, message = "Nome do aluno deve ser maior que 8 e menor que 50 caracteres." )
    @Pattern(regexp = "^[A-Za-z_ ]*$", message = "O nome do aluno deve ter somente caracteres de A-z")
    private String name;

    @Valid
    @Size(min = 1)
    private List<SubjectDTO> subjects;

    public StudentDTO() {
    }

    public StudentDTO(String name, List<SubjectDTO> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDTO> subjects) {
        this.subjects = subjects;
    }
}
