package model;
public class Estatistica {
    private int idUsuario;
    private int totalPerguntasRespondidas;
    private int totalCorretas;
    private int totalErradas;

    public Estatistica(int idUsuario, int totalPerguntasRespondidas, int totalCorretas, int totalErradas) {
        this.idUsuario = idUsuario;
        this.totalPerguntasRespondidas = totalPerguntasRespondidas;
        this.totalCorretas = totalCorretas;
        this.totalErradas = totalErradas;
    }

    // Getters
    public int getIdUsuario() { return idUsuario; }
    public int getTotalRespondidas() { return totalPerguntasRespondidas; }
    public int getTotalCorretas() { return totalCorretas; }
    public int getTotalErradas() { return totalErradas; }

    // Setters
    public void setTotalRespondidas(int totalRespondidas) { this.totalPerguntasRespondidas = totalRespondidas; }
    public void setTotalCorretas(int totalCorretas) { this.totalCorretas = totalCorretas; }
    public void setTotalErradas(int totalErradas) { this.totalErradas = totalErradas; }

    // Calcula o aproveitamento percentual de acertos do usuário.
    public int getAproveitamento() {
        if (totalPerguntasRespondidas == 0) return 0;
        return (int) ((double) totalCorretas / totalPerguntasRespondidas * 100);
    }

    public String toString() {
        return String.format("Estatistica{idUsuario=%d, respondidas=%d, corretas=%d, erradas=%d}",
                idUsuario, totalPerguntasRespondidas, totalCorretas, totalErradas);
    }
}