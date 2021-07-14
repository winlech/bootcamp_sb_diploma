package br.com.mercadolivre.diploma.Aluno.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SubjectDTO {

    @Size(min = 8, max = 50, message = "Nome da matéria deve ser maior que 8 e menor que 50 caracteres.")
    @Pattern(regexp = "^[A-Za-z_áàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]*$", message = "O nome da matéria deve ter somente caracteres de A-z")
    private String name;

    @DecimalMin("0")
    @DecimalMax("99")
    private int note;

    public SubjectDTO(String name) {
        this.name = name;
    }

    public SubjectDTO(String name, int note) {
        this.name = name;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
