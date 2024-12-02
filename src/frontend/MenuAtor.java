package frontend;


import models.Ator;


import java.io.IOException;
import java.util.Scanner;



public class MenuAtor {

    public void MenuAtores(Scanner scanner) throws IOException {
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("Menu de Atores");
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
                String registro;
                System.out.println("----------------------------------------");
                System.out.println("Registrando ator");
                System.out.println("----------------------------------------");
                System.out.println("Digite o nome do Ator");
                String nome = scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("Digite o CPF do Ator");
                String cpf = scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("Digite o email do Ator");
                String email = scanner.nextLine();
                System.out.println("----------------------------------------");
                while (true) {
                    try {
                        System.out.println("Identificador/Id que deseja editar:");
                        registro = scanner.nextLine();
                        if (registro.matches("\\d+")) {
                            break;
                        } else {
                            System.out.println("Id válidos contem somente números!");
                        }
                    } catch (NumberFormatException e) {
                        throw e;
                    }
                }

                Ator ator = new Ator(nome, cpf, email, Integer.parseInt(registro));
                ator.cadastrar();
            }

            if (escolha.equals("2")) {
                String id;
                System.out.println("----------------------------------------");
                System.out.println("Editando ator");
                System.out.println("----------------------------------------");
                while (true) {
                    try {
                        System.out.println("Identificador/Id que deseja editar:");
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
                System.out.println("Nome do Ator");
                String nome = scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("CPF do Ator");
                String cpf = scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("Email do ator");
                String email = scanner.nextLine();

                Ator ator = new Ator(nome, cpf, email, Integer.parseInt(id));
                ator.editar(ator);
            }

            if (escolha.equals("3")) {
                String id;
                System.out.println("----------------------------------------");
                System.out.println("Consultando ator");
                System.out.println("----------------------------------------");
                while (true) {
                    try {
                        System.out.println("Identificador/Id que deseja Consultar:");
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

                Ator ator = new Ator(Integer.parseInt(id));
                Ator info = ator.consultar(ator);
                System.out.println("----------------------------------------");
                if (info != null) {
                    System.out.println("Ator encontrado");
                    System.out.println("Registro: " + info.getRegistro());
                    System.out.println("Nome: " + info.getNome());
                    System.out.println("CPF: " + info.getCpf());
                    System.out.println("Email: " + info.getEmail());
                }
            }

            if (escolha.equals("4")) {
                System.out.println("\nLista de Atores");
                System.out.println("----------------------------------------");
                Ator atores = new Ator();

                if (atores != null) {
                    for (Ator ator : atores.listar()) {
                        System.out.println("Registro: " + ator.getRegistro());
                        System.out.println("Nome: " + ator.getNome());
                        System.out.println("CPF: " + ator.getCpf());
                        System.out.println("Email: " + ator.getEmail());
                        System.out.println("----------------------------------------");
                    }
                }
            }

        }
    }
}
