package br.albatross.structures.dao;

import java.util.List;

import br.albatross.structures.model.Contato;

public interface ContatoRepository extends Repository<Contato, Integer> {

    boolean existsByNome(String nome);

    List<Contato> findByEstado(String estado);
    List<Contato> findByCidadeAndEstado(String cidade, String estado);
    List<Contato> findByBairroAndCidadeAndEstado(String bairro, String cidade, String estado);

}
