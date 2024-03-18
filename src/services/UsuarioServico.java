package services;

import application.Program;
import entities.Conteúdo;
import entities.Formação;
import entities.Usuário;

import java.util.ArrayList;
import java.util.List;

import static application.Program.fazPrimeiraInteraçao;
import static services.ConteudoServico.*;
import static services.CustoServico.mostraCusto;
import static services.FormacaoServico.usuárioList;
import static utils.Utilidade.imprimeMensagem;
import static utils.Utilidade.sc;

public class UsuarioServico {

    private static Usuário procuraUsuario(int numero){
        Usuário usuário = null;
        for (Usuário usuário1 : usuárioList){
            if (numero == usuário1.getId()){
                usuário = usuário1;
                break;
            }
        }
        return usuário;
    }
    public static boolean fazerLogin(Formação formação){
        imprimeMensagem("Digite o seu número identificador:");
        System.out.println("Número :");
        int id = sc.nextInt();

        Usuário usuário = procuraUsuario(id);
        sc.nextLine();
        if (usuário != null){
            System.out.println("Entre com suas credenciais: ");
            System.out.println("Login : ");
            String login = sc.nextLine();
            System.out.println("Senha : ");
            String senha = sc.nextLine();

            if(login.equals(usuário.getLogin()) && senha.equals(usuário.getSenha())){
                System.out.println("Login realizado com sucesso.\n");
                lidaComUsuário(usuário, formação);
                return true;
            }
            else{
                imprimeMensagem("Credenciais inválidas.\n");
                return false;
            }
        }
        else{
            imprimeMensagem("Usuário não encontrado.\n");
            return false;
        }
    }
    private static void lidaComUsuário(Usuário usuário, Formação formação){
        List<Conteúdo> conteudosFinalizados = new ArrayList<>();
        boolean saiu = false;
        imprimeMensagem("Seja bem-vindo(a) à nossa plataforma, caríssimo(a) " + usuário.getNome() + "\n");
        do {
            System.out.println("O que temos para hoje?\n" +
                    "           1 - Visualizar dados\n" +
                    "           2 - Alterar dados\n" +
                    "           3 - Ir para conteúdo\n" +
                    "           4 - Visualizar conteúdos já finalizados\n" +
                    "           5 - Ver custo de uma nova formação não gratuita\n" +
                    "           6 - Sair da conta\n");
            int opcao = sc.nextInt();

            switch(opcao){
                case 1 -> {
                    consultarDados(usuário);
                }
                case 2 -> {
                    alterarDados(usuário);
                    saiu = true;
                }
                case 3 -> {
                    gerenciaConteudos(usuário, formação, conteudosFinalizados);
                }
                case 4 -> {
                    listaFinalizados(conteudosFinalizados);
                }
                case 5 -> {
                    mostraCusto(usuário, formação);
                }
                case 6 -> {
                    imprimeMensagem("Sua ausência é desoladora, espero que volte logo.\n");
                    saiu = true;
                }
                default -> {
                    imprimeMensagem("Opção impossível.\n");
                }
            }
            if (saiu){
                break;
            }
        } while(true);
    }
    private static void consultarDados(Usuário usuário){
        imprimeMensagem("Aqui você pode consultar seus dados.\n" +
                "\n     > Nome : " + usuário.getNome()  +
                "\n     > Número identificador : " + usuário.getId() +
                "\n     > Email : " + usuário.getEmail() +
                "\n     > Nível usuário : " + usuário.getNivel());
    }
    private static boolean alterarDados(Usuário usuário){
        sc.nextLine();
        System.out.println("Você pode alterar email, login e senha.\n");
        System.out.println("Realizaremos verificação em duas etapas.\n");
        System.out.println("\n" +
                "           E/e - Email\n" +
                "           L/l - Login\n" +
                "           S/s - Senha\n");
        String opcao = sc.nextLine();

        switch(opcao.toLowerCase()){
            case "e" -> {
                System.out.println("Digite seu email atual: ");
                String email = sc.nextLine();
                if (usuário.getEmail().equals(email)){
                    System.out.println("Novo email:");
                    String novoEmail = sc.nextLine();
                    usuário.setEmail(novoEmail);
                    System.out.println("Alteração de email realizada com sucesso, faça login novamente.\n");

                }
                else{
                    System.out.println("Email não reconhecido.\n");
                }

            }
            case "l" -> {
                System.out.println("Digite seu login atual: ");
                String login = sc.nextLine();
                if (usuário.getLogin().equals(login)) {
                    System.out.println("Novo login:");
                    String novoLogin = sc.nextLine();
                    usuário.setLogin(novoLogin);
                    System.out.println("Alteração de login realizada com sucesso, faça login novamente.\n");
                }
                else{
                    System.out.println("Login não reconhecido.\n");
                }
            }
            case "s" -> {
                System.out.println("Digite sua senha atual: ");
                String senha = sc.nextLine();
                if (usuário.getSenha().equals(senha)) {
                    System.out.println("Nova senha:");
                    String novaSenha = sc.nextLine();
                    usuário.setSenha(novaSenha);
                    System.out.println("Alteração de senha realizada com sucesso, faça login novamente.\n");
                }
                else{
                    System.out.println("Senha não reconhecida.\n");
                }
            }
            default -> {
                imprimeMensagem("Opção indisponível.\n");
            }
        }
        return true;
    }
}
