package frontend;

import java.io.IOException;
import java.util.Scanner;

import models.Assento;
import models.Sala;
import models.SalaAssento;

public class MenuSalaAssento {
    public void menuSalaAssento(Scanner scanner) throws IOException {
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("Menu de Sala-Assento");
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
                String salaID;
                String assentoID;
                System.out.println("Cadastrando Sala-Assento");
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite o ID da Sala-Assento");
                    id = scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");

                while (true) {
                    System.out.println("Digite o Id de uma Sala");
                    salaID = scanner.nextLine();
                    if (salaID.matches("\\d+")) {
                        Sala sala = new Sala(Integer.parseInt(salaID));
                        if (sala.consultar(sala) != null) {
                            break;
                        } else {
                            System.out.println("Digite uma sala válida");
                            System.out.println("----------------------------------------");
                        }
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");

                while (true) {
                    System.out.println("Digite o Id de um assento");
                    assentoID = scanner.nextLine();
                    if (assentoID.matches("\\d+")) {
                        Assento assento = new Assento(Integer.parseInt(assentoID));
                        if (assento.consultar(assento) != null) {
                            break;
                        } else {
                            System.out.println("Digite uma assento válido");
                            System.out.println("----------------------------------------");
                        }
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }

                SalaAssento salaAssento = new SalaAssento(Integer.parseInt(id), new Assento(Integer.parseInt(assentoID)), new Sala(Integer.parseInt(salaID)));
                salaAssento.cadastrar();

            } else if (escolha.equals("2")) {
                String id;
                String salaID;
                String assentoID;
                System.out.println("Editando Sala-Assento");
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite o ID da Sala-Assento");
                    id = scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");

                while (true) {
                    System.out.println("Digite o Id de uma sala");
                    salaID = scanner.nextLine();
                    if (salaID.matches("\\d+")) {
                        Sala sala = new Sala(Integer.parseInt(salaID));
                        if (sala.consultar(sala) != null) {
                            break;
                        } else {
                            System.out.println("Digite uma sala válida");
                            System.out.println("----------------------------------------");
                        }
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");

                while (true) {
                    System.out.println("Digite o Id de um assento");
                    assentoID = scanner.nextLine();
                    if (assentoID.matches("\\d+")) {
                        Assento assento = new Assento(Integer.parseInt(assentoID));
                        if (assento.consultar(assento) != null) {
                            break;
                        } else {
                            System.out.println("Digite uma assento válido");
                            System.out.println("----------------------------------------");
                        }
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                SalaAssento salaAssento = new SalaAssento(Integer.parseInt(id));
                SalaAssento novasalaAssento = new SalaAssento(Integer.parseInt(id), new Assento(Integer.parseInt(assentoID)), new Sala(Integer.parseInt(salaID)));
                salaAssento.editar(novasalaAssento);
            } else if (escolha.equals("3")) {
                String id;
                System.out.println("Consultar Sala-Assento");
                System.out.println("----------------------------------------");
                System.out.println("Digite o ID da Sala-Assento");
                id = scanner.nextLine();
                System.out.println("----------------------------------------");
                SalaAssento sala = new SalaAssento(Integer.parseInt(id));
                SalaAssento info = sala.consultar(sala);
                System.out.println("Sala-Assento Encontrada");
                System.out.println("----------------------------------------");
                if(info != null){
                    System.out.println("Id: " + info.getId());
                    System.out.println("Sala: " + info.getSala().getDescricao());
                    System.out.println("Assento: " + info.getAssento().getTipoAssento().getDescricao());
                }
            } else if (escolha.equals("4")) {
                System.out.println("\nLista de Sala-Assento");
                System.out.println("----------------------------------------");
                SalaAssento salas = new SalaAssento();
                if (salas != null) {
                    for (SalaAssento info : salas.listar()) {
                        System.out.println("Id: " + info.getId());
                        System.out.println("Sala: " + info.getSala().getDescricao());
                        System.out.println("Assento: " + info.getAssento().getTipoAssento().getDescricao());

                        System.out.println("----------------------------------------");
                    }
                }
            } else if (escolha.equals("0")) {
                break;
            }
        }
    }

}
