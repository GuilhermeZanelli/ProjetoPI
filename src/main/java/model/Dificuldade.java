package model;
public class Dificuldade {
    private int id;
    private String nivel;
    public Dificuldade(int id, String nivel) {
        this.id = id;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String toString() {
        return "Dificuldade{" +
                "id=" + id +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}