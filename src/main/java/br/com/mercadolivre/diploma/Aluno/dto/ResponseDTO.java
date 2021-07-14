package br.com.mercadolivre.diploma.Aluno.dto;

public class ResponseDTO {

    private String message;
    private double average;
    private StudentDTO studentDTO;

    public ResponseDTO(String message) {
        this.message = message;
    }

    public ResponseDTO(StudentDTO studentDTO, double average, String message) {
        this.message = message;
        this.average = average;
        this.studentDTO = studentDTO;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "message='" + message + '\'' +
                ", average=" + average +
                ", studentDTO=" + studentDTO +
                '}';
    }
}
