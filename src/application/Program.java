package application;

import utils.Utilidade;

import static utils.Utilidade.imprimeMensagem;
import static utils.Utilidade.sc;

public class Program {
    public static void main(String[] args) {
        System.out.println("Já é cadastrado na plataforma? " +
                "           S/s - Sim\n" +
                "           N\n - Não\n" +
                "           O\\o - Sair\n");
        String opcao = sc.nextLine();

        switch (opcao.toLowerCase()){
            case "s" -> {

            }
            case "n" -> {

            }
            case "o" -> {
                imprimeMensagem("Sua ausência é sempre desoladora e dolorosa, espero te ver logo!\n");
            }
            default -> {
                imprimeMensagem("Opção impossível!\n");
            }
        }

    }
}