package br.albatross.structures;

import br.albatross.structures.dao.ContatoBasicRepositoryImplementation;
import br.albatross.structures.dao.ContatoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoJPATests {

    public static void main(String[] args) throws Exception {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("agendadb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();



        ContatoRepository repository = new ContatoBasicRepositoryImplementation(entityManager);




        repository
            .findByBairroAndCidadeAndEstado("Grande Messejana", null, "Ceará")
            .forEach(System.out::println);
            





        entityManager.close();
        entityManagerFactory.close();

    }

}
