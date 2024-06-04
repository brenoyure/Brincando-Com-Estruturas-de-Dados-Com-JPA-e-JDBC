package br.albatross.structures.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, unique = true, nullable = false)
    private String nome;

    @Column(length = 100, unique = false, nullable = false)
    private String telefone;

    @Column(length = 100, unique = false, nullable = true)
    private String rua;

    @Column(length = 100, unique = false, nullable = true)
    private String bairro;

    @Column(length = 50, unique = false, nullable = true)
    private String cidade;

    @Column(length = 50, unique = false, nullable = true)
    private String estado;

    public Contato() {

    }

    public Contato(String nome, String telefone, String rua) {
        this.nome = nome;
        this.telefone = telefone;
        this.rua = rua;
    }

    public Contato(String nome, String telefone, String rua, String bairro, String cidade, String estado) {
        this.nome = nome;
        this.telefone = telefone;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Contato(int id, String nome, String telefone, String rua) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.rua = rua;
    }

    public Contato(int id, String nome, String telefone, String rua, String bairro, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Contato [id=");
        builder.append(id);
        builder.append(", ");
        if (nome != null) {
            builder.append("nome=");
            builder.append(nome);
            builder.append(", ");
        }
        if (telefone != null) {
            builder.append("telefone=");
            builder.append(telefone);
            builder.append(", ");
        }
        if (rua != null) {
            builder.append("rua=");
            builder.append(rua);
            builder.append(", ");
        }
        if (bairro != null) {
            builder.append("bairro=");
            builder.append(bairro);
            builder.append(", ");
        }
        if (cidade != null) {
            builder.append("cidade=");
            builder.append(cidade);
            builder.append(", ");
        }
        if (estado != null) {
            builder.append("estado=");
            builder.append(estado);
        }
        builder.append("]");
        return builder.toString();
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
