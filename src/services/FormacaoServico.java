package services;

import entities.Formação;
import entities.Usuário;
import enumerations.NivelUsuario;

import java.util.ArrayList;
import java.util.List;

import static utils.Utilidade.imprimeMensagem;
import static utils.Utilidade.sc;

public class FormacaoServico {
    public static List<Usuário> usuárioList = new ArrayList<>();

    public static void realizaMatricula(Formação formacao){
        imprimeMensagem("Na realização de matrícula, preencha todos os dados solicitados.\n");
        System.out.println("Nome :");
        String nome = sc.nextLine();
        System.out.println("Email para contato :");
        String email = sc.nextLine();
        System.out.println("Login : ");
        String login = sc.nextLine();
        System.out.println("Senha : ");
        String senha = sc.nextLine();

        Usuário usuário = new Usuário(1, nome, email, login, senha, NivelUsuario.BRONZE, formacao);

        usuárioList.add(usuário);
    }
}
