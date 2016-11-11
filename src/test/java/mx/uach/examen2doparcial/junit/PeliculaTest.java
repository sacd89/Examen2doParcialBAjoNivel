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
public class PeliculaTest {

    public PeliculaTest() {
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
        Pelicula a = new Pelicula("Lluvia de Hamburguesas", 2012, "Llueve comida.", Boolean.TRUE);
        Pelicula b = new Pelicula("Cars", 2010, "Carros que hablan.", Boolean.FALSE);
        em.getTransaction().begin();
        em.persist(a);
        em.persist(b);
        em.getTransaction().commit();

        em.getTransaction().begin();;
        b.setAnio(2013);
        em.persist(b);
        em.getTransaction().commit();

        Query q = em.createQuery("SELECT a FROM peliculas a");
        List<Pelicula> peliculas = q.getResultList();
        for (Pelicula pelicula : peliculas) {
            System.out.println("peliculas = " + peliculas);
        }
    }
}
