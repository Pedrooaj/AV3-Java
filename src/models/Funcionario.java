package models;
import java.util.*;


public class Funcionario extends Pessoa {
    private int matricula;
    private Date horaTrabalho;

    public Funcionario(String nome, String cpf, String email, int registro, Date horaTrabalho, int matricula) {
        this.horaTrabalho = horaTrabalho;
        this.matricula = matricula;
        super(nome, cpf, email);
    }

    // Métodos da classe

    public void cadastrar(Funcionario funcionario){
        // Retorna booleano
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
