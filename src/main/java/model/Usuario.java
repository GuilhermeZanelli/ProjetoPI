package model;

public class Usuario {

    protected int id;
    protected String nome;
    protected String email;
    protected String senha;
    protected TipoUsuario tipo;
    protected int pontuacao;
    protected int ajudaDisponivel;
    protected int saldo;

    //Construtor vazio
    public Usuario() {
        this.pontuacao = 0;
        this.ajudaDisponivel = 3;
        this.saldo = 0;
    }

    //Construtor completo
    public Usuario(int id, String nome, String email, String senha, TipoUsuario tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    //Construtor para novos usuÃ¡rios
    public Usuario(String nome, String email, String senha, TipoUsuario tipo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
        this.pontuacao = 0;
        this.ajudaDisponivel = 3;
        this.saldo = 0;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public boolean ajudaDisponivel() {
        return ajudaDisponivel > 0;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public void setAjudaDisponivel(int ajudaDisponivel) {
        this.ajudaDisponivel = ajudaDisponivel;
    }

    public void useAjudaDisponivel() {
        this.ajudaDisponivel -= 1;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", tipo=" + tipo +
                ", pontuacao=" + pontuacao +
                ", ajudaDisponivel=" + ajudaDisponivel +
                ", saldo=" + saldo +
                '}';
    }
}