package model;

public class Coordenador extends Usuario {
    private int idCadastradoPor;
    public Coordenador() {
        super();
    }

    public Coordenador(int id, String nome, String email, String senha, TipoUsuario tipoUsuario) {
        super(id, nome, email, senha, tipoUsuario);
    }

    public Coordenador(String nome, String email, String senha, TipoUsuario tipoUsuario) {
        super(nome, email, senha, tipoUsuario);
    }

    public int getIdCadastradoPor() {
        return idCadastradoPor;
    }

    public void setIdCadastradoPor(int idCadastradoPor) {
        this.idCadastradoPor = idCadastradoPor;
    }
}