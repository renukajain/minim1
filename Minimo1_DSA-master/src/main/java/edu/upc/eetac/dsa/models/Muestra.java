package edu.upc.eetac.dsa.models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Muestra {
    private String idMuestra;
    private String idClinic;
    private String idPersona;
    private Date fechaExtraccion;
    private String idLAB
    List<Muestra> listaMuestras;
    public Muestra(String idMuestra, String idClinic, String idPersona,Date fechaExtraccion, String idLAB) {
        this.idMuestra = idMuestra;
        this.idClinic=idClinic;
        this.idPersona=idPersona;
        this.fechaExtraccion=fechaExtraccion;
        this.idLAB=idLAB;
        this.listaMuestras = new LinkedList<>();
    }
    public int AñadirMuestra(Muestra muestra) {
        int result = 201;
        try {
            this.listaMuestras.add(muestra);
        } catch (ExceptionInInitializerError e) {
            result = 400;//400 Bad Request
        } catch (IndexOutOfBoundsException e) {
            result = 507;//Insufficient storage
        }
        //201 Created
        return result;
    }
    public String getIdMuestra() {
        return idMuestra;
    }

    public void setIdMuestra(String idMuestra) {
        this.idMuestra = idMuestra;
    }

    public String getIdClinic() {
        return idClinic;
    }

    public void setIdClinic(String idClinic) {
        this.idClinic = idClinic;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public Date getFechaExtraccion() {
        return fechaExtraccion;
    }

    public void setFechaExtraccion(Date fechaExtraccion) {
        this.fechaExtraccion = fechaExtraccion;
    }

    public String getIdLAB() {
        return idLAB;
    }

    public void setIdLAB(String idLAB) {
        this.idLAB = idLAB;
    }

    public List<Muestra> getListaMuestras() {
        return listaMuestras;
    }

    public void setListaCasos(List<Muestra> listaMuestras) {
        this.listaMuestras = listaMuestras;
    }
    @Override
    public String toString(){
        return "ID Muestra: " + this.getIdMuestra() + " | ID Persona: " + this.getIdPersona() ;
    }

}
