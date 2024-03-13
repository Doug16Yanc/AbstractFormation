package entities;

import enumerations.StatusFormação;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Formação {
    private String nome;
    private int duracao;
    private StatusFormação statusFormação;
    private List<Conteúdo> conteúdoList = new ArrayList<>();

    public Formação(String nome, int duracao, StatusFormação statusFormação, List<Conteúdo> conteúdoList){
        this.nome = nome;
        this.duracao = duracao;
        this.statusFormação = statusFormação;
        this.conteúdoList = conteúdoList;
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

    public StatusFormação getStatusFormação() {
        return statusFormação;
    }

    public void setStatusFormação(StatusFormação statusFormação) {
        this.statusFormação = statusFormação;
    }

    public List<Conteúdo> getConteúdoList() {
        return conteúdoList;
    }

    public void setConteúdoList(List<Conteúdo> conteúdoList) {
        this.conteúdoList = conteúdoList;
    }
}
