/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.examen2doparcial.junit;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.uach.examen2doparcial.models.Alumno;
import mx.uach.examen2doparcial.models.Pelicula;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dsantillanes
 */
public class AlumnoTest {

    public AlumnoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoPU");
        EntityManager em = emf.createEntityManager();
        Alumno a = new Alumno("Daniela", "Santillanes", "Castro", 21, "SACD950908MCHNSN07", "SACD950908A1S");
        Alumno b = new Alumno("Erik", "Zubia", "Hernandez", 21, "ZUHE950921HCHBRR01", "ZUHE950921HCH");
        em.getTransaction().begin();
        em.persist(a);
        em.persist(b);
        em.getTransaction().commit();

        em.getTransaction().begin();
        b.setNombre("Erik David");
        em.persist(b);
        em.getTransaction().commit();

        Query q = em.createQuery("SELECT a FROM alumnos a");
        List<Alumno> alumnos = q.getResultList();
        for (Alumno alumno : alumnos) {
            System.out.println("alumnos = " + alumnos);
        }
    }
}
