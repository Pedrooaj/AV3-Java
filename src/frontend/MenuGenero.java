package frontend;

import java.io.IOException;
import java.util.Scanner;

import models.Genero;

public class MenuGenero {
     public void menuGenero(Scanner scanner) throws IOException {
        while (true) {
            String escolha;
            System.out.println("----------------------------------------");
            System.out.println("Menu de Gênero");
            System.out.println("----------------------------------------");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Editar");
            System.out.println("3 - Consultar");
            System.out.println("4 - Listar");
            System.out.println("0 - Voltar");
            System.out.println("----------------------------------------");
            escolha = scanner.nextLine();

            if (escolha.equals("1")) {
                String id;
                String descricao;
                String status;
                System.out.println("Cadastrando Genero");
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite o ID do Genero");
                    id = scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Digite a descrição do Gênero");
                descricao = scanner.nextLine();
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

                Genero genero = new Genero(Integer.parseInt(id), descricao, status);
                genero.cadastrar();
            } else if (escolha.equals("2")) {
                String id;
                String descricao;
                String status;
                System.out.println("Editando Gênero");
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite o ID do Genero");
                    id = scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Digite a descrição do Gênero");
                descricao = scanner.nextLine();
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
                Genero genero = new Genero(Integer.parseInt(id), descricao, status);
                genero.editar(genero);

            } else if (escolha.equals("3")) {
                String id;
                System.out.println("Consultando Gênero");
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite o ID do Genero");
                    id = scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }

                Genero genero = new Genero(Integer.parseInt(id));
                Genero info = genero.consultar(genero);

                if (info != null) {
                    System.out.println("ID: " + info.getId());
                    System.out.println("Descrição: " + info.getDescricao());
                    System.out.println("Status: " + info.getStatus());
                }

            } else if (escolha.equals("4")) {

                System.out.println("\nLista de Gênero");
                System.out.println("----------------------------------------");
                Genero generos = new Genero();
                if (generos != null) {
                    for (Genero info : generos.listar()) {
                        System.out.println("ID: " + info.getId());
                        System.out.println("Descrição: " + info.getDescricao());
                        System.out.println("Status: " + info.getStatus());
                        System.out.println("----------------------------------------");
                    }
                }

            } else if (escolha.equals("0")) {
                break;
            }
        }
    }
}
