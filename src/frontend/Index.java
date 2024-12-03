package frontend;

import java.io.IOException;

import java.util.Scanner;

public class Index {
    private Scanner scanner;

    public Index(){
        this.scanner = new Scanner(System.in);
    }


    public void iniciarMenu() throws IOException {
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("Seja Bem Vindo há aplicação de Pedrooaj!");
            System.out.println("----------------------------------------");
            System.out.println("1 - Atores            7  - Filme-Ator");
            System.out.println("2 - Funcionarios      8  - Tipo-Assento");
            System.out.println("3 - Filme             9  - Assento");
            System.out.println("4 - Gênero            10 - Sala-Assento");
            System.out.println("5 - Sessão            11 - Dúvidas");
            System.out.println("6 - Sala              0  - Sair");
            System.out.println("----------------------------------------");
            String escolha = this.scanner.nextLine();

            // menu de atores
            if (escolha.equals("1")) {
                new MenuAtor().MenuAtores(this.scanner);
            }

            // menu de funcionarios
            if (escolha.equals("2")) {
                new MenuFuncionarios().MenuFuncinarios(this.scanner);
            }
            if (escolha.equals("3")) {
                new MenuFilme().menuFilme(this.scanner);
            }
            if (escolha.equals("4")) {
                new MenuGenero().menuGenero(this.scanner);
            }
            if (escolha.equals("5")) {
                new MenuSessao().menuSessao(this.scanner);
            }

            if (escolha.equals("6")) {
                new MenuSala().menuSala(this.scanner);
            }
            if (escolha.equals("7")) {
                new MenuAtorFilme().menuFilmeAtor(this.scanner);
                
            }

            if (escolha.equals("8")) {
                new MenuTipoAssento().menuTipoAssento(this.scanner);
            }

            if (escolha.equals("9")) {
                new MenuAssento().menuAssento(this.scanner);
            }

            if(escolha.equals("10")){
                new MenuSalaAssento().menuSalaAssento(this.scanner);
            }

            if (escolha.equals("11")) {
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
