package model;
public class Ajuda {
    private int idUsuario;
    private boolean disponivel;
    private int quantidade;
    public Ajuda(int idUsuario, boolean disponivel, int quantidade) {
        this.idUsuario = idUsuario;
        this.disponivel = disponivel;
        this.quantidade = quantidade;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String toString() {
        return "Ajuda{" +
                "idUsuario=" + idUsuario +
                ", disponivel=" + disponivel +
                ", quantidade=" + quantidade +
                '}';
    }
}