package model;
public class Usuario {
    protected int id;
    protected String nome;
    protected String email;
    protected String senha;
    protected TipoUsuario tipo;
    protected int pontuacao;
    protected boolean ajudaDisponivel;
    protected int saldo;

    //Construtor completo (com ID)
    public Usuario(int id, String nome, String email, String senha, TipoUsuario tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    //Construtor para novos usuários (ex: cadastro)
    public Usuario(String nome, String email, String senha, TipoUsuario tipo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
        this.pontuacao = 0;
        this.ajudaDisponivel = true;
        this.saldo = 0;
    }

    // Getters
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

    public boolean isAjudaDisponivel() {
        return ajudaDisponivel;
    }

    public int getSaldo() {
        return saldo;
    }

    // Setters
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

    public void setAjudaDisponivel(boolean ajudaDisponivel) {
        this.ajudaDisponivel = ajudaDisponivel;
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