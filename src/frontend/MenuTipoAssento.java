package frontend;

import java.io.IOException;
import java.util.Scanner;

import models.TipoAssento;

public class MenuTipoAssento {
    public void menuTipoAssento(Scanner scanner) throws IOException {
        while (true) {
            String escolha;
            System.out.println("----------------------------------------");
            System.out.println("Menu de Tipo-Assento");
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
                System.out.println("Cadastrando Tipo-Assento");
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite o ID");
                    id = scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Digite a descrição");
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

                TipoAssento tipoAssento = new TipoAssento(Integer.parseInt(id), descricao, status);
                tipoAssento.cadastrar();
            } else if (escolha.equals("2")) {

                String id;
                String descricao;
                String status;
                System.out.println("Editando Tipo-Assento");
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite o ID");
                    id = scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Digite a descrição");
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

                TipoAssento tipoAssento = new TipoAssento(Integer.parseInt(id));
                TipoAssento novoTipoAssento = new TipoAssento(Integer.parseInt(id), descricao, status);
                tipoAssento.editar(novoTipoAssento);
            } else if (escolha.equals("3")) {
                String id;
                System.out.println("Consultando Tipo-Assento");
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite o ID do Tipo-Assento");
                    id = scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }

                TipoAssento tipoAssento = new TipoAssento(Integer.parseInt(id));
                TipoAssento info = tipoAssento.consultar(tipoAssento);

                if (info != null) {
                    System.out.println("ID: " + info.getId());
                    System.out.println("Descrição: " + info.getDescricao());
                    System.out.println("Status: " + info.getStatus());
                }

            } else if (escolha.equals("4")) {

                System.out.println("\nLista de Tipo-Assento");
                System.out.println("----------------------------------------");
                TipoAssento tipoAssento = new TipoAssento();
                if (tipoAssento != null) {
                    for (TipoAssento info : tipoAssento.listar()) {
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
