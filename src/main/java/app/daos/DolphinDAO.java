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
        return List.of();
    }

    @Override
    public Person getById(Integer integer) {
        return null;
    }

    @Override
    public Person update(Person person) {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }
}
