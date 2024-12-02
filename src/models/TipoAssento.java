package models;

import java.io.IOException;
import java.util.ArrayList;

import database.Connection;

public class TipoAssento {
    private int id;
    private String descricao;
    private String status;
    private Connection<TipoAssento> connection;

    public TipoAssento(int id, String descricao, String status) {
        this.id = id;
        this.status = status;
        this.descricao = descricao;
        this.connection = new Connection<TipoAssento>();
    }

    public TipoAssento(int id) {
        this.id = id;
        this.connection = new Connection<TipoAssento>();
    }

    public TipoAssento() {
        this.connection = new Connection<TipoAssento>();
    }

    public boolean cadastrar() {
        try {
            String novoTipoAssento = Integer.toString(this.id) + ";" +  this.descricao + ";" + this.status;
            return this.connection.post(novoTipoAssento.toLowerCase(), "tipoAssento");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao cadastrar Sessão");
            return false;
        }
    }

    public boolean editar(TipoAssento assento) {
        try {
            String novoTipoAssento = Integer.toString(assento.getId()) + ";" + assento.getDescricao() + ";" + assento.getStatus();
            return this.connection.put(novoTipoAssento.toLowerCase(), "tipoAssento");
        } catch (Exception e) {
            System.out.println("Erro ao editar Sessão");
            return false;
        }
    }

    public TipoAssento consultar(TipoAssento tipoAssento) throws IOException {
        try {
            String id = Integer.toString(tipoAssento.getId());
            String tempAssento[] = this.connection.get(id, "tipoAssento");
            return new TipoAssento(Integer.parseInt(tempAssento[0]),tempAssento[1],tempAssento[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Não existe na base de dados");
            return null;
        }
    }


        public ArrayList<TipoAssento> listar() throws IOException {
        try {
            ArrayList<String> stringAssento = this.connection.getAll("tipoAssento");
            ArrayList<TipoAssento> assentos = new ArrayList<>();

            for (String assento : stringAssento) {
                String[] tempAssento = assento.split(";");
                TipoAssento a = new TipoAssento(Integer.parseInt(tempAssento[0]),tempAssento[1],tempAssento[2]);
                assentos.add(a);
            }

            return assentos;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
