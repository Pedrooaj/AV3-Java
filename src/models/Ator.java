package models;

import java.io.IOException;
import java.util.ArrayList;

import database.Connection;

public class Ator extends Pessoa {
    private int registro;
    private Connection<Ator> connection;

    public Ator(String nome, String cpf, String email, int registro) {
        this.registro = registro;
        super(nome, cpf, email);
        this.connection = new Connection<Ator>();
    }

    public Ator() {
        this.connection = new Connection<Ator>();
    }

    public Ator(int registro) {
        this.registro = registro;
        this.connection = new Connection<Ator>();
    }

    // Métodos da classe
    public boolean cadastrar() throws IOException {
        String novoAtor = Integer.toString(this.registro) + ";" + this.getNome()+ ";"
                + this.getCpf() + ";" + this.getEmail();
        if (this.connection.post(novoAtor, "atores")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean editar(Ator ator) throws IOException {
        String novoAtor = Integer.toString(ator.getRegistro()) + ";" + ator.getNome() + ";" + ator.getCpf() + ";" + ator.getEmail();

        if (this.connection.put(novoAtor.toLowerCase(), "atores")) {
            return true;
        } else {
            return false;
        }
    }

    public Ator consultar(Ator ator) throws IOException {
        try {
            String id = Integer.toString(ator.getRegistro()).toLowerCase();
            String[] a = this.connection.get(id, "atores");
            return new Ator(a[1], a[2], a[3], Integer.parseInt(a[0]));
        } catch (Exception e) {
            System.out.println("Não existe na base de dados");
            return null;
        }

    }

    public ArrayList<Ator> listar() throws IOException {
        try {
            ArrayList<String> stringAtores = this.connection.getAll("atores");
            ArrayList<Ator> atores = new ArrayList<>();

            for (String ator : stringAtores) {
                String[] tempAtor = ator.split(";");
                Ator a = new Ator(tempAtor[3], tempAtor[1], tempAtor[2], Integer.parseInt(tempAtor[0]));
                atores.add(a);
            }

            return atores;
        } catch (Exception e) {
            System.out.println("Erro ao obter os dados");
            throw e;
        }

    }

    // Encapsulamento - Getters/Setters

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public int getRegistro() {
        return registro;
    }

}
