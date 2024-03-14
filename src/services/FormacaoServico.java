package services;

import entities.Formação;
import entities.Usuário;
import enumerations.NivelUsuario;

import java.util.*;

import static utils.Utilidade.imprimeMensagem;
import static utils.Utilidade.sc;

public class FormacaoServico {
    public static List<Usuário> usuárioList = new ArrayList<>();
    private static int gerarId() {
        Random random = new Random();
        int entrada = random.nextInt(10000 - 100) + 100;

        while (entrada != 1) {
            boolean auxiliar = true;
            for (int i = 0; i < usuárioList.size(); i++) {
                if (entrada == usuárioList.get(i).getId()) {
                    auxiliar = false;
                    break;
                }
            }

            if (auxiliar) {
                return entrada;
            } else {
                entrada = random.nextInt(10000 - 100) + 100;
            }
        }

        return entrada;
    }

    public static void realizaMatricula(Formação formacao){
        imprimeMensagem("Na realização de matrícula, preencha todos os dados solicitados.\n");
        int id = gerarId();
        System.out.println("Nome :");
        String nome = sc.nextLine();
        System.out.println("Email para contato :");
        String email = sc.nextLine();
        System.out.println("Login : ");
        String login = sc.nextLine();
        System.out.println("Senha : ");
        String senha = sc.nextLine();

        Usuário usuário = new Usuário(id, nome, email, login, senha, NivelUsuario.BRONZE, formacao);

        usuárioList.add(usuário);

        comprovaMatricula(usuário);
    }
    private static void comprovaMatricula(Usuário usuário){
        Date currentDate = new Date();
        imprimeMensagem("Comprovante de matrícula na formação:\n" +
                "       Número do inscrito : " + usuário.getId() + "\n" +
                "       Nome : " + usuário.getNome() + "\n" +
                "       Email : " + usuário.getEmail() + "\n" +
                "       Nível do usuário : " + usuário.getNivel() + "\n\n" +
                "       Dados da operação\n\n" +
                "       Código : " + UUID.randomUUID() + "\n" +
                "       Data : " + currentDate);
    }
}
