package frontend;

import java.io.IOException;

import java.util.Scanner;

public class Index {
    private Scanner scanner;
    private MenuAtor menuAtor;
    private MenuFuncionarios menuFuncionarios;
    private MenuSessao menuSessao;
    private MenuSala menuSala;
    private MenuFilme menuFilme;
    private MenuGenero menuGenero;
    private MenuAtorFilme menuAtorFilme;
    private MenuTipoAssento menuTipoAssento;
    private MenuAssento menuAssento;

    public Index() {
        this.scanner = new Scanner(System.in);
        this.menuAtor = new MenuAtor();
        this.menuFuncionarios = new MenuFuncionarios();
        this.menuSessao = new MenuSessao();
        this.menuSala = new MenuSala();
        this.menuFilme = new MenuFilme();
        this.menuGenero = new MenuGenero();
        this.menuAtorFilme = new MenuAtorFilme();
        this.menuTipoAssento = new MenuTipoAssento();
        this.menuAssento = new MenuAssento();

    }

    public void iniciarMenu() throws IOException {
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("Seja Bem Vindo há aplicação de Pedrooaj!");
            System.out.println("----------------------------------------");
            System.out.println("1 - Atores            7  - Filme-Ator");
            System.out.println("2 - Funcionarios      8  - Tipo-Assento");
            System.out.println("3 - Filme             9  - Assento");
            System.out.println("4 - Gênero            10 - Dúvidas");
            System.out.println("5 - Sessão            ");
            System.out.println("6 - Sala              0  - Sair");
            System.out.println("----------------------------------------");
            String escolha = this.scanner.nextLine();

            // menu de atores
            if (escolha.equals("1")) {
                this.menuAtor.MenuAtores(this.scanner);
            }

            // menu de funcionarios
            if (escolha.equals("2")) {
                this.menuFuncionarios.MenuFuncinarios(this.scanner);
            }
            if (escolha.equals("3")) {
                this.menuFilme.menuFilme(this.scanner);
            }
            if (escolha.equals("4")) {
                this.menuGenero.menuGenero(this.scanner);
            }
            if (escolha.equals("5")) {
                this.menuSessao.menuSessao(this.scanner);
            }

            if (escolha.equals("6")) {
                this.menuSala.menuSala(this.scanner);
            }
            if (escolha.equals("7")) {
                this.menuAtorFilme.menuFilmeAtor(this.scanner);
                
            }

            if (escolha.equals("8")) {
                this.menuTipoAssento.menuTipoAssento(scanner);
            }

            if (escolha.equals("9")) {
                this.menuAssento.menuAssento(scanner);
            }

            if (escolha.equals("10")) {
                this.Duvidas();
            }

            if (escolha.equals("0")) {
                this.scanner.close();
                break;
            }

        }
    }

    public void Duvidas() {
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println(
                    "Quaisquer dúvidas relacionada a este projeto ou algum outro entre em contato\nEmail: pedroantonio5735@gmail.com");
            System.out.println("Pressione enter para voltar");
            this.scanner.nextLine();
            break;
        }
    }
}
