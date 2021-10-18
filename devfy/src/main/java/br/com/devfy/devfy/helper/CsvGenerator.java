package br.com.devfy.devfy.helper;

import br.com.devfy.devfy.model.Projeto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CsvGenerator {
    public static FileWriter gravaArquivoCsv (ListaObj<Projeto> lista, String nomeArq) {
        FileWriter arq = null;     // objeto que representa o arquivo a ser gravado
        Formatter saida = null;    // objeto que usaremos para escrever no arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";         // acrescenta a extensão .csv ao nome do arquivo

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileWriter(nomeArq,false);   // abre o arquivo nomeArq
            saida = new Formatter(arq);     // associa o objeto saida ao arquivo
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        // Bloco try-catch para percorrer a lista e gravar no arquivo
        try {

            for (int i = 0; i < lista.getSize(); i++) {
                Projeto proj = lista.getElemento(i);
                saida.format(
                        "%d;%s;%.1f;%s;%d;%s;%s;%s;%s;%.1f;%d;%s;%s;%s;%s\n",
                        proj.getId(),
                        proj.getTitulo(),
                        proj.getValor(),
                        proj.getLinguagem(),
                        proj.getDesenvolvedor().getId(),
                        proj.getDesenvolvedor().getUsuario(),
                        proj.getDesenvolvedor().getCpf(),
                        proj.getDesenvolvedor().getEmail(),
                        proj.getDesenvolvedor().getTelefone(),
                        proj.getDesenvolvedor().getValorHora(),
                        proj.getEmpresa().getId(),
                        proj.getEmpresa().getUsuario(),
                        proj.getEmpresa().getCnpj(),
                        proj.getEmpresa().getEmail(),
                        proj.getEmpresa().getTelefone()
                );
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar no arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }

        return arq;
    }

    public static String leArquivoCsv (String nomeArq) {
        FileReader arq = null;  // objeto que representa o arquivo para leitura
        Scanner entrada = null; // objeto usado para ler do arquivo
        Boolean deuRuim = false;
        StringBuilder csv = new StringBuilder();
        nomeArq += ".csv";

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileReader(nomeArq);
            /* Cria o objeto do Scanner, informando que o delimitador é
               o ';' OU o '\n'  */
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        // Bloco try-catch para ler do arquivo
        try {
            csv.append(String.format("%10s %-20s %10s %-13s %6s %-16s %11s %-25s %12s %10s %10s %-20s %14s %-25s %14s\n",
                    "ID PROJETO","TITULO", "VALOR", "LINGUAGEM", "DEV ID", "DEV", "DEV CPF", "DEV EMAIL", "DEV TELEFONE",
                    "DEV $/h", "EMPRESA ID", "EMPRESA", "EMPRESA CNPJ", "EMPRESA EMAIL", "EMPRESA TEL"));

            while (entrada.hasNext()) {  //enquanto não for final do arquivo
                int idEmpresa = entrada.nextInt();
                String titulo = entrada.next();
                Double valor = entrada.nextDouble();
                String linguagem = entrada.next();
                int devId = entrada.nextInt();
                String devNome = entrada.next();
                String devCpf = entrada.next();
                String devEmail = entrada.next();
                String devTel = entrada.next();
                Double devValorHora = entrada.nextDouble();
                int empId = entrada.nextInt();
                String empresa = entrada.next();
                String empCnpj = entrada.next();
                String empEmail = entrada.next();
                String empTel = entrada.next();
                csv.append(String.format("%10d %-20s %10.1f %-13s %6d %-16s %11s %-25s %12s %10.1f %10d %-20s %14s %-25s %14s\n",
                        idEmpresa, titulo, valor, linguagem, devId, devNome, devCpf, devEmail, devTel, devValorHora, empId
                        , empresa, empCnpj, empEmail, empTel)) ;
            }
        }
        catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        }
        catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    return  csv.toString();
    }
}
