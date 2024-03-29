package entities;

import enumerations.NivelUsuario;

public class Usuário {
    private int id;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private NivelUsuario nivel;
    private Formação formação;

    public Usuário(int id, String nome, String email, String login, String senha, NivelUsuario nivel, Formação formação){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.nivel = nivel;
        this.formação = formação;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public NivelUsuario getNivel() {
        return nivel;
    }

    public void setNivel(NivelUsuario nivel) {
        this.nivel = nivel;
    }

    public Formação getFormação() {
        return formação;
    }

    public void setFormação(Formação formação) {
        this.formação = formação;
    }
}
