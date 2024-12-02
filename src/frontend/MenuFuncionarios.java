package frontend;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import models.Funcionario;

public class MenuFuncionarios {
     public void MenuFuncinarios(Scanner scanner) throws IOException {
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("Menu de Funcionarios: ");
            System.out.println("----------------------------------------");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Editar");
            System.out.println("3 - Consultar");
            System.out.println("4 - Listar");
            System.out.println("0 - Voltar");
            System.out.println("----------------------------------------");
            String escolha = scanner.nextLine();

            if (escolha.equals("0")) {
                break;
            }
            if (escolha.equals("1")) {
                LocalTime horas;
                String matricula;
                System.out.println("----------------------------------------");
                System.out.println("Registrando Funcionario");
                System.out.println("----------------------------------------");
                System.out.println("Nome do funcionario");
                String nome = scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("CPF do funcionario");
                String cpf = scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("Email do funcionario");
                String email = scanner.nextLine();
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Jornada de trabalho hh:mm:ss");
                    String timeInput = scanner.nextLine();

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
                while (true) {
                    try {
                        System.out.println("Matricula/Identificador do Funcionario:");
                        matricula = scanner.nextLine();
                        if (matricula.matches("\\d+")) {
                            break;
                        } else {
                            System.out.println("Id válidos contem somente números!");
                        }

                    } catch (NumberFormatException e) {
                        throw e;
                    }

                }

                Funcionario funcionario = new Funcionario(nome, cpf, email, horas, Integer.parseInt(matricula));
                funcionario.cadastrar();
            } else if (escolha.equals("2")) {
                String id;
                LocalTime horas;
                System.out.println("----------------------------------------");
                System.out.println("Editando Funcionario");
                System.out.println("----------------------------------------");
                while (true) {
                    try {
                        System.out.println("Matricula/Identificador que deseja editar:");
                        id = scanner.nextLine();
                        if (id.matches("\\d+")) {
                            break;
                        } else {
                            System.out.println("Id válidos contem somente números!");
                        }

                    } catch (NumberFormatException e) {
                        throw e;
                    }

                }
                System.out.println("----------------------------------------");
                System.out.println("Nome do Funcionario");
                String nome = scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("CPF do Funcionario");
                String cpf = scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("Email do Funcionario");
                String email = scanner.nextLine();
                while (true) {
                    System.out.println("----------------------------------------");
                    System.out.println("Jornada de trabalho hh:mm:ss");
                    String timeInput = scanner.nextLine();

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
            } else if (escolha.equals("3")) {
                System.out.println("----------------------------------------");
                System.out.println("Consultando funcionario");
                System.out.println("----------------------------------------");
                System.out.println("Digite o Matricula/Id que deseja consultar: ");
                String id = scanner.nextLine();
                System.out.println("----------------------------------------");
                Funcionario funcionario = new Funcionario(Integer.parseInt(id));
                Funcionario consulta = funcionario.consultar(funcionario);

                if (consulta != null) {
                    System.out.println("Funcionario encontrado");
                    System.out.println("Matricula: " + consulta.getMatricula());
                    System.out.println("Nome: " + consulta.getNome());
                    System.out.println("CPF: " + consulta.getCpf());
                    System.out.println("Email: " + consulta.getEmail());
                    System.out.println("Horas: " + consulta.getHoraTrabalho());
                }
                System.out.println("----------------------------------------");
            } else if (escolha.equals("4")) {
                System.out.println("\nLista de Funcionarios");
                System.out.println("----------------------------------------");
                Funcionario funcionarios = new Funcionario();
                if (funcionarios != null) {
                    for (Funcionario f : funcionarios.listar()) {
                        System.out.println("Matricula: " + f.getMatricula());
                        System.out.println("Nome: " + f.getNome());
                        System.out.println("CPF: " + f.getCpf());
                        System.out.println("Email: " + f.getEmail());
                        System.out.println("Horas: " + f.getHoraTrabalho());
                        System.out.println("----------------------------------------");
                    }
                }

            }
        }
    }
}
