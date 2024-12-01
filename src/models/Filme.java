package models;

import java.io.IOException;
import java.util.ArrayList;

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

    public Filme() {
        this.connection = new Connection<>();
    }

    public Filme(int idFilme) {
        this.connection = new Connection<>();
        this.idFilme = idFilme;
    }

    public boolean cadastrar() throws IOException {
        try {
            String novoFilme = Integer.toString(this.getIdFilme()) + ";" + this.getTitulo() + ";" + this.getStatus()
                    + ";"
                    + this.getGenero().getId() + ";" + Integer.toString(this.getClassificacao());
            return this.connection.post(novoFilme, "filmes");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar na base de Dados");
            return false;
        }
    }

    public boolean editar(Filme filme) throws IOException {
        try {
            String novoFilme = filme.getIdFilme() + ";" + filme.getTitulo() + ";" + filme.getStatus() + ";" + filme.getGenero().getId() + ";"
                    + filme.getClassificacao();
            return this.connection.put(novoFilme, "filmes");
        } catch (Exception e) {
            System.out.println("Erro ao Editar Filme");
            return false;
        }
    }

    public Filme consultar(Filme filme) throws IOException {
        try {
            String id = Integer.toString(filme.getIdFilme());
            String[] f = this.connection.get(id, "filmes");
            Genero genero = new Genero(Integer.parseInt(f[3]));
            return new Filme(Integer.parseInt(f[0]), f[1], Integer.parseInt(f[4]), f[3], genero.consultar(genero));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Não existe na base de dados");
            return null;
        }
    }

    public ArrayList<Filme> listar() throws IOException {
        try {
            ArrayList<String> stringFilmes = this.connection.getAll("filmes");
            ArrayList<Filme> filmes = new ArrayList<>();

            for (String filme : stringFilmes) {
                String[] f = filme.split(";");
                Genero genero = new Genero(Integer.parseInt(f[3]));
                Filme a = new Filme(Integer.parseInt(f[0]), f[1], Integer.parseInt(f[4]),f[2], genero.consultar(genero));
                filmes.add(a);
            }

            return filmes;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro ao obter os dados");
            throw e;
        }

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
