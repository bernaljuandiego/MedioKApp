package co.edu.konrad.mediokapp.entities;

public class Carreer {
    private int idCarreer;
    private String nameCarreer;
    private Faculty faculty;

    public Carreer(int idCarreer, String nameCarreer, Faculty faculty) {
        this.idCarreer = idCarreer;
        this.nameCarreer = nameCarreer;
        this.faculty = faculty;
    }

    public int getIdCarreer() {
        return idCarreer;
    }

    public void setIdCarreer(int idCarreer) {
        this.idCarreer = idCarreer;
    }

    public String getNameCarreer() {
        return nameCarreer;
    }

    public void setNameCarreer(String nameCarreer) {
        this.nameCarreer = nameCarreer;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
