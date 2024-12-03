package frontend;

import java.io.IOException;
import java.util.Scanner;

import models.Ator;
import models.Filme;
import models.FilmeAtor;

public class MenuAtorFilme {
     public void menuFilmeAtor(Scanner scanner) throws IOException {
        while (true) {
            String escolha;
            System.out.println("----------------------------------------");
            System.out.println("Menu de Filme-Ator");
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
                String idAtor;
                Ator ator;
                String idFilme;
                Filme filme;
                String personagem;
                boolean principalBol;
                
                System.out.println("Cadastrando Filme-Ator");
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
                    System.out.println("Digite se e Principal ou não True/False");
                    String principal = scanner.nextLine();
                    if (principal.toLowerCase().equals("true") || principal.toLowerCase().equals("false")) {
                        principal = principal.toLowerCase();
                        if(principal.equals("true")){
                            principalBol = true;
                        }else{
                            principalBol = false;
                        }
                        break;
                    } else {
                        System.out.println("Principa somente e Válido se True/False");
                    }
                }
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite um id de um Ator");
                    idAtor = scanner.nextLine();
                    if (idAtor.matches("\\d+")) {
                        ator = new Ator(Integer.parseInt(idAtor));
                        if (ator.consultar(ator) != null) {
                            break;
                        } else {
                            System.out.println("Digite um Ator Válido");
                            System.out.println("----------------------------------------");
                        }
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }

                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite um id de um Filme");
                    idFilme = scanner.nextLine();
                    if (idFilme.matches("\\d+")) {
                        filme = new Filme(Integer.parseInt(idFilme));
                        if (filme.consultar(filme) != null) {
                            break;
                        } else {
                            System.out.println("Digite um Filme Válido");
                            System.out.println("----------------------------------------");
                        }
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Personagem Interpretado");
                personagem = scanner.nextLine();

                FilmeAtor filmeAtor = new FilmeAtor(Integer.parseInt(id), ator.consultar(ator), filme.consultar(filme), personagem, principalBol);
                filmeAtor.cadastrar();
            } else if (escolha.equals("2")) {
                String id;
                String idAtor;
                Ator ator;
                String idFilme;
                Filme filme;
                String personagem;
                boolean principalBol;
                
                System.out.println("Cadastrando Filme-Ator");
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
                    System.out.println("Digite se e Principal ou não True/False");
                    String principal = scanner.nextLine();
                    if (principal.toLowerCase().equals("true") || principal.toLowerCase().equals("false")) {
                        principal = principal.toLowerCase();
                        if(principal.equals("true")){
                            principalBol = true;
                        }else{
                            principalBol = false;
                        }
                        break;
                    } else {
                        System.out.println("Principa somente e Válido se True/False");
                    }
                }
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite um id de um Ator");
                    idAtor = scanner.nextLine();
                    if (idAtor.matches("\\d+")) {
                        ator = new Ator(Integer.parseInt(idAtor));
                        if (ator.consultar(ator) != null) {
                            break;
                        } else {
                            System.out.println("Digite um Ator Válido");
                            System.out.println("----------------------------------------");
                        }
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }

                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite um id de um Filme");
                    idFilme = scanner.nextLine();
                    if (idFilme.matches("\\d+")) {
                        filme = new Filme(Integer.parseInt(idFilme));
                        if (filme.consultar(filme) != null) {
                            break;
                        } else {
                            System.out.println("Digite um Filme Válido");
                            System.out.println("----------------------------------------");
                        }
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Personagem Interpretado");
                personagem = scanner.nextLine();

                FilmeAtor filmeAtor = new FilmeAtor(Integer.parseInt(id));
                FilmeAtor novoFilmeAtor = new FilmeAtor(Integer.parseInt(id), ator.consultar(ator), filme.consultar(filme), personagem, principalBol);
                filmeAtor.editar(novoFilmeAtor);


            } else if (escolha.equals("3")) {
                String id;
                while (true) {
                    try {  
                        System.out.println("Consultar Ator-Filme");
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
                FilmeAtor filme = new FilmeAtor(Integer.parseInt(id));
                FilmeAtor info = filme.consultar(filme);
                System.out.println("----------------------------------------");
                if(info != null){
                    System.out.println("ID: " + info.getId());
                    System.out.println("Personagem: " + info.getPersonagem());
                    System.out.println("Ator: " + info.getAtor().getNome());
                    System.out.println("Filme: " + info.getFilme().getTitulo());
                    System.out.println("Principal: " + info.getPrincipal());
                }
                

            } else if (escolha.equals("4")) {
                System.out.println("\nLista de Filme-Ator");
                System.out.println("----------------------------------------");
                FilmeAtor filmes = new FilmeAtor();
                if (filmes != null) {
                    for (FilmeAtor filme : filmes.listar()) {
                        System.out.println("ID: " + filme.getId());
                        System.out.println("Personagem: " + filme.getPersonagem());
                        System.out.println("Ator: " + filme.getAtor().getNome());
                        System.out.println("Filme: " + filme.getFilme().getTitulo());
                        System.out.println("Principal: " + filme.getPrincipal());
                        System.out.println("----------------------------------------");
                    }
                }

            } else if (escolha.equals("0")) {
                break;
            }
        }
    }
}
