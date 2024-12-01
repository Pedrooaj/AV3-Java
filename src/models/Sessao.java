package models;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

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

    public Sessao(){
        this.connection = new Connection<Sessao>();
    }

    public boolean cadastrar() throws IOException {
        String novaSessao =  Integer.toString(this.getId()) + ";" + "filme" + ";" + this.getStatus() + ";"
                + Integer.toString(this.getFuncionario().getMatricula()) + ";" + this.getDataHora() + ";" + Integer.toString(this.getSala().getId());

        return this.connection.post(novaSessao.toLowerCase(), "sessoes");

    }

    public Sessao consultar(Sessao sessao) throws IOException{
        try {
            String id = Integer.toString(sessao.getId());
            String tempSessao[] = this.connection.get(id, "sessoes");
            Funcionario funcionario = new Funcionario(Integer.parseInt(tempSessao[3]));
            Sala sala = new Sala(Integer.parseInt(tempSessao[5]));
            return new Sessao(funcionario.consultar(funcionario), sala.consultar(sala), new Filme(), getId(), tempSessao[2], LocalDateTime.parse(tempSessao[4]));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Não existe na base de dados");
            return null;
        }
    }

    public boolean editar(Sessao sessao) throws IOException{
        String novaSessao =  Integer.toString(sessao.getId()) + ";" + "filme" + ";" + sessao.getStatus() + ";" + Integer.toString(sessao.getFuncionario().getMatricula()) + ";" + sessao.getDataHora() + ";" +  "sala";
        return this.connection.put(novaSessao.toLowerCase(), "sessoes");
    } 


    public ArrayList<Sessao> listar()throws IOException{
        try {
            ArrayList<String> stringSessao = this.connection.getAll("sessoes");
            ArrayList<Sessao> sessoes = new ArrayList<>();

            for (String sessao : stringSessao) {
                String[] tempSessao = sessao.split(";");
                Funcionario funcionario = new Funcionario(Integer.parseInt(tempSessao[3]));
                Sala sala = new Sala(Integer.parseInt(tempSessao[5]));
                
                Sessao a = new Sessao(funcionario.consultar(funcionario), sala.consultar(sala), new Filme(), Integer.parseInt(tempSessao[0]), tempSessao[2], LocalDateTime.parse(tempSessao[4]));
                sessoes.add(a);
            }

            return sessoes;
        } catch (Exception e) {
            System.out.println("Erro ao obter os dados");
            throw e;
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
