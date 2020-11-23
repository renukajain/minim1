package edu.upc.eetac.dsa;
import edu.upc.eetac.dsa.models.*;

import java.util.Date;
import java.util.List;

public interface Covid19Manager {

    //Añadir persona
    int añadirPersona(String idPersona, String NomApell, Date FechaNacim, String Estado, List<Muestra> listaPersonas);
    //Listar personas
    List<Persona> getListaPersona();
    //Crear muestra
    int Muestra(String idMuestra, String idClinic, String idPersona, Date fechaExtraccion, String idLAB);
    //Añadir muestra a lista
    int AñadirMuestra(Muestra muestra);
    //Añadir muestra a persna
    int AñadirMuestraPersona();
    //Listado de muestras de una determinada persona
    List<Muestra> getListaMuestas(String idPersona);

    int añadirMuestraPersona(String idPersona, Muestra muestra);

    String generateId();
    Persona getPersona(String idPerona);
}
