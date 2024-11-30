package models;

import java.io.IOException;
import java.time.LocalDateTime;

import database.Connection;

public class Sessao {
    private int id;
    private String status;
    private Connection<Sessao> connection;
    private LocalDateTime dataHora;
    private Filme filme;
    private Sala sala;
    private Funcionario funcionario;

    public Sessao(Funcionario funcionario, Sala sala, Filme filme, int id, String status, LocalDateTime dataHora) {
        this.connection = new Connection<Sessao>();
        this.id = id;
        this.sala = sala;
        this.filme = filme;
        this.status = status;
        this.dataHora = dataHora;
        this.funcionario = funcionario;
    }

    public Sessao(int id){
        this.id = id;
        this.connection = new Connection<Sessao>();

    }

    public boolean cadastrar() throws IOException {
        String novaSessao =  Integer.toString(this.getId()) + ";" + "filme" + ";" + this.getStatus() + ";"
                + Integer.toString(this.getFuncionario().getMatricula()) + ";" + this.getDataHora() + ";" +  "sala";

        if (this.connection.post(novaSessao, "sessoes")) {
            return true;
        } else {
            return false;
        }

    }

    public Sessao consultar(Sessao sessao) throws IOException{
        try {
            String id = Integer.toString(sessao.getId());
            String s[] = this.connection.get(id, "sessoes");
            Funcionario f = new Funcionario(Integer.parseInt(s[3]));
            return new Sessao(f.consultar(f), new Sala(), new Filme(), getId(), s[0], LocalDateTime.parse(s[4]));
        } catch (Exception e) {
            System.out.println("Não existe na base de dados");
            return null;
        }
    }

    // Getter e Setter / Encapsulamento

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Filme getFilme() {
        return filme;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public int getId() {
        return id;
    }

    public Sala getSala() {
        return sala;
    }

    public String getStatus() {
        return status;
    }

}
