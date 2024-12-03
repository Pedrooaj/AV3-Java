package models;

import java.io.IOException;

import database.Connection;

public class Ingresso {
    private int id;
    private double valorPago;
    private SalaAssento salaAssento;
    private Sessao sessao;
    private Connection<Ingresso> connection;

    public Ingresso(int id, double valorPago, SalaAssento salaAssento, Sessao sessao) {
        this.id = id;
        this.valorPago = valorPago;
        this.salaAssento = salaAssento;
        this.sessao = sessao;
        this.connection = new Connection<Ingresso>();
    }

    public Ingresso(int id) {
        this.connection = new Connection<Ingresso>();
        this.id = id;
    }

    public Ingresso() {
        this.connection = new Connection<Ingresso>();
    }

    public boolean cadastrar() {
        try {
            String ingresso = Integer.toString(this.id) + ";" + Double.toString(this.valorPago) + ";"
                    + this.salaAssento.getId() + ";" + this.sessao.getId();
            return this.connection.post(ingresso.toLowerCase(), "ingresso");
        } catch (Exception e) {
            System.out.println("Erro ao Cadastrar Ingresso");
            return false;
        }
    }

    public Ingresso consultar(Ingresso ingresso) throws IOException {
        try {
            String id = Integer.toString(ingresso.getId());
            String tempIngresso[] = this.connection.get(id, "ingresso");
            SalaAssento salaAssento = new SalaAssento(Integer.parseInt(tempIngresso[2]));
            Sessao sessao = new Sessao(Integer.parseInt(tempIngresso[3]));
            return new Ingresso(Integer.parseInt(tempIngresso[0]), Double.parseDouble(tempIngresso[1]),salaAssento.consultar(salaAssento), sessao.consultar(sessao));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Não existe na base de dados");
            return null;
        }
    }

    public boolean editar(Ingresso ingresso) {
        try {
            String i = Integer.toString(ingresso.getId()) + ";" + Double.toString(ingresso.getValorPago()) + ";"
                    + Integer.toString(ingresso.getSalaAssento().getId()) + ";"
                    + Integer.toString(ingresso.getSessao().getId());
            return this.connection.put(i.toLowerCase(), "ingresso");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao editar Ingresso");
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public SalaAssento getSalaAssento() {
        return salaAssento;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalaAssento(SalaAssento salaAssento) {
        this.salaAssento = salaAssento;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

}
