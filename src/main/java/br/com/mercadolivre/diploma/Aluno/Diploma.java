package br.com.mercadolivre.diploma.Aluno;

public class Diploma {

    private String nome;
    private double media;
    private String msg;

    public Diploma(String nome, double media, String msg) {
        this.nome = nome;
        this.media = media;
        this.msg = msg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
