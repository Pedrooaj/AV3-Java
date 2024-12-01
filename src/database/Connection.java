package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Connection<T> {
    private T tipo;

    public void setTipo(T tipo) {
        this.tipo = tipo;
    }

    public T getTipo() {
        return tipo;
    }

    // Método responsavel por adicionar na tabela
    public boolean post(String valor, String name) throws IOException {
        try {
            String url = "src/database/tables/" + name + ".txt";

            FileWriter fw = new FileWriter(url, true);
            BufferedWriter bw = new BufferedWriter(fw);
            String[] id = valor.split(";");
            String[] response = this.get(id[0], name);

            if (response.length == 0) { // Nenhum registro encontrado
                bw.write(valor);
                bw.newLine();
                bw.close();
                return true;
            } else if (!response[0].equals(id[0])) { // Item diferente encontrado
                bw.write(valor);
                bw.newLine();
                bw.close();
                return true;
            } else {
                bw.close();
                System.out.println("Identificador já existe!");
                return false;
            }
        } catch (FileNotFoundException e) {
            throw e;
        }
    }

    // Método para retornar um item
    public String[] get(String valor, String name) throws IOException {
        try {
            String url = "src/database/tables/" + name + ".txt";
            FileReader fr = new FileReader(url);
            BufferedReader bf = new BufferedReader(fr);
            String linha;
            while ((linha = bf.readLine()) != null) {
                if (valor.equals(linha.split(";")[0])) {
                    bf.close();
                    return linha.split(";");
                }
            }
            bf.close();
            return new String[0];
        } catch (FileNotFoundException e) {
            throw e;
        }
    }

    // Método para realizar edição nas tabelas
    public boolean put(String valor, String name) throws IOException {
        String url = "src/database/tables/" + name + ".txt";
        FileReader fr = new FileReader(url);
        BufferedReader br = new BufferedReader(fr);

        boolean retorno = false;
        ArrayList<String> linhas = new ArrayList<>();
        String splitValor[] = valor.split(";");
        String linha;

        // Ler o arquivo linha por linha
        while ((linha = br.readLine()) != null) {
            // Verificar se o ID da linha é igual ao ID passado
            if (linha.split(";")[0].equals(splitValor[0])) {
                linha = valor; // Substitui a linha com o novo valor
                retorno = true;
            }
            linhas.add(linha);
        }
        br.close();

        if (retorno) {
            // Abrir o arquivo para sobrescrever (false: sobrescreve o arquivo)
            FileWriter fw = new FileWriter(url, false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String l : linhas) {
                bw.write(l); // Escreve a linha no arquivo
                bw.newLine(); // Adiciona uma nova linha
            }
            bw.close();
            return true; // Indica que a operação foi bem-sucedida
        } else {
            System.out.println("Id não encontrado");
            return false;
        }
    }

    public ArrayList<String> getAll(String name) throws IOException {
        try {
            String url = "src/database/tables/" + name + ".txt";
            FileReader fr = new FileReader(url);
            BufferedReader br = new BufferedReader(fr);
            String linha;
            ArrayList<String> linhas = new ArrayList<>();

            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }

            br.close();
            return linhas;
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao obter tabela");
            throw e;
        }
    }

}
