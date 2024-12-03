package models;

import java.io.IOException;
import java.util.ArrayList;

import database.Connection;

public class Assento {
    private int id;
    private TipoAssento tipoAssento;
    private Connection<Assento> connection;

    public Assento(int id, TipoAssento tipoAssento) {
        this.id = id;
        this.tipoAssento = tipoAssento;
        this.connection = new Connection<Assento>();
    }

    public Assento(int id) {
        this.id = id;
        this.connection = new Connection<Assento>();
    }

    public Assento() {
        this.connection = new Connection<Assento>();
    }

    public boolean cadastrar() {
        try {
            String novoTipoAssento = Integer.toString(this.id) + ";" + this.tipoAssento.getId();
            return this.connection.post(novoTipoAssento.toLowerCase(), "assento");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao cadastrar Assento");
            return false;
        }
    }

    public boolean editar(Assento assento) {
        try {
            String novoTipoAssento = Integer.toString(assento.getId()) + ";" + assento.getTipoAssento().getId();
            return this.connection.put(novoTipoAssento.toLowerCase(), "assento");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao editar Assento");
            return false;
        }
    }

    public Assento consultar(Assento assento) throws IOException {
        try {
            String id = Integer.toString(assento.getId());
            String tempAssento[] = this.connection.get(id, "assento");
            TipoAssento tipoAssento = new TipoAssento(Integer.parseInt(tempAssento[1]));
            return new Assento(Integer.parseInt(tempAssento[0]), tipoAssento.consultar(tipoAssento));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Não existe na base de dados");
            return null;
        }
    }

    public ArrayList<Assento> listar() throws IOException {
        try {
            ArrayList<String> stringAssento = this.connection.getAll("assento");
            ArrayList<Assento> assentos = new ArrayList<>();

            for (String assento : stringAssento) {
                String[] tempAssento = assento.split(";");
                TipoAssento tipoAssento = new TipoAssento(Integer.parseInt(tempAssento[1]));
                Assento a = new Assento(Integer.parseInt(tempAssento[0]), tipoAssento.consultar(tipoAssento));
                assentos.add(a);
            }

            return assentos;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro ao obter os dados");
            throw e;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipoAssento(TipoAssento tipoAssento) {
        this.tipoAssento = tipoAssento;
    }

    public int getId() {
        return id;
    }

    public TipoAssento getTipoAssento() {
        return tipoAssento;
    }
}
