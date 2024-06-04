package br.albatross.structures.model;

import java.time.LocalDateTime;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(value = Contato.class)
public abstract class Contato_ {

    public static volatile SingularAttribute<Contato, Integer>        id;
    public static volatile SingularAttribute<Contato, String>         nome;
    public static volatile SingularAttribute<Contato, String>         telefone;
    public static volatile SingularAttribute<Contato, String>         rua;
    public static volatile SingularAttribute<Contato, String>         bairro;
    public static volatile SingularAttribute<Contato, String>         cidade;
    public static volatile SingularAttribute<Contato, String>         estado;
    public static volatile SingularAttribute<Contato, LocalDateTime>  dataHoraCriacao;
    public static volatile SingularAttribute<Contato, LocalDateTime>  dataHoraAtualizacao;

}
