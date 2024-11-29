package frontend;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import models.Ator;
import models.Funcionario;

public class Index {
    private Scanner scanner;

    public Index() {
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
            if (escolha.equals("3")) {
                this.Duvidas();
            }

            if (escolha.equals("0")) {
                this.scanner.close();
                break;
            }

        }
    }

    public void MenuAtores() throws IOException {
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

            if (escolha.equals("0")) {
                break;
            }
            if (escolha.equals("1")) {
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

            if (escolha.equals("2")) {
                String id;
                System.out.println("Editando ator");
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Identificador/Id que deseja editar:");
                    id = this.scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
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

            if (escolha.equals("3")) {
                System.out.println("Consultando ator");
                System.out.println("----------------------------------------");
                System.out.println("Digite o Identificador que deseja consultar: ");
                String id = this.scanner.nextLine();
                Ator ator = new Ator(Integer.parseInt(id));
                Ator info = ator.consultar(ator);
                System.out.println("----------------------------------------");
                if (info != null) {
                    System.out.println("Ator encontrado");
                    System.out.println(info.getNome());
                    System.out.println(info.getCpf());
                    System.out.println(info.getEmail());
                }
                System.out.println("----------------------------------------");
            }

            if (escolha.equals("4")) {
                System.out.println("\nLista de Atores");
                System.out.println("----------------------------------------");
                Ator atores = new Ator();

                if(atores != null){
                    for (Ator ator : atores.listar()) {
                        System.out.println("Registro " + ator.getRegistro());
                        System.out.println("Nome " + ator.getNome());
                        System.out.println("CPF " + ator.getCpf());
                        System.out.println("Email " + ator.getEmail());
                        System.out.println("----------------------------------------");
                    }
                }
            }

        }
    }

    public void MenuFuncinarios()throws IOException {
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

            if (escolha.equals("0")) {
                break;
            }
            if (escolha.equals("1")) {
                LocalTime horas;
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
                while (true) {
                    System.out.println("Jornada de trabalho hh:mm:ss");
                    String timeInput = this.scanner.nextLine();

                    if (timeInput.matches("^([01][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$")) {
                        try {

                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                            horas = LocalTime.parse(timeInput, formatter);
                            break;
                        } catch (Exception e) {
                            System.out.println("Erro ao processar o horário.");
                        }
                    } else {
                        System.out.println("Formato de horas inválido. Tente novamente!");
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Matricula/Identificador do funcionario");
                String matricula = this.scanner.nextLine();

                Funcionario funcionario = new Funcionario(nome, cpf, email, horas, Integer.parseInt(matricula));
                funcionario.cadastrar();
            }else if(escolha.equals("2")){
                String id;
                LocalTime horas;
                System.out.println("Editando Funcionario");
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Matricula/Identificador que deseja editar:");
                    id = this.scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("Id válidos contem somente números!");
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Nome do Funcionario");
                String nome = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("CPF do Funcionario");
                String cpf = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("Email do Funcionario");
                String email = this.scanner.nextLine();
                while (true) {
                    System.out.println("----------------------------------------");
                    System.out.println("Jornada de trabalho hh:mm:ss");
                    String timeInput = this.scanner.nextLine();

                    if (timeInput.matches("^([01][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$")) {
                        try {

                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                            horas = LocalTime.parse(timeInput, formatter);
                            break;
                        } catch (Exception e) {
                            System.out.println("Erro ao processar o horário.");
                        }
                    } else {
                        System.out.println("Formato de horas inválido. Tente novamente!");
                    }
                }
                Funcionario funcionario = new Funcionario(nome, cpf, email, horas, Integer.parseInt(id));
                funcionario.editar(funcionario);
            }else if(escolha.equals("3")){
                System.out.println("Consultando funcionario");
                System.out.println("----------------------------------------");
                System.out.println("Digite o Matricula/Id que deseja consultar: ");
                String id = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                Funcionario funcionario = new Funcionario(Integer.parseInt(id));
                Funcionario consulta = funcionario.consultar(funcionario);

                if (consulta != null) {
                    System.out.println("Ator encontrado");
                    System.out.println(consulta.getNome());
                    System.out.println(consulta.getCpf());
                    System.out.println(consulta.getEmail());
                    System.out.println(consulta.getMatricula());
                    System.out.println(consulta.getHoraTrabalho());
                }
                System.out.println("----------------------------------------");
            }else if(escolha.equals("4")){
                System.out.println("\nLista de Funcionarios");
                System.out.println("----------------------------------------");
                Funcionario funcionarios = new Funcionario();
                if(funcionarios != null){
                    for (Funcionario f : funcionarios.listar()) {
                        System.out.println("Matricula " + f.getMatricula());
                        System.out.println("Nome " + f.getNome());
                        System.out.println("CPF " + f.getCpf());
                        System.out.println("Email " + f.getEmail());
                        System.out.println("Horas " + f.getHoraTrabalho());
                        System.out.println("----------------------------------------");
                    }
                }

            }
        }
    }

    public void Duvidas() {
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println(
                    "Quaisquer dúvidas relacionada a este projeto ou algum outro entre em contato\nEmail: pedroantonio5735@gmail.com");
            System.out.println("Digite qualquer coisa para sair");
            this.scanner.nextLine();
            break;
        }
    }
}
