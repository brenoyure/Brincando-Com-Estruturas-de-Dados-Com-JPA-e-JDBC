package br.albatross.structures;

import br.albatross.structures.dao.BasicRepositoryImplementation;
import br.albatross.structures.dao.Repository;
import br.albatross.structures.model.Contato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoJPAInsertTests {

    public static void main(String[] args) throws Exception {

      Contato c2 = new Contato("Amanda Blacer", "73211124321", "Rua Messejana City", "Grande Messejana", "FortalCity", "Ceará");
      Contato c3 = new Contato("Thyaga Silva", "7311112232", "Rua da Serrinha", "Serrinha", "FortalCity", "Ceará");
      Contato c4 = new Contato("Afonso Sales", "8533214332", null, null, "Crateús", "Ceará");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("agendadb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Repository<Contato, Integer> repository = new BasicRepositoryImplementation<>(entityManager, Contato.class);

        repository.persist(c2);
        repository.persist(c3);
        repository.persist(c4);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }

}
