package br.albatross.structures.model;

import java.util.Objects;

public class Contato {

    private int id;
    private String nome;
    private String telefone;
    private String endereco;

    public Contato(int id, String nome, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(4);
        sb.append("Id: ");
        sb.append(id);

        sb.append(" Nome: ");
        sb.append(nome);

        return sb.toString();

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contato other = (Contato) obj;
        return id == other.id;
    }

}
