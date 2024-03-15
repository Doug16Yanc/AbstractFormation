package application;

//Programa feito por Douglas Holanda
//O programa realiza o gerenciamento de uma plataforma de estudos em programação
//e tem como entidade única o usuário que realiza uma formação que contém vários
//conteúdos, para ser mais metalinguístico, a formação é única e consiste em
//dominar a linguagem Java para o desenvolvimento backend, de tal maneira que
//os conteúdos são todos referentes à linguagem e suas tecnologias assim associadas.

import entities.Formação;
import enumerations.StatusFormação;

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