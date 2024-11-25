package models;

import database.*;
import java.io.IOException;
import java.time.LocalTime;

public class Funcionario extends Pessoa {
    private int matricula;
    private LocalTime horaTrabalho;
    private Connection<Funcionario> connection;

    public Funcionario(String nome, String cpf, String email, LocalTime horaTrabalho, int matricula) {
        this.horaTrabalho = horaTrabalho;
        this.matricula = matricula;
        this.connection = new Connection<>();
        super(nome, cpf, email);
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

        String novoFuncionario = Integer.toString(funcionario.getMatricula()).toLowerCase() + ";"
                + funcionario.getNome().toLowerCase() + ";" + funcionario.getCpf().toLowerCase() + ";"
                + funcionario.getEmail().toLowerCase() + ";" + funcionario.getHoraTrabalho();

        if (this.connection.put(novoFuncionario.toLowerCase(), "funcionarioes")) {
            return true;
        } else {
            return false;
        }
    }

    public void consultar(Funcionario funcionario) {
        // retorna Funcionario
    }

    public void listar() {
        // retorna ArrayList
    }

    // Encapsulamento - Getters/Setters
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setHoraTrabalho(LocalTime horaTrabalho) {
        this.horaTrabalho = horaTrabalho;
    }

    public LocalTime getHoraTrabalho() {
        return horaTrabalho;
    }

}
