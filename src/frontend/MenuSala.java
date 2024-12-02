package frontend;

import java.io.IOException;
import java.util.Scanner;

import models.Sala;

public class MenuSala {
    public void menuSala(Scanner scanner) throws IOException {
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("Menu de Sala");
            System.out.println("----------------------------------------");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Editar");
            System.out.println("3 - Consultar");
            System.out.println("4 - Listar");
            System.out.println("0 - Voltar");
            System.out.println("----------------------------------------");
            String escolha = scanner.nextLine();

            if (escolha.equals("1")) {
                String id;
                String descricao;
                String capacidade;
                String status;
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite o ID da sala");
                    id = scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }

                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite um Status Ativo/Inativo");
                    status = scanner.nextLine();
                    if (status.toLowerCase().equals("ativo") || status.toLowerCase().equals("inativo")) {
                        status = status.toLowerCase();
                        break;
                    } else {
                        System.out.println("Status Válido são apenas Ativo/Inativo");
                    }
                }
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite a Capacidade da sala");
                    capacidade = scanner.nextLine();
                    if (capacidade.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Digite uma descrição");
                descricao = scanner.nextLine();

                Sala sala = new Sala(Integer.parseInt(id), Integer.parseInt(capacidade), descricao, status);
                sala.cadastrar();

            } else if (escolha.equals("2")) {
                String id;
                String descricao;
                String capacidade;
                String status;
                System.out.println("Editar Sala");
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite o ID da sala");
                    id = scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite um Status Ativo/Inativo");
                    status = scanner.nextLine();
                    if (status.toLowerCase().equals("ativo") || status.toLowerCase().equals("inativo")) {
                        status = status.toLowerCase();
                        break;
                    } else {
                        System.out.println("Status Válido são apenas Ativo/Inativo");
                    }
                }
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite a Capacidade da sala");
                    capacidade = scanner.nextLine();
                    if (capacidade.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Digite uma descrição");
                descricao = scanner.nextLine();

                Sala sala = new Sala(Integer.parseInt(id), Integer.parseInt(capacidade), descricao, status);
                sala.editar(sala);

            } else if (escolha.equals("3")) {
                String id;
                System.out.println("Consultar Sala");
                System.out.println("----------------------------------------");
                System.out.println("Digite o ID da Sala");
                id = scanner.nextLine();
                System.out.println("----------------------------------------");
                Sala sala = new Sala(Integer.parseInt(id));
                Sala info = sala.consultar(sala);
                System.out.println("----------------------------------------");
                System.out.println("Id: " + info.getId());
                System.out.println("Capacidade: " + info.getCapacidade());
                System.out.println("Status: " + info.getStatus());
                System.out.println("Descrição: " + info.getDescricao());
            } else if (escolha.equals("4")) {
                System.out.println("\nLista de Salas");
                System.out.println("----------------------------------------");
                Sala salas = new Sala();
                if (salas != null) {
                    for (Sala sala : salas.listar()) {
                        System.out.println("Id: " + sala.getId());
                        System.out.println("Capacidade: " + sala.getCapacidade());
                        System.out.println("Status:  " + sala.getStatus());
                        System.out.println("Descrição: " + sala.getDescricao());

                        System.out.println("----------------------------------------");
                    }
                }
            } else if (escolha.equals("0")) {
                break;
            }
        }
    }
}
