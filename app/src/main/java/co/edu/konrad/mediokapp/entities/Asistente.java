package co.edu.konrad.mediokapp.entities;


public class Asistente {
    private int cedulaAsistente;
    private int codigoAsistente;
    private String nombreAsistente;
    private String apellidoAsistente;
    private TipoUsuario tipoUsuario;
    private Jornada jornada;
    private Carreer carreer;

    public Asistente(int cedulaAsistente, int codigoAsistente, String nombreAsistente, String apellidoAsistente, TipoUsuario tipoUsuario, Jornada jornada, Carreer carreer) {
        this.cedulaAsistente = cedulaAsistente;
        this.codigoAsistente = codigoAsistente;
        this.nombreAsistente = nombreAsistente;
        this.apellidoAsistente = apellidoAsistente;
        this.tipoUsuario = tipoUsuario;
        this.jornada = jornada;
        this.carreer = carreer;
    }

    public int getCedulaAsistente() {
        return cedulaAsistente;
    }

    public void setCedulaAsistente(int cedulaAsistente) {
        this.cedulaAsistente = cedulaAsistente;
    }

    public int getCodigoAsistente() {
        return codigoAsistente;
    }

    public void setCodigoAsistente(int codigoAsistente) {
        this.codigoAsistente = codigoAsistente;
    }

    public String getNombreAsistente() {
        return nombreAsistente;
    }

    public void setNombreAsistente(String nombreAsistente) {
        this.nombreAsistente = nombreAsistente;
    }

    public String getApellidoAsistente() {
        return apellidoAsistente;
    }

    public void setApellidoAsistente(String apellidoAsistente) {
        this.apellidoAsistente = apellidoAsistente;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public Carreer getCarreer() {
        return carreer;
    }

    public void setCarreer(Carreer carreer) {
        this.carreer = carreer;
    }
}
