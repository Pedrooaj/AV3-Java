package frontend;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

import models.Ator;
import models.Funcionario;

public class Index {
    private Scanner scanner;

    public Index(){
        this.scanner = new Scanner(System.in);
    }

    public void iniciarMenu() throws IOException {
        while (true) {
            System.out.println("\nSeja Bem Vindo há aplicação de Pedrooaj!");
            System.out.println("----------------------------------------");
            System.out.println("1 - Atores");
            System.out.println("2 - Funcionarios ");
            System.out.println("3 - Dúvidas");
            System.out.println("0 - Sair");
            String escolha = this.scanner.nextLine();

            // menu de atores
            if (escolha.equals("1")) {
                this.MenuAtores();
            }

            // menu de funcionarios
            if (escolha.equals("2")) {
                this.MenuFuncinarios();
            }
            if(escolha.equals("3")){
                this.Duvidas();
            }

            if (escolha.equals("0")) {
                this.scanner.close();
                break;
            }

        

        }
    }

    public void MenuAtores() throws IOException{
        while (true) {
            System.out.println("\nMenu de Atores:");
            System.out.println("----------------------------------------");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Editar");
            System.out.println("3 - Consultar");
            System.out.println("4 - Listar");
            System.out.println("0 - Voltar");
            System.out.println("----------------------------------------");
            String escolha = this.scanner.nextLine();

            if(escolha.equals("0")){
                break;
            }
            if(escolha.equals("1")){
                System.out.println("Registrando ator");
                System.out.println("----------------------------------------");
                System.out.println("Digite o nome do Ator");
                String nome = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("Digite o CPF do Ator");
                String cpf = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("Digite o email do Ator");
                String email = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("Digite o Registro/Identificador");
                int registro = this.scanner.nextInt();
                System.out.println("----------------------------------------");
                this.scanner.nextLine(); // consome a linha
                
                Ator ator = new Ator(nome, cpf, email, registro);
                ator.cadastrar();
            }

            if(escolha.equals("2")){
                String id;
                System.out.println("Editando ator");
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Identificador/Id que deseja editar:");
                    id = this.scanner.nextLine();
                    if(id.matches("\\d+")){
                        break;
                    }else{
                        System.out.println("Id válidos contem somente números!");
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Nome do Ator");
                String nome = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("CPF do Ator");
                String cpf = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("Email do ator");
                String email = this.scanner.nextLine();
            
                Ator ator = new Ator(nome, cpf, email, Integer.parseInt(id));
                ator.editar(ator);
            }

            if(escolha.equals("3")){
                System.out.println("Consultando ator");
                System.out.println("----------------------------------------");
                System.out.println("Digite o Identificador que deseja consultar: ");
                String id = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                Ator ator = new Ator(Integer.parseInt(id));
                Ator info = ator.consultar(ator);
                System.out.println("----------------------------------------");
                if(info != null){
                    System.out.println("Ator encontrado");
                    System.out.println(info.getNome());
                    System.out.println(info.getCpf());
                    System.out.println(info.getEmail());
                }
            }

            if(escolha.equals("4")){
                System.out.println("\nLista de Atores");
                System.out.println("----------------------------------------");
                Ator atores = new Ator();

                for(Ator ator : atores.listar()){
                    System.out.println("Registro " + ator.getRegistro());
                    System.out.println("Nome " + ator.getNome());
                    System.out.println("CPF " + ator.getCpf());
                    System.out.println("Email " + ator.getEmail());
                    System.out.println("----------------------------------------");
                }
   
            }

        }
    }

    public void MenuFuncinarios() {
        while (true) {
            System.out.println("Menu de Funcionarios: ");
            System.out.println("----------------------------------------");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Editar");
            System.out.println("3 - Consultar");
            System.out.println("4 - Listar");
            System.out.println("0 - Voltar");
            System.out.println("----------------------------------------");
            String escolha = this.scanner.nextLine();

            if(escolha.equals("0")){
                break;
            }
            if(escolha.equals("1")){
                System.out.println("Registrando Funcionario");
                System.out.println("----------------------------------------");
                System.out.println("Nome do funcionario");
                String nome = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("CPF do funcionario");
                String cpf = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("Email do funcionario");
                String email = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("Jornada de trabalho");
                String horas = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("Mátricula/Identificador do funcionario");
                String matricula = this.scanner.nextLine();

                

                //Funcionario funcionario = new Funcionario(nome, cpf, email, horas, Integer.parseInt(matricula));
          
                
            }
        }
    }

    public void Duvidas(){
        while (true) {
            System.out.println("Dúvidas");
            System.out.println("----------------------------------------");
            System.out.println("Quaisquer dúvidas relacionada a este projeto ou algum outro entre em contato\nEmail: pedroantonio5735@gmail.com");
            System.out.println("Digite qualquer coisa para sair");
            this.scanner.nextLine();
            break;
        }
    }
}
