package models;

import database.*;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

public class Funcionario extends Pessoa {
    private int matricula;
    private LocalTime horaTrabalho;
    private Connection<Funcionario> connection;

    public Funcionario(String nome, String cpf, String email, LocalTime horaTrabalho, int matricula) {
        this.horaTrabalho = horaTrabalho;
        this.matricula = matricula;
        this.connection = new Connection<Funcionario>();
        super(nome, cpf, email);
    }

    public Funcionario(int matricula) {
        this.matricula = matricula;
        this.connection = new Connection<Funcionario>();
    }

    public Funcionario(){
        this.connection = new Connection<Funcionario>();
    }

    // Métodos da classe

    public boolean cadastrar() throws IOException {
        String novoFuncionario = Integer.toString(matricula) + ";" + getNome() + ";" + getCpf() + ";" + getEmail() + ";"
                + getHoraTrabalho();
        if (this.connection.post(novoFuncionario, "funcionarios")) {
            return true;
        } else {
            return false;
        }

    }

    public boolean editar(Funcionario funcionario) throws IOException {

        String novoFuncionario = Integer.toString(funcionario.getMatricula()) + ";"
                + funcionario.getNome()+ ";" + funcionario.getCpf() + ";"
                + funcionario.getEmail() + ";" + funcionario.getHoraTrabalho();

        if (this.connection.put(novoFuncionario, "funcionarios")) {
            return true;
        } else {
            return false;
        }
    }

    public Funcionario consultar(Funcionario funcionario) throws IOException {
        try {
            String id = Integer.toString(funcionario.getMatricula()).toLowerCase();
            String[] a = this.connection.get(id, "funcionarios");
            return new Funcionario(a[1], a[2], a[3], LocalTime.parse(a[4]), Integer.parseInt(a[0]));
        } catch (Exception e) {
            System.out.println("Não existe na base de dados");
            return null;
        }
    }

    public ArrayList<Funcionario> listar() throws IOException{
        try {
            ArrayList<String> stringFuncionarios = this.connection.getAll("funcionarios");
            ArrayList<Funcionario> funcionarios = new ArrayList<>();

            for (String f : stringFuncionarios) {
                String[] tempFuncionario = f.split(";");
                Funcionario funcionario = new Funcionario(tempFuncionario[1],tempFuncionario[2],tempFuncionario[3] , LocalTime.parse(tempFuncionario[4]), Integer.parseInt(tempFuncionario[0]));
                funcionarios.add(funcionario);
            }
 
            return funcionarios;
        } catch (Exception e) {
            System.out.println("Erro ao obter os dados");
            throw e;
        }
    }

    // Encapsulamento - Getters/Setters
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void setHoraTrabalho(LocalTime horaTrabalho) {
        this.horaTrabalho = horaTrabalho;
    }

    public LocalTime getHoraTrabalho() {
        return horaTrabalho;
    }

}
