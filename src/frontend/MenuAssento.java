package frontend;

import java.io.IOException;
import java.util.Scanner;

import models.Assento;
import models.TipoAssento;

public class MenuAssento {

    public void menuAssento(Scanner scanner) throws IOException {
        while (true) {
            String escolha;
            System.out.println("----------------------------------------");
            System.out.println("Menu de Assento");
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
                String tipoAssentoID;
                System.out.println("Cadastrando Assento");
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

                while (true) {
                    System.out.println("Digite um ID de tipo-assento");
                    tipoAssentoID = scanner.nextLine();
                    if (tipoAssentoID.matches("\\d+")) {
                        TipoAssento tipoAssento = new TipoAssento(Integer.parseInt(tipoAssentoID));
                        if (tipoAssento.consultar(tipoAssento) != null) {
                            break;
                        } else {
                            System.out.println("Digite um tipo de assento válido");
                            System.out.println("----------------------------------------");
                        }
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }

                Assento assento = new Assento(Integer.parseInt(id), new TipoAssento(Integer.parseInt(tipoAssentoID)));
                assento.cadastrar();
            } else if (escolha.equals("2")) {
                String id;
                String tipoAssentoID;
                System.out.println("Cadastrando Assento");
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

                while (true) {
                    System.out.println("Digite um ID de tipo-assento");
                    tipoAssentoID = scanner.nextLine();
                    if (tipoAssentoID.matches("\\d+")) {
                        TipoAssento tipoAssento = new TipoAssento(Integer.parseInt(tipoAssentoID));
                        if (tipoAssento.consultar(tipoAssento) != null) {
                            break;
                        } else {
                            System.out.println("Digite um tipo de assento válido");
                            System.out.println("----------------------------------------");
                        }
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                Assento assento = new Assento(Integer.parseInt(id));
                Assento novAssento = new Assento(Integer.parseInt(id), new TipoAssento(Integer.parseInt(tipoAssentoID)));
                assento.editar(novAssento);

            } else if (escolha.equals("3")) {
                String id;
                System.out.println("Consultando Assento");
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite o ID do Assento");
                    id = scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }

                Assento assento = new Assento(Integer.parseInt(id));
                Assento info = assento.consultar(assento);

                if (info != null) {
                    System.out.println("ID: " + info.getId());
                    System.out.println("Tipo-Assento: " + info.getTipoAssento().getDescricao());
                }

            } else if (escolha.equals("4")) {

                System.out.println("\nLista de Assento");
                System.out.println("----------------------------------------");
                Assento assento = new Assento();
                if (assento != null) {
                    for (Assento info : assento.listar()) {
                        System.out.println("ID: " + info.getId());
                        System.out.println("Tipo-Assento: " + info.getTipoAssento().getDescricao());
                        System.out.println("----------------------------------------");
                    }
                }

            } else if (escolha.equals("0")) {
                break;
            }
        }
    }
}
