package models;

import java.io.IOException;
import java.util.ArrayList;

import database.Connection;

public class Sala {
    private Connection<Sala> connection;
    private int capacidade;
    private String descricao;
    private String status;
    private int id;

    public Sala(int id, int capacidade, String descricao, String status) {
        this.connection = new Connection<Sala>();
        this.capacidade = capacidade;
        this.id = id;
        this.descricao = descricao;
        this.status = status;

    }

    public Sala(int id) {
        this.connection = new Connection<Sala>();
        this.id = id;

    }

    public Sala() {
        this.connection = new Connection<Sala>();
    }

    public boolean cadastrar() throws IOException {
        try {
            String novaSala = Integer.toString(this.id) + ";" + Integer.toString(this.capacidade) + ";" + this.status
                    + ";"
                    + this.descricao;

            return this.connection.post(novaSala.toLowerCase(), "salas");
        } catch (Exception e) {
            System.out.println("Erro ao Cadastrar Sala");
            return false;
        }

    }

    public Sala consultar(Sala sala) throws IOException {
        try {
            String id = Integer.toString(sala.getId());
            String s[] = this.connection.get(id, "salas");
            return new Sala(Integer.parseInt(s[0]), Integer.parseInt(s[1]), s[3], s[2]);
        } catch (NullPointerException e) {
            System.out.println("Não existe na base de dados");
            return null;
        }
    }

    public boolean editar(Sala sala) throws IOException {
        try {
            String novaSala = Integer.toString(sala.getId()) + ";" + Integer.toString(sala.getCapacidade()) + ";"
            + sala.getStatus() + ";" + sala.getDescricao();
    return this.connection.put(novaSala.toLowerCase(), "salas");
        } catch (Exception e) {
            System.out.println("Erro ao editar Sala");
            return false;
        }

    }

    public ArrayList<Sala> listar() throws IOException {
        try {
            ArrayList<String> stringSala = this.connection.getAll("salas");
            ArrayList<Sala> salas = new ArrayList<>();

            for (String s : stringSala) {
                String[] tempSala = s.split(";");
                Sala a = new Sala(Integer.parseInt(tempSala[0]), Integer.parseInt(tempSala[1]), tempSala[3],
                        tempSala[2]);
                salas.add(a);
            }

            return salas;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro ao obter os dados");
            throw e;
        }
    }
    // Getters & Setters

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCapacidade() {
        return capacidade;
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

}
