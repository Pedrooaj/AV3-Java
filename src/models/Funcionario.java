package models;
import database.*;

import java.io.IOException;
import java.util.*;


public class Funcionario extends Pessoa {
    private int matricula;
    private Date horaTrabalho;
    private Connection<Funcionario> connection;

    public Funcionario(String nome, String cpf, String email, Date horaTrabalho, int matricula) {
        this.horaTrabalho = horaTrabalho;
        this.matricula = matricula;
        this.connection = new Connection<>();
       super(nome, cpf, email);
    }

    // Métodos da classe

    public boolean cadastrar(Funcionario funcionario) throws IOException{
        String novoFuncionario = Integer.toString(matricula) + ";" + getNome() + ";" + getCpf() + ";" + getEmail() + ";" + getHoraTrabalho();
        if (this.connection.post(novoFuncionario, "funcionarios")) {
            return true;
        } else {
            return false;
        }
        
    }

    public void editar(Funcionario funcionario){
        // retorna booleano
    }

    public void consultar(Funcionario funcionario){
        // retorna Funcionario
    }

    public void listar(){
        // retorna ArrayList
    }


    // Encapsulamento - Getters/Setters
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setHoraTrabalho(Date horaTrabalho) {
        this.horaTrabalho = horaTrabalho;
    }

    public Date getHoraTrabalho() {
        return horaTrabalho;
    }

}
