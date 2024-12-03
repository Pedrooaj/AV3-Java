package frontend;

import java.io.IOException;
import java.util.Scanner;

import models.Filme;
import models.Genero;

public class MenuFilme {
    public void menuFilme(Scanner scanner) throws IOException {
        while (true) {
            String escolha;
            System.out.println("----------------------------------------");
            System.out.println("Menu de Filme");
            System.out.println("----------------------------------------");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Editar");
            System.out.println("3 - Consultar");
            System.out.println("4 - Listar");
            System.out.println("0 - Voltar");
            System.out.println("----------------------------------------");
            escolha = scanner.nextLine();
            if (escolha.equals("1")) {

                String titulo;
                String classificacao;
                String id;
                String status;
                String generoID;
                Genero genero;
                
                System.out.println("Cadastrando filme");
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite o ID do Filme");
                    id = scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Digite o Titulo do Filme");
                titulo = scanner.nextLine();
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite a Classificação");
                    classificacao = scanner.nextLine();
                    if (classificacao.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("A classificação deve ser Númerica");
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
                    System.out.println("Digite um id de um Gênero");
                    generoID = scanner.nextLine();
                    if (generoID.matches("\\d+")) {
                        genero = new Genero(Integer.parseInt(generoID));
                        if (genero.consultar(genero) != null) {
                            break;
                        } else {
                            System.out.println("Digite um Gênero Válido");
                            System.out.println("----------------------------------------");
                        }
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }

                Filme filme = new Filme(Integer.parseInt(id), titulo, Integer.parseInt(classificacao), status, genero);
                filme.cadastrar();
            } else if (escolha.equals("2")) {
                String titulo;
                String classificacao;
                String id;
                String status;
                String generoID;
                Genero genero;
                System.out.println("Editando Filme");
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite o ID do Filme");
                    id = scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Digite o Titulo do Filme");
                titulo = scanner.nextLine();
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite a Classificação");
                    classificacao = scanner.nextLine();
                    if (classificacao.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("A classificação deve ser Númerica");
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
                    System.out.println("Digite um id de Sala");
                    generoID = scanner.nextLine();
                    if (generoID.matches("\\d+")) {
                        genero = new Genero(Integer.parseInt(generoID));
                        if (genero.consultar(genero) != null) {
                            break;
                        } else {
                            System.out.println("Digite um Gênero Válido");
                            System.out.println("----------------------------------------");
                        }
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }

                Filme filme = new Filme(Integer.parseInt(id), titulo, Integer.parseInt(classificacao), status, genero);
                filme.editar(filme);
            } else if (escolha.equals("3")) {
                String id;
                while (true) {
                    try {
                        
                        System.out.println("Consultar Filme");
                        System.out.println("----------------------------------------");
                        System.out.println("ID que deseja Consultar");
                        id = scanner.nextLine();
                        if (id.matches("\\d+")) {
                            break;
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Id válidos contem somente números!");
                    }
                }
                Filme filme = new Filme(Integer.parseInt(id));
                Filme info = filme.consultar(filme);
                System.out.println("----------------------------------------");
                if(info != null){
                    System.out.println("ID: " + info.getIdFilme());
                    System.out.println("Titulo: " + info.getTitulo());
                    System.out.println("Gênero: " + info.getGenero().getDescricao());
                    System.out.println("Classificação: " + info.getClassificacao());
                    System.out.println("Status: " + info.getStatus());
                }

            } else if (escolha.equals("4")) {
                System.out.println("\nLista de Filmes");
                System.out.println("----------------------------------------");
                Filme filmes = new Filme();
                if (filmes != null) {
                    for (Filme filme : filmes.listar()) {
                        System.out.println("ID: " + filme.getIdFilme());
                        System.out.println("Titulo: " + filme.getTitulo());
                        System.out.println("Gênero: " + filme.getGenero().getDescricao());
                        System.out.println("Classificação: " + filme.getClassificacao());
                        System.out.println("Status: " + filme.getStatus());
                        System.out.println("----------------------------------------");
                    }
                }

            } else if (escolha.equals("0")) {
                break;
            }
        }
    }
}
