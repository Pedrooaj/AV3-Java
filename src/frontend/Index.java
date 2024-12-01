package frontend;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import models.Ator;
import models.Filme;
import models.Funcionario;
import models.Genero;
import models.Sala;
import models.Sessao;

public class Index {
    private Scanner scanner;

    public Index() {
        this.scanner = new Scanner(System.in);
    }

    public void iniciarMenu() throws IOException {
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("Seja Bem Vindo há aplicação de Pedrooaj!");
            System.out.println("----------------------------------------");
            System.out.println("1 - Atores            5 - Sessão");
            System.out.println("2 - Funcionarios      6 - Sala");
            System.out.println("3 - Filme             7 - Dúvidas");
            System.out.println("4 - Gênero            0 - Sair");
            System.out.println("----------------------------------------");
            String escolha = this.scanner.nextLine();

            // menu de atores
            if (escolha.equals("1")) {
                this.MenuAtores();
            }

            // menu de funcionarios
            if (escolha.equals("2")) {
                this.MenuFuncinarios();
            }
            if (escolha.equals("3")) {
                this.menuFilme();
            }
            if (escolha.equals("4")) {
                System.out.println("Menu genero");
            }
            if (escolha.equals("5")) {
                this.menuSessao();
            }

            if (escolha.equals("6")) {
                this.menuSala();
            }

            if (escolha.equals("7")) {
                this.Duvidas();
            }

            if (escolha.equals("0")) {
                this.scanner.close();
                break;
            }

        }
    }

    public void MenuAtores() throws IOException {
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("Menu de Atores:");
            System.out.println("----------------------------------------");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Editar");
            System.out.println("3 - Consultar");
            System.out.println("4 - Listar");
            System.out.println("0 - Voltar");
            System.out.println("----------------------------------------");
            String escolha = this.scanner.nextLine();

            if (escolha.equals("0")) {
                break;
            }
            if (escolha.equals("1")) {
                String registro;
                System.out.println("----------------------------------------");
                System.out.println("Registrando ator");
                System.out.println("----------------------------------------");
                System.out.println("Digite o nome do Ator");
                String nome = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("Digite o CPF do Ator");
                String cpf = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("Digite o email do Ator");
                String email = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                while (true) {
                    try {
                        System.out.println("Identificador/Id que deseja editar:");
                        registro = this.scanner.nextLine();
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
                        id = this.scanner.nextLine();
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
                String nome = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("CPF do Ator");
                String cpf = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("Email do ator");
                String email = this.scanner.nextLine();

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
                        id = this.scanner.nextLine();
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

    public void MenuFuncinarios() throws IOException {
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
            String escolha = this.scanner.nextLine();

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
                String nome = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("CPF do funcionario");
                String cpf = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("Email do funcionario");
                String email = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Jornada de trabalho hh:mm:ss");
                    String timeInput = this.scanner.nextLine();

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
                        matricula = this.scanner.nextLine();
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
                        id = this.scanner.nextLine();
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
                String nome = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("CPF do Funcionario");
                String cpf = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.println("Email do Funcionario");
                String email = this.scanner.nextLine();
                while (true) {
                    System.out.println("----------------------------------------");
                    System.out.println("Jornada de trabalho hh:mm:ss");
                    String timeInput = this.scanner.nextLine();

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
                String id = this.scanner.nextLine();
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

    public void menuSessao() throws IOException {

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
            String escolha = this.scanner.nextLine();
            if (escolha.equals("1")) {
                String funcionarioID;
                String salaID;
                Sala sala;
                String status;
                String id;
                String date;

                System.out.println("Cadastro de Sessão");
                System.out.println("----------------------------------------");
                System.out.println("Digite o ID da Sessão");
                while (true) {
                    try {
                        id = this.scanner.nextLine();
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
                        date = this.scanner.nextLine();
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
                    funcionarioID = this.scanner.nextLine();
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
                    salaID = this.scanner.nextLine();
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
                    status = this.scanner.nextLine();
                    if (status.toLowerCase().equals("ativo") || status.toLowerCase().equals("inativo")) {
                        status = status.toLowerCase();
                        break;
                    } else {
                        System.out.println("Status Válido são apenas Ativo/Inativo");
                    }
                }

                Sessao sessao = new Sessao(new Funcionario(Integer.parseInt(funcionarioID)), sala, null,
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
                    id = this.scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("Id válidos contem somente números!");
                    }
                }

                System.out.println("----------------------------------------");
                System.out.println("Digite a Data e Hora da Sessão yyyy-MM-ddTHH:mm:ss");
                while (true) {
                    date = this.scanner.nextLine();
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
                    funcionarioID = this.scanner.nextLine();
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
                    salaID = this.scanner.nextLine();
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
                    status = this.scanner.nextLine();
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
                id = this.scanner.nextLine();

                Sessao sessao = new Sessao(Integer.parseInt(id));
                Sessao info = sessao.consultar(sessao);
                DateTimeFormatter dataFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                if (info != null) {
                    System.out.println("----------------------------------------");
                    System.out.println("Id: " + info.getId());
                    System.out.println("Sala: " + info.getSala().getDescricao());
                    System.out.println("Filme:  " + info.getFilme());
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

    public void menuSala() throws IOException {
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
            String escolha = this.scanner.nextLine();

            if (escolha.equals("1")) {
                String id;
                String descricao;
                String capacidade;
                String status;
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite o ID da sala");
                    id = this.scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }

                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite um Status Ativo/Inativo");
                    status = this.scanner.nextLine();
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
                    capacidade = this.scanner.nextLine();
                    if (capacidade.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Digite uma descrição");
                descricao = this.scanner.nextLine();

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
                    id = this.scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite um Status Ativo/Inativo");
                    status = this.scanner.nextLine();
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
                    capacidade = this.scanner.nextLine();
                    if (capacidade.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Digite uma descrição");
                descricao = this.scanner.nextLine();

                Sala sala = new Sala(Integer.parseInt(id), Integer.parseInt(capacidade), descricao, status);
                sala.editar(sala);

            } else if (escolha.equals("3")) {
                String id;
                System.out.println("Consultar Sala");
                System.out.println("----------------------------------------");
                System.out.println("Digite o ID da Sala");
                id = this.scanner.nextLine();
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

    public void menuFilme() throws IOException {
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
            escolha = this.scanner.nextLine();
            if (escolha.equals("1")) {

                String titulo;
                String classificacao;
                String id;
                String status;
                String generoID;
                System.out.println("Cadastrando filme");
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite o ID do Filme");
                    id = this.scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Digite o Titulo do Filme");
                titulo = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite a Classificação");
                    classificacao = this.scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("A classificação deve ser Númerica");
                    }
                }
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite um Status Ativo/Inativo");
                    status = this.scanner.nextLine();
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
                    generoID = this.scanner.nextLine();
                    if (generoID.matches("\\d+")) {
                        // genero = new Genero(Integer.parseInt(salaID));
                        // if (genero.consultar(genero) != null) {
                        // break;
                        // } else {
                        // System.out.println("Digite um Gênero Válido");
                        // System.out.println("----------------------------------------");
                        // }
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }

                Filme filme = new Filme(Integer.parseInt(id), titulo, Integer.parseInt(classificacao), status,
                        new Genero());
                filme.cadastrar();
            } else if (escolha.equals("2")) {
                String titulo;
                String classificacao;
                String id;
                String status;
                String generoID;
                System.out.println("Editando Filme");
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite o ID do Filme");
                    id = this.scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }
                System.out.println("----------------------------------------");
                System.out.println("Digite o Titulo do Filme");
                titulo = this.scanner.nextLine();
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite a Classificação");
                    classificacao = this.scanner.nextLine();
                    if (id.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("A classificação deve ser Númerica");
                    }
                }
                System.out.println("----------------------------------------");
                while (true) {
                    System.out.println("Digite um Status Ativo/Inativo");
                    status = this.scanner.nextLine();
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
                    generoID = this.scanner.nextLine();
                    if (generoID.matches("\\d+")) {
                        // genero = new Genero(Integer.parseInt(salaID));
                        // if (genero.consultar(genero) != null) {
                        // break;
                        // } else {
                        // System.out.println("Digite um Gênero Válido");
                        // System.out.println("----------------------------------------");
                        // }
                        break;
                    } else {
                        System.out.println("O ID deve ser Númerico");
                    }
                }

                Filme filme = new Filme(Integer.parseInt(id), titulo, Integer.parseInt(classificacao), status,
                        new Genero());
                filme.editar(filme);
            } else if (escolha.equals("3")) {
                String id;
                while (true) {
                    try {
                        System.out.println("Consultar Filme");
                        System.out.println("----------------------------------------");
                        System.out.println("ID que deseja Consultar");
                        id = this.scanner.nextLine();
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
                System.out.println("ID: " + info.getIdFilme());
                System.out.println("Titulo: " + info.getTitulo());
                System.out.println("Gênero: " + info.getGenero());
                System.out.println("Classificação: " + info.getClassificacao());
                System.out.println("Status: " + info.getStatus());

            } else if (escolha.equals("4")) {
                System.out.println("\nLista de Filmes");
                System.out.println("----------------------------------------");
                Filme filmes = new Filme();
                if (filmes != null) {
                    for (Filme filme : filmes.listar()) {
                        System.out.println("ID: " + filme.getIdFilme());
                        System.out.println("Titulo: " + filme.getTitulo());
                        System.out.println("Gênero: " + filme.getGenero());
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


    public void menuGenero() throws IOException{
        
    }

    public void Duvidas() {
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println(
                    "Quaisquer dúvidas relacionada a este projeto ou algum outro entre em contato\nEmail: pedroantonio5735@gmail.com");
            System.out.println("Digite qualquer coisa para sair");
            this.scanner.nextLine();
            break;
        }
    }
}
