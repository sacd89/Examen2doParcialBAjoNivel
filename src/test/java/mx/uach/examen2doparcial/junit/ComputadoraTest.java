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
import mx.uach.examen2doparcial.enums.TipoComputadora;
import mx.uach.examen2doparcial.models.Computadora;
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
public class ComputadoraTest {
    
    public ComputadoraTest() {
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
        Computadora a = new Computadora("Inspiron", "DELL", TipoComputadora.LAPTOP, 10000.00, 2015, Boolean.TRUE);
        Computadora b = new Computadora("Mackbook Pro", "Apple", TipoComputadora.LAPTOP, 30000.00, 2016, Boolean.FALSE);
        em.getTransaction().begin();
        em.persist(a);
        em.persist(b);
        em.getTransaction().commit();

        em.getTransaction().begin();
        b.setVigente(Boolean.TRUE);
        em.persist(b);
        em.getTransaction().commit();

        Query q = em.createQuery("SELECT a FROM computadoras a");
        List<Computadora> computadoras = q.getResultList();
        for (Computadora computadora : computadoras) {
            System.out.println("computadoras = " + computadoras);
        }
     }
}
