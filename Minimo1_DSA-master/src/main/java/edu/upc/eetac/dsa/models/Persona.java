package edu.upc.eetac.dsa.models;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Persona {
    //Formato
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String NomApell;
    String idPersona;
    Date fechaNacim;
    String estado;
    //Constructor sin inicializacion
    public Persona(String idPersona, String nomApell, Date fechaNacim, String estado, List<Muestra> listaMuestras){

    }

    public Persona( String idPersona ,String NomApell, Date fechaNacim, String Estado ) {
        this.idPersona = idPersona;
        this.NomApell = NomApell;
        this.fechaNacim = fechaNacim;
        this.estado = Estado;
    }
    public String getNomApell() {
        return NomApell;
    }

    public void setNomApell(String name) {
        this.NomApell = name;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String id) {
        this.idPersona = id;
    }

    public Date getFechaNacim() {
        return fechaNacim;
    }

    public void setFechaNacim(Date fecha) {
        this.fechaNacim = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int añadirMuestra(Muestra muestra) {
    }

    public int getNumMuestra(){
        return listaMuestras;
    }
}
