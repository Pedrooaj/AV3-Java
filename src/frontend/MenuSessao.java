package frontend;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import models.Filme;
import models.Funcionario;
import models.Sala;
import models.Sessao;

public class MenuSessao {
    public void menuSessao(Scanner scanner) throws IOException {

        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("Menu de Sessão");
            System.out.println("----------------------------------------");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Editar");
            System.out.println("3 - Consultar");
            System.out.println("4 - Listar");
            System.out.println("0 - Voltar");
            System.out.println("----------------------------------------");
            String escolha = scanner.nextLine();
            if (escolha.equals("1")) {
                String funcionarioID;
                String salaID;
                Sala sala;
        
                String filmeID;
                String status;
                String id;
                String date;

                System.out.println("Cadastro de Sessão");
                System.out.println("----------------------------------------");
                System.out.println("Digite o ID da Sessão");
                while (true) {
                    try {
                        id = scanner.nextLine();
                        if (id.matches("\\d+")) {
                            break;
                        } else {
                            System.out.println("O ID deve ser Númerico");
                        }
                    } catch (NumberFormatException e) {
                        throw e;
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Digite a Data e Hora da Sessão yyyy-MM-ddTHH:mm:ss");
                while (true) {
                    try {
                        date = scanner.nextLine();
                        if (date.matches(
                                "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])T([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$")) {
                            break;
                        } else {
                            System.out.println("O formato valido e apenas yyyy-MM-ddTHH:mm:ss");
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite a Matricula de um funcionario");
                    funcionarioID = scanner.nextLine();
                    if (funcionarioID.matches("\\d+")) {
                        Funcionario funcionario = new Funcionario(Integer.parseInt(funcionarioID));
                        if (funcionario.consultar(funcionario) != null) {
                            break;
                        } else {
                            System.out.println("Digite um funcionario válido");
                            System.out.println("----------------------------------------");
                        }
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite um id de Sala");
                    salaID = scanner.nextLine();
                    if (salaID.matches("\\d+")) {
                        sala = new Sala(Integer.parseInt(salaID));
                        if (sala.consultar(sala) != null) {
                            break;
                        } else {
                            System.out.println("Digite uma Sala Válida");
                            System.out.println("----------------------------------------");
                        }
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite um id de Filme");
                    filmeID = scanner.nextLine();
                    if (filmeID.matches("\\d+")) {
                        Filme filme = new Filme(Integer.parseInt(filmeID));
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
                System.out.println("Digite um Status Ativo/Inativo");
                while (true) {
                    status = scanner.nextLine();
                    if (status.toLowerCase().equals("ativo") || status.toLowerCase().equals("inativo")) {
                        status = status.toLowerCase();
                        break;
                    } else {
                        System.out.println("Status Válido são apenas Ativo/Inativo");
                    }
                }

                Sessao sessao = new Sessao(new Funcionario(Integer.parseInt(funcionarioID)), new Sala(Integer.parseInt(salaID)), new Filme(Integer.parseInt(filmeID)),
                        Integer.parseInt(id), status, LocalDateTime.parse(date));
                sessao.cadastrar();
            } else if (escolha.equals("2")) {
                String funcionarioID;
                String status;
                String id;
                String date;
                Sala sala;
                String salaID;
                System.out.println("----------------------------------------");
                System.out.println("Menu de editar Sessão");
                System.out.println("----------------------------------------");

                while (true) {
                    System.out.println("Digite o Id que seja Editar");
                    id = scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("Id válidos contem somente números!");
                    }
                }

                System.out.println("----------------------------------------");
                System.out.println("Digite a Data e Hora da Sessão yyyy-MM-ddTHH:mm:ss");
                while (true) {
                    date = scanner.nextLine();
                    if (date.matches(
                            "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])T([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$")) {
                        break;
                    } else {
                        System.out.println("O formato valido e apenas yyyy-MM-ddTHH:mm:ss");
                    }
                }
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite a Matricula de um funcionario");
                    funcionarioID = scanner.nextLine();
                    if (funcionarioID.matches("\\d+")) {
                        Funcionario funcionario = new Funcionario(Integer.parseInt(funcionarioID));
                        if (funcionario.consultar(funcionario) != null) {
                            break;
                        } else {
                            System.out.println("Digite um funcionario válido");
                            System.out.println("----------------------------------------");
                        }
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                while (true) {
                    System.out.println("Digite um id de Sala");
                    salaID = scanner.nextLine();
                    if (salaID.matches("\\d+")) {
                        sala = new Sala(Integer.parseInt(salaID));
                        if (sala.consultar(sala) != null) {
                            break;
                        } else {
                            System.out.println("Digite uma Sala Válida");
                            System.out.println("----------------------------------------");
                        }
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Digite um Status Ativo/Inativo");
                while (true) {
                    status = scanner.nextLine();
                    if (status.toLowerCase().equals("ativo") || status.toLowerCase().equals("inativo")) {
                        status = status.toLowerCase();
                        break;
                    } else {
                        System.out.println("Status Válido são apenas Ativo/Inativo");
                    }
                }
                Funcionario funcionario = new Funcionario(Integer.parseInt(funcionarioID));
                Sessao sessao = new Sessao(funcionario.consultar(funcionario), sala, new Filme(),
                        Integer.parseInt(id), status, LocalDateTime.parse(date));

                sessao.editar(sessao);

            } else if (escolha.equals("3")) {
                String id;
                System.out.println("----------------------------------------");
                System.out.println("Consultando Sessão");
                System.out.println("----------------------------------------");
                id = scanner.nextLine();

                Sessao sessao = new Sessao(Integer.parseInt(id));
                Sessao info = sessao.consultar(sessao);
                DateTimeFormatter dataFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                if (info != null) {
                    System.out.println("----------------------------------------");
                    System.out.println("Id: " + info.getId());
                    System.out.println("Sala: " + info.getSala().getDescricao());
                    System.out.println("Filme:  " + info.getFilme().getTitulo());
                    System.out.println("Status: " + info.getStatus());
                    System.out.println("Hórario/Data: " + dataFormater.format(info.getDataHora()));
                    System.out.println("Funcionario: " + info.getFuncionario().getNome());
                }
            } else if (escolha.equals("4")) {
                System.out.println("\nLista de Sessões");
                System.out.println("----------------------------------------");
                Sessao sessoes = new Sessao();
                if (sessoes != null) {
                    for (Sessao sessao : sessoes.listar()) {
                        System.out.println("Id: " + sessao.getId());
                        System.out.println("Sala: " + sessao.getSala().getDescricao());
                        System.out.println("Filme:  " + sessao.getFilme());
                        System.out.println("Status: " + sessao.getStatus());
                        System.out.println("Hórario/Data: " + sessao.getDataHora());
                        System.out.println("Funcionario: " + sessao.getFuncionario().getNome());
                        System.out.println("----------------------------------------");
                    }
                }
            }

            else if (escolha.equals("0")) {
                break;
            }
        }
    }
}
