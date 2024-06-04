package br.albatross.structures.dao;

import java.util.List;

import br.albatross.structures.model.Contato;
import br.albatross.structures.model.Contato_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ContatoBasicRepositoryImplementation extends BasicRepositoryImplementation<Contato, Integer>
        implements ContatoRepository {

    private EntityManager entityManager;

    public ContatoBasicRepositoryImplementation(EntityManager entityManager) {
        super(entityManager, Contato.class);
        this.entityManager = entityManager;
    }

    public boolean existsByNome(String nome) {

        try {

            return entityManager
                    .createQuery("SELECT EXISTS(SELECT c FROM Contato c WHERE nome = ?1)", Boolean.class)
                    .setParameter(1, nome).getSingleResult();

        } catch (NoResultException e) {
            return false;
        }

    }

    @Override
    public List<Contato> findByEstado(String estado) {

        return findByBairroAndCidadeAndEstado(null, null, estado);

    }

    @Override
    public List<Contato> findByCidadeAndEstado(String cidade, String estado) {

        return findByBairroAndCidadeAndEstado(null, cidade, estado);

    }

    @Override
    public List<Contato> findByBairroAndCidadeAndEstado(String bairro, String cidade, String estado) {

        CriteriaBuilder builder       = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contato> query  = builder.createQuery(Contato.class);
        Root<Contato> contato         = query.from(Contato.class);

        Predicate predicates = builder.and();

        if (bairro != null && !bairro.isBlank()) {

            predicates = builder.and(predicates, builder.equal(contato.get(Contato_.bairro), bairro));

        }

        if (cidade != null && !cidade.isBlank()) {

            predicates = builder.and(predicates, builder.equal(contato.get(Contato_.cidade), cidade));

        }

        if (estado != null && !estado.isBlank()) {

            predicates = builder.and(predicates, builder.equal(contato.get(Contato_.estado), estado));

        }

        query.where(predicates).orderBy(
                                    builder.asc(contato.get(Contato_.nome)),
                                    builder.asc(contato.get(Contato_.bairro)),
                                    builder.asc(contato.get(Contato_.cidade)),
                                    builder.asc(contato.get(Contato_.estado)));

        return entityManager
                .createQuery(query)
                .getResultList();

    }

}






















