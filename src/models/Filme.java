package models;

import java.io.IOException;

import database.Connection;

public class Filme {
    private int idFilme;
    private String titulo;
    private int classificacao;
    private String status;
    private Genero genero;
    private Connection<Filme> connection;

    public Filme(int idFilme, String titulo, int classificacao, String status, Genero genero) {
        this.connection = new Connection<Filme>();
        this.titulo = titulo;
        this.genero = genero;
        this.idFilme = idFilme;
        this.status = status;
        this.classificacao = classificacao;
    }


    public boolean cadastrar()throws IOException{
        String novoFilme = this.getTitulo().toLowerCase() + ";" + this.getStatus().toLowerCase() + ";" + Integer.toString(this.getClassificacao()) + ";" + "genero" + ";" + Integer.toString(this.getIdFilme());

        if(this.connection.post(novoFilme, "filmes")){
            return true;
        }else{
            return false;
        }

    }



    public Filme() {
        this.connection = new Connection<>();
    }

    public Filme(int idFilme) {
        this.connection = new Connection<>();
        this.idFilme = idFilme;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public String getStatus() {
        return status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
