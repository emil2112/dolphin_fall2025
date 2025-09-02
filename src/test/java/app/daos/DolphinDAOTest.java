package app.daos;

import app.config.HibernateConfig;
import app.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import populators.PersonPopulator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class DolphinDAOTest {

    private static final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryForTest();
    private static final DolphinDAO testDao = new DolphinDAO(emf);
    private static Person p1;
    private static Person p2;

    @BeforeEach
    void setUp() {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Person").executeUpdate();
            em.createNativeQuery("ALTER person_id_seq RESTART WITH 1");
            em.getTransaction().commit();
            Person[] persons = PersonPopulator.populate(testDao);
            p1 = persons[0];
            p2 = persons[1];
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void create() {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(p1);
            List<Person> persons = testDao.getAll();
            assertEquals(1, persons.size());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void getAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}