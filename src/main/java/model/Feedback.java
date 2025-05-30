package model;
public class Feedback {
    private int idPergunta;
    private String texto;
    
    public Feedback(int idPergunta, String texto) {
        this.idPergunta = idPergunta;
        this.texto = texto;
    }

    public int getIdPergunta() {
        return idPergunta;
    }

    public String getTexto() {
        return texto;
    }

    public void setIdPergunta(int idPergunta) {
        this.idPergunta = idPergunta;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String toString() {
        return "Feedback{" +
                "idPergunta=" + idPergunta +
                ", texto='" + texto + '\'' +
                '}';
    }
}
