package model;
public class HistoricoResposta {
    private int idUsuario;
    private String respostasJson; // Armazena o JSON como string
    public HistoricoResposta(int idUsuario, String respostasJson) {
        this.idUsuario = idUsuario;
        this.respostasJson = respostasJson;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getRespostasJson() {
        return respostasJson;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setRespostasJson(String respostasJson) {
        this.respostasJson = respostasJson;
    }

    public String toString() {
        return "HistoricoResposta{" +
                "idUsuario=" + idUsuario +
                ", respostasJson='" + respostasJson + '\'' +
                '}';
    }
}
