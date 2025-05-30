package model;
public class Resposta {
    private int id;
    private int idPergunta;
    private String textoResposta;
    private boolean correta;

    public Resposta(int id, int idPergunta, String textoResposta, boolean correta) {
        this.id = id;
        this.idPergunta = idPergunta;
        this.textoResposta = textoResposta;
        this.correta = correta;
    }

    public int getId() {
        return id;
    }
    public int getIdPergunta() {
        return idPergunta;
    }
    public String getTextoResposta() {
        return textoResposta;
    }
    public boolean isCorreta() {
        return correta;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setIdPergunta(int idPergunta) {
        this.idPergunta = idPergunta;
    }
    public void setTextoResposta(String textoResposta) {
        this.textoResposta = textoResposta;
    }
    public void setCorreta(boolean correta) {
        this.correta = correta;
    }

    public String toString() {
        return "Resposta{" +
                "id=" + id +
                ", idPergunta=" + idPergunta +
                ", textoResposta='" + textoResposta + '\'' +
                ", correta=" + correta +
                '}';
    }
}