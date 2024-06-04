package br.albatross.structures;

import br.albatross.structures.dao.BasicRepositoryImplementation;
import br.albatross.structures.dao.Repository;
import br.albatross.structures.model.Contato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoJPAMergeTests {

    public static void main(String[] args) throws Exception {

        Contato contato = new Contato(6, "Breno Yuri", "85993321234", "Rua XPTO 365", "Grande Messejana", "FortalCity", "Ceará");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("agendadb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Repository<Contato, Integer> repository = new BasicRepositoryImplementation<>(entityManager, Contato.class);

        contato = repository.merge(contato);
        System.out.println(contato);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }

}
