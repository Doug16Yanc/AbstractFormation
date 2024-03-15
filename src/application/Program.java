package application;

import entities.Formação;
import enumerations.StatusFormação;
import utils.Utilidade;

import static services.FormacaoServico.realizaMatricula;
import static services.UsuarioServico.fazerLogin;
import static utils.Utilidade.imprimeMensagem;
import static utils.Utilidade.sc;

public class Program {
    public static void main(String[] args) {
        fazPrimeiraInteraçao();
    }
    public static void fazPrimeiraInteraçao(){
        Formação formacao = new Formação("", 12, StatusFormação.NÃO_INICIADA, null);
        do {
            System.out.println("Já é cadastrado na plataforma?\n" +
                    "           S/s - Sim\n" +
                    "           N/n - Não\n" +
                    "           O\\o - Sair\n");
            String opcao = sc.nextLine();

            switch (opcao.toLowerCase()) {
                case "s" -> {
                    fazerLogin();
                }
                case "n" -> {
                    realizaMatricula(formacao);
                }
                case "o" -> {
                    imprimeMensagem("Sua ausência é sempre desoladora e dolorosa, espero te ver logo!\n");
                }
                default -> {
                    imprimeMensagem("Opção impossível!\n");
                }
            }
        } while(true);
    }
}