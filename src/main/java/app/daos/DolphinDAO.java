package app.daos;

import app.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class DolphinDAO implements IDAO<Person, Integer>{

    private final EntityManagerFactory emf;

    public DolphinDAO(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public Person create(Person person) {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        }
        return person;
    }

    @Override
    public List<Person> getAll() {
        try(EntityManager em = emf.createEntityManager()){
            return em.createQuery("SELECT p FROM Person p", Person.class)
                    .getResultList();
        }
    }

    @Override
    public Person getById(Integer Id) {
        try (EntityManager em = emf.createEntityManager()){
            return em.createQuery("SELECT p FROM Person p WHERE p.Id = :i", Person.class)
                    .setParameter("i", Id)
                    .getSingleResult();
        }
    }

    @Override
    public Person update(Person person) {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
        }
        return person;
    }

    @Override
    public boolean delete(Integer Id) {
        EntityManager em = emf.createEntityManager();
        try{
            Person p = em.createQuery("SELECT p FROM Person p WHERE p.Id = :i", Person.class)
                    .setParameter("i", Id)
                    .getSingleResult();
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if(em.getTransaction() != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
