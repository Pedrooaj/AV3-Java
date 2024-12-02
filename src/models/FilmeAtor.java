package models;

import java.io.IOException;
import java.util.ArrayList;

import database.Connection;

public class FilmeAtor {
    private int id;
    private Ator ator;
    private Filme filme;
    private String personagem;
    private boolean principal;
    private Connection<FilmeAtor> connection;

    public FilmeAtor(int id, Ator ator, Filme filme, String personagem, boolean principal) {
        this.connection = new Connection<FilmeAtor>();
        this.id = id;
        this.ator = ator;
        this.filme = filme;
        this.personagem = personagem;
        this.principal = principal;
    }

    public FilmeAtor(int id){
        this.id = id;
        this.connection = new Connection<FilmeAtor>();
    }

    public FilmeAtor(){
        this.connection = new Connection<FilmeAtor>();
    }

    public boolean cadastrar() {
        try {
            String novoFilmeAtor = Integer.toString(this.id) + ";" + this.ator.getRegistro() + ";"
                    + this.filme.getIdFilme() + ";" + this.personagem
                    + ";" + this.principal;
            return this.connection.post(novoFilmeAtor, "filmeAtores");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar na base de Dados");
            return false;
        }
    }

    public boolean editar(FilmeAtor filme) {
        try {
            String novoFilmeAtor = Integer.toString(filme.getId()) + ";" + filme.getAtor().getRegistro() + ";"
                    + filme.getFilme().getIdFilme()
                    + filme.getPersonagem() + ";" + filme.getPrincipal();
            return this.connection.put(novoFilmeAtor, "filmeAtores");
        } catch (Exception e) {
            System.out.println("Erro ao Editar Filme");
            return false;
        }
    }

    public FilmeAtor consultar(FilmeAtor filme) throws IOException {
        try {
            String id = Integer.toString(filme.getId());
            String[] f = this.connection.get(id, "filmeAtores");
            Ator ator = new Ator(Integer.parseInt(f[1]));
            Filme fi = new Filme(Integer.parseInt(f[2]));
            return new FilmeAtor(Integer.parseInt(f[0]), ator.consultar(ator), fi.consultar(fi), f[3],
                    Boolean.parseBoolean(f[4]));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Não existe na base de dados");
            return null;
        }
    }

    public ArrayList<FilmeAtor> listar() throws IOException {
        try {
            ArrayList<String> stringFilmes = this.connection.getAll("filmeAtores");
            ArrayList<FilmeAtor> filmes = new ArrayList<>();

            for (String filme : stringFilmes) {
                String[] f = filme.split(";");
                Ator ator = new Ator(Integer.parseInt(f[1]));
                Filme fi = new Filme(Integer.parseInt(f[2]));
                FilmeAtor a = new FilmeAtor(Integer.parseInt(f[0]), ator.consultar(ator), fi.consultar(fi), f[3],Boolean.parseBoolean(f[4]));
                filmes.add(a);
            }

            return filmes;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro ao obter os dados");
            throw e;
        }
    }

    // Getters & Setters

    public Ator getAtor() {
        return ator;
    }

    public int getId() {
        return id;
    }

    public String getPersonagem() {
        return personagem;
    }

    public boolean getPrincipal() {
        return this.principal;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPersonagem(String personagem) {
        this.personagem = personagem;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

}
