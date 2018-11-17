package co.edu.konrad.mediokapp.entities;

import java.util.Date;

public class Persona {

    private String codigo;
    private String nombre;
    private String apellido;
    private String facultad;
    private String programa;
    private String jornada;
    private Date fechaRegistro;

    public Persona(String codigo, String nombre, String apellido, String facultad, String programa, String jornada, Date fechaRegistro) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.facultad = facultad;
        this.programa = programa;
        this.jornada = jornada;
        this.fechaRegistro = fechaRegistro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", facultad='" + facultad + '\'' +
                ", programa='" + programa + '\'' +
                ", jornada='" + jornada + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
