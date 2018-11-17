package co.edu.konrad.mediokapp.entities;

public class Asistencia {
    private Asistente asistente;
    private String fecha;
    private String uso;

    public Asistencia() {
    }

    public Asistente getAsistente() {
        return asistente;
    }

    public void setAsistente(Asistente asistente) {
        this.asistente = asistente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public Asistencia(Asistente asistente, String fecha, String uso) {

        this.asistente = asistente;
        this.fecha = fecha;
        this.uso = uso;
    }
}
