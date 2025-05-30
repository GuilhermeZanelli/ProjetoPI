package model;
public enum TipoUsuario {
    ALUNO("Aluno"),
    PROFESSOR("Professor"),
    COORDENADOR("Coordenador");

    private final String descricao;
    TipoUsuario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoUsuario from(String nome) {
        return TipoUsuario.valueOf(nome.toUpperCase());
    }
}
