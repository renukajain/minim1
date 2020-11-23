package edu.upc.eetac.dsa;
import edu.upc.eetac.dsa.models.*;
import org.apache.log4j.Logger;
//Junit 4.13
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
public class Covid19ManagerImplTest {
    // THE QUICK REMINDER: Remember to name the test class public smh
    //Log4j Logger initialization
    private static Logger logger = Logger.getLogger(Covid19ManagerImplTest.class);
    //GameManager
    public Covid19Manager manager = null;
    //Estructura de datos
    Brote brote;
    List<Caso> listaCasos;
    //Metodo SetUp
    @Before
    public void setUp() {
        //Configuring Log4j
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        logger.debug("Debug Test Message!");
        logger.info("Info Test Message!");
        logger.warn("Warning Test Message!");
        logger.error("Error Test Message!");
        //Instancing GameManager Implementation
        manager = Covid19ManagerImpl.getInstance();
        //Initializing Object List
        listaCasos =  new LinkedList<Caso>();
        //Appending Caso en Lista
        //Example Date firstDate3 = new Date(int year, int month, int date, int hrs, int min, int sec);
        Date dataNacimiento = new Date(1997,9,23,16,55,20);
        Date dataInforme = new Date(2020,04,12,05,10,10);
        //Caso( String idCaso,String nombre, String apellidos, String genero, String correo, String direccion, Date fechaNacimiento,Date fechaInforme, String nivelRiesgo, String classificacion, int telefono)
        listaCasos.add(new Caso("001","Midoriya","izuku","H","midoriya@ua.com","Musutafu, Japan", dataNacimiento,dataInforme,"medio","sospechoso",993355));
        listaCasos.add(new Caso("002","Uraraka","Ochako","F","uraraka@ua.com","Musutafu, Japan", dataNacimiento,dataInforme,"alto","confirmado",882244));
    }
    //Tests
    //Metodo Test para crear un nuevo brote
    @Test
    public void crearBroteTest(){
        //Initial Test, initial users in game Zero!
        Assert.assertEquals(0, this.manager.numBrotes());
        //Test Brote
        brote = new Brote("001","SARS",listaCasos);
        manager.añadirBrote(brote);
        //We expect now 1 brotes
        Assert.assertEquals(1, this.manager.numBrotes());
    }
    //Tests
    //Metodo Test para añadir un caso sobre brote existente
    @Test
    public void añadirCasoBroteTest(){
        //Añadimos Brote de prueba
        brote = new Brote("001","SARS");
        manager.añadirBrote(brote);
        //Initial Test, casos intiiales en brote Sars = 0
        Assert.assertEquals(0, this.manager.getBrote("001").getNumCasos());
        //Now we will add 1 case
        this.manager.añadirCasoBrote("001",listaCasos.get(0));
        //We expect now 1 brotes
        Assert.assertEquals(1, this.manager.getBrote("001").getNumCasos());
        //Now we will add second case
        this.manager.añadirCasoBrote("001",listaCasos.get(1));
        //We expect now 2 brotes
        Assert.assertEquals(2, this.manager.getBrote("001").getNumCasos());
    }
    @After
    public void tearDown() throws Exception {
        manager.liberarRecursos();
    }
}
