package zti.lab3;

import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import zti.model.Person;

public class ConnJPA {
    private EntityManagerFactory managerFactory; // = Persistence.createEntityManagerFactory(persistenceUnitName);
    private EntityManager entityManager; // = managerFactory.createEntityManager();
    private EntityTransaction entityTransaction;

    public ConnJPA(String persistenceUnitName ) {
        managerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        entityManager = managerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @SuppressWarnings("unchecked")
    public List<Person> getPersonList(String filter) {
        List<Person> people = null;
        try {
            if (filter.equals(""))
                people = (List<Person>) entityManager.createNamedQuery("findAll", Person.class).getResultList();
            else
                people = (List<Person>) entityManager.createNamedQuery("findByLastnameOrEmail", Person.class).setParameter(1, filter).getResultList();
            // manager.close();
        } catch (Exception e) {
            System.out.println("Failed !!! " + e.getMessage());
        }
        return people;
    }
    public List<Person> getPersonListByLnameOrEmail(String param) {
        List<Person> people2 = null;
        try {
            people2 = (List<Person>) entityManager.createNamedQuery("findByLastnameOrEmail").setParameter("str", param).getResultList();
            // manager.close();
        } catch (Exception e) {
            System.out.println("Failed !!! " + e.getMessage());
        }
        return people2;
    }
    public void savePerson( Person entity) {
        //entityTransaction.begin();
        System.out.println("[ConnJPA] Save entity - " + entity.getLname() );
        entityTransaction.begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityTransaction.commit();
    }

    public void updatePerson(Person entity) {
        entityTransaction.begin();
        entityManager.merge(entity);
        entityTransaction.commit();
    }

    public void deletePerson(Person entity) {
        System.out.println("Delete entity - " + entity.getLname() + " ID: " + entity.getId().toString());
        entityTransaction.begin();
        entityManager.remove(entity);
        entityManager.flush();
        entityTransaction.commit();
    }

    public Person findPerson(int id) {
        Person entity = (Person) entityManager.find(Person.class, id);
        return entity;
    }
}