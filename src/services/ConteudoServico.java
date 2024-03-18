package services;

import entities.Conteúdo;
import entities.Formação;
import entities.Usuário;
import enumerations.NivelConteudo;
import enumerations.NivelUsuario;
import enumerations.StatusConteudo;
import enumerations.StatusFormação;

import java.util.*;

import static utils.Utilidade.imprimeMensagem;
import static utils.Utilidade.sc;

public class ConteudoServico {

    public static List<Conteúdo> armazenaConteudos(){
        List<Formação> listaFormações = new ArrayList<>();
        List<Conteúdo> listaConteudos = new ArrayList<>();
        listaConteudos.add(new Conteúdo(1456, "Lógica de programação com Java", 12, NivelConteudo.FÁCIL, StatusConteudo.PENDENTE));
        listaConteudos.add(new Conteúdo(1478, "Criando um sistema de gerenciamento farmacêutico com Java", 15, NivelConteudo.INTERMEDIÁRIO, StatusConteudo.PENDENTE));
        listaConteudos.add(new Conteúdo(1489, "Gerando uma API Rest com Spring Boot num sistema de gestão eleitoral na web", 15, NivelConteudo.INTERMEDIÁRIO, StatusConteudo.PENDENTE));
        listaConteudos.add(new Conteúdo(1497, "Criando um sistema de mensageria na Cloud AWS com Quarkus e Apache Kafka", 18, NivelConteudo.AVANÇADO, StatusConteudo.PENDENTE));

        listaFormações.add(new Formação("Desenvolvimento Backend Java", 60, StatusFormação.INICIADA, listaConteudos));

        return listaConteudos;
    }
    public static void defineConteudo(Usuário usuário, Formação formação){
        List<Conteúdo> lista = armazenaConteudos();
        imprimeMensagem("Temos aqui a formação por conteúdos.\n O que você tem a aprender:\n");
        System.out.println("Desenvolvimento backend com Java.\n");

        for (Conteúdo conteúdo : lista){
            imprimeMensagem("\nCódigo : " + conteúdo.getId() +
                            "\nNome : " + conteúdo.getNome() +
                            "\nNível do conteúdo : " + conteúdo.getNivelConteudo() +
                            "\nStatus do conteúdo : " + conteúdo.getStatusConteudo());
        }
    }
    public static Conteúdo gerenciaConteudos(Usuário usuário, Formação formação, List<Conteúdo> conteudosFinalizados){
        defineConteudo(usuário, formação);
        formação.setStatusFormação(StatusFormação.INICIADA);
        Conteúdo idEncontrado = null;
        imprimeMensagem("Aqui você gerencia seus conteúdos da sua formação, não há restrição de nível, pode\n" +
                "consumir da maneira que achar melhor, de tal modo que quando terminar, digite o código do conteúdo\n" +
                "a fim de receber seu certificado.\n");
        do{
            System.out.println("Código do conteúdo ou -1 a fim de sair do loop:");
            int id = sc.nextInt();

            if (id == -1){
                break;
            }

            for (Conteúdo conteúdo : armazenaConteudos()){
                if (id == conteúdo.getId()){
                    idEncontrado = conteúdo;
                    break;
                }
            }
            if (idEncontrado != null) {
                if (idEncontrado.getStatusConteudo() != StatusConteudo.CONCLUÍDO){
                    System.out.println("Conteúdo " + idEncontrado.getId() + ", " + idEncontrado.getNome() +
                            " finalizado com sucesso.\n");
                    idEncontrado.setStatusConteudo(StatusConteudo.CONCLUÍDO);
                    aumentaNivel(usuário, idEncontrado);
                    comprovaFimConteudo(usuário, idEncontrado);
                    conteudosFinalizados.add(idEncontrado);
                }
                else{
                    System.out.println("Você já concluiu esse conteúdo.\n");
                }
            }
            else{
                System.out.println("Código não reconhecido.\n");
            }
        } while(true);
        return idEncontrado;
    }
    private static void comprovaFimConteudo(Usuário usuário, Conteúdo conteúdo){
        imprimeMensagem("Comprovamos que " + usuário.getNome() + " concluiu com sucesso o conteúdo" +
                " de " + conteúdo.getNome() + " com duração de " + conteúdo.getDuracao() + " horas.\n");
    }
    public static void listaFinalizados(List<Conteúdo>conteudosFinalizados){
        imprimeMensagem("Os conteúdos finalizados representam avanços extraordinários em sua carreira.\n");
        for (Conteúdo conteudo : conteudosFinalizados) {
            System.out.println("Código : " + conteudo.getId() +
                    "\n         Nome : " + conteudo.getNome() +
                    "\n         Duração : " + conteudo.getDuracao() +
                    "\n         Nível do conteúdo : " + conteudo.getNivelConteudo() +
                    "\n         Status do conteúdo : " + conteudo.getStatusConteudo());
        }
    }
    private static void aumentaNivel(Usuário usuário, Conteúdo conteúdo){
        if (conteúdo.getStatusConteudo() == StatusConteudo.CONCLUÍDO){
            switch(usuário.getNivel()){
                case NICKEL -> usuário.setNivel(NivelUsuario.BRONZE);
                case BRONZE -> usuário.setNivel(NivelUsuario.SILVER);
                case SILVER -> usuário.setNivel(NivelUsuario.GOLD);
                case GOLD -> usuário.setNivel(NivelUsuario.PLATINUM);
                case PLATINUM -> usuário.setNivel(NivelUsuario.PLATINUM);
                default -> usuário.getNivel();
            }
        }
    }
}
