package entities;

import enumerations.NivelConteudo;
import enumerations.NivelUsuario;
import enumerations.StatusConteudo;

public class Conteúdo {
    private int id;
    private String nome;
    private int duracao;
    private NivelConteudo nivelConteudo;
    private StatusConteudo statusConteudo;

    public Conteúdo(int id, String nome, int duracao, NivelConteudo nivelConteudo, StatusConteudo statusConteudo){
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
        this.nivelConteudo = nivelConteudo;
        this.statusConteudo = statusConteudo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public NivelConteudo getNivelConteudo() {
        return nivelConteudo;
    }

    public void setNivelConteudo(NivelConteudo nivelConteudo) {
        this.nivelConteudo = nivelConteudo;
    }

    public StatusConteudo getStatusConteudo() {
        return statusConteudo;
    }

    public void setStatusConteudo(StatusConteudo statusConteudo) {
        this.statusConteudo = statusConteudo;
    }
}
