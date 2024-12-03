package models;

import java.io.IOException;
import java.util.ArrayList;

import database.Connection;

public class SalaAssento {
    private int id;
    private Assento assento;
    private Sala sala;
    private Connection<SalaAssento> connection;

    public SalaAssento(int id, Assento assento, Sala sala) {
        this.id = id;
        this.sala = sala;
        this.assento = assento;
        this.connection = new Connection<SalaAssento>();
    }

    public SalaAssento(int id) {
        this.id = id;
        this.connection = new Connection<SalaAssento>();
    }

    public SalaAssento() {
        this.connection = new Connection<SalaAssento>();
    }

    public boolean cadastrar() {
        try {
            String novaSala = Integer.toString(this.id) + ";" + this.assento.getId() + ";" + this.sala.getId();
            return this.connection.post(novaSala.toLowerCase(), "salaAssento");
        } catch (Exception e) {
            System.out.println("Erro ao Cadastrar Sala-Assento");
            return false;
        }
    }

    public boolean editar(SalaAssento sala) {
        try {
            String novaSala = Integer.toString(sala.getId()) + ";" + Integer.toString(sala.getAssento().getId()) + ";" + Integer.toString(sala.getSala().getId()) ;
            return this.connection.put(novaSala.toLowerCase(), "salaAssento");
        } catch (Exception e) {
            System.out.println("Erro ao editar Sala");
            return false;
        }

    }

    public SalaAssento consultar(SalaAssento salaAssento) throws IOException {
        try {
            String id = Integer.toString(salaAssento.getId());
            String s[] = this.connection.get(id, "salaAssento");
            Assento assento = new Assento(Integer.parseInt(s[1]));
            Sala sala = new Sala(Integer.parseInt(s[2]));
            return new SalaAssento(Integer.parseInt(s[0]), assento.consultar(assento), sala.consultar(sala));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Não existe na base de dados");
            return null;
        }
    }

        public ArrayList<SalaAssento> listar() throws IOException {
        try {
            ArrayList<String> stringSala = this.connection.getAll("salaAssento");
            ArrayList<SalaAssento> salas = new ArrayList<>();

            for (String s : stringSala) {
                String[] tempSala = s.split(";");
                Assento assento = new Assento(Integer.parseInt(tempSala[1]));
                Sala sala = new Sala(Integer.parseInt(tempSala[2]));
                SalaAssento a = new SalaAssento(Integer.parseInt(tempSala[0]), assento.consultar(assento), sala.consultar(sala));
                salas.add(a);
            }

            return salas;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro ao obter os dados");
            throw e;
        }
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Assento getAssento() {
        return assento;
    }

    public int getId() {
        return id;
    }

    public Sala getSala() {
        return sala;
    }

}
