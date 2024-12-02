package models;

import java.io.IOException;
import java.util.ArrayList;

import database.Connection;

public class Genero {
    private int id;
    private String descricao;
    private String status;
    private Connection<Genero> connection;

    public Genero(int id, String descricao, String status) {
        this.connection = new Connection<Genero>();
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public Genero(int id) {
        this.connection = new Connection<Genero>();
        this.id = id;
    }

    public Genero() {
        this.connection = new Connection<Genero>();
    }

    public boolean cadastrar() {
        try {
            String novoGenero = this.id + ";" + this.descricao + ";" + this.status;
            return this.connection.post(novoGenero, "generos");
        } catch (Exception e) {
            System.out.println("Erro ao Cadastrar Gênero");
            return false;
        }
    }

    public boolean editar(Genero genero) {
        try {
            String novoGenero = Integer.toString(genero.getId()) + ";" + genero.getDescricao() + ";"
                    + genero.getStatus();

            return this.connection.put(novoGenero, "generos");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar na base de dados");
            return false;
        }
    }

    public Genero consultar(Genero genero) throws IOException {
        try {
            String id = Integer.toString(genero.getId());
            String[] g = this.connection.get(id, "generos");
            return new Genero(Integer.parseInt(g[0]), g[1], g[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Não existe na base de dados");
            return null;
        }
    }

    public ArrayList<Genero> listar() throws IOException {
        try {
            ArrayList<String> stringGeneros = this.connection.getAll("generos");
            ArrayList<Genero> generos = new ArrayList<>();

            for (String g : stringGeneros) {
                String[] tempGenero = g.split(";");
                Genero genero = new Genero(Integer.parseInt(tempGenero[0]), tempGenero[1],tempGenero[2]);
                generos.add(genero);
            }

            return generos;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro ao obter os dados");
            throw e;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

}
