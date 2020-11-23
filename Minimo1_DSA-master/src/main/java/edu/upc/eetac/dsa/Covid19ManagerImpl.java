package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.Persona;
import edu.upc.eetac.dsa.models.Muestra;
import org.apache.log4j.Logger;

import java.util.*;

public class Covid19ManagerImpl implements Covid19Manager {
    private static Covid19Manager instance;
    private final Object Persona;
    //HashMap is same as Dictionary
    private HashMap<String , Persona> diccionarioPersona;
    private List<Persona> listaPersona;
    private static Logger log = Logger.getLogger(Covid19Manager.class);
    //Singleton fachada
    public static Covid19Manager getInstance(){
        if(instance == null) {
            instance = new Covid19ManagerImpl();
        }
        return instance;
    }
    //Private Constructor
    private Covid19ManagerImpl(Object muestra){
        Muestra = muestra;
        //Singleton Private Constructor
        this.diccionarioPersona = new HashMap<>();
        this.getListaMuestas() = new LinkedList<>();
    }
    @Override
    public int añadirPersona(String idPersona, String NomApell, Date FechaNacim, String Estado, List<Muestra> listaMuestras) {

        try{
            diccionarioPersona.put(idPersona,new Persona(idPersona,NomApell, FechaNacim, Estado,listaMuestras));
            log.info("Persona Añadida: " + NomApell );
            return 201; //OK CREATED
        }
        catch (IndexOutOfBoundsException e){
            log.error("UserMap Full Error");
            return 507; //INSUFFICIENT STORAGE
        }
        catch (IllegalArgumentException e){
            log.error("Incorrect format exception");
            return 400; //BAD REQUEST
        }
    }
    @Override
    public List<Persona> getListaPersona() {
        List<Persona> result = null;
        if(this.diccionarioPersona.size() !=0){
            result = new LinkedList<>(this.diccionarioPersona.values());
            log.info("Persona List: "+result.toString());
        }
        return result; //Null: 404 Empty User HashMap
    }

    @Override
    public int añadirMuestraPersona(String idMuestra, String idClinic, String idPersona, String idLAB) {
        return 0;
    }

    @Override
    public List<Muestra> getListaMuestas(String idPersona) {
        return null;
    }

    @Override
    public int añadirMuestraPersona(String idPersona, Muestra muestra) {
        if(diccionarioPersona.size() ==0){
            log.info("204: Diccionario de Personas Vacio ");
            return 204;//204 No Content
        }
            Persona temp_persona = diccionarioPersona.get(idPersona);
            if(temp_persona != null){
                int err = temp_persona.añadirMuestra(muestra);
                if(err == 201){
                    diccionarioPersona.put(idPersona,temp_persona);
                    log.info("201: Muestra añadida a la persona " + temp_persona.getNomApell());
                    return 201; //OK CREATED
                }
                else if(err == 400){
                    log.error("400: Bad Format");
                    return 400; //BAD REQUEST
                }
                else{
                    log.error("507:Insufficient storage "+ temp_persona.getNomApell());
                    return 507; //204 No Content
                }
            }
            else{
                log.error("Brote Not found");
                return 404; //Brote NOT FOUND
            }
    }

    @Override
    public List<Muestra> getListaMuestras(String IdPersona) {
        List<Muestra> listaMuestras = new LinkedList<>();
        Persona persona = getPersona(IdPersona);
        return listaMuestras;
    }
    ////////////////////EXTRAS///////////
    @Override
    public Brote getBrote(String IdBrote){
        return diccionarioBrote.get(IdBrote);
    }
    @Override
    public int numBrotes(){return this.diccionarioBrote.size();
    }
    //Generate Id
    @Override
    public String generateId(){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 3) { // length of the random generated ID
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

    @Override
    public Persona getPersona(String idPerona) {
        return null;
    }
}
