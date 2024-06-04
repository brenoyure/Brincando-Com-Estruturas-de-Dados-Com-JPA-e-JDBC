package br.albatross.structures.dao;

import static java.util.Optional.empty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import br.albatross.structures.model.Contato;

public class ContatoJDBCRepository implements ContatoRepository {

    private Connection connection;
    
    public ContatoJDBCRepository(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public Contato persist(Contato contato) {

        try {

            connection.setAutoCommit(false);

            try (PreparedStatement pstm = connection.prepareStatement("INSERT INTO contato VALUES (NULL, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, contato.getNome());
                pstm.setString(2, contato.getTelefone());
                pstm.setString(3, contato.getRua());
                pstm.setString(4, contato.getBairro());
                pstm.setString(5, contato.getCidade());
                pstm.setString(6, contato.getEstado());

                pstm.executeUpdate();

                ResultSet resultSet = pstm.getGeneratedKeys();
                resultSet.next();

                contato.setId(resultSet.getInt(1));

                connection.commit();
                
            }

            return contato;

        } catch (SQLException e) { 

            try {

                connection.rollback();
                throw new RuntimeException(e);

            } catch (SQLException e1) { throw new RuntimeException(e); }
            
        }
        
    }

    @Override
    public Contato merge(Contato contato) {

        try {

            connection.setAutoCommit(false);

            try (PreparedStatement pstm = connection.prepareStatement("UPDATE contato SET nome = ?, telefone = ?, rua = ?, bairro = ?, cidade = ?, estado = ? WHERE id = ?")) {

                pstm.setString(1, contato.getNome());
                pstm.setString(2, contato.getTelefone());
                pstm.setString(3, contato.getRua());
                pstm.setString(4, contato.getBairro());
                pstm.setString(5, contato.getCidade());
                pstm.setString(6, contato.getEstado());
                pstm.setInt(7, contato.getId());

                pstm.executeUpdate();
                connection.commit();

            }

            return contato;

        } catch (SQLException e) { 

            try {

                connection.rollback();
                throw new RuntimeException(e);

            } catch (SQLException e1) { throw new RuntimeException(e); }
            
        }
        
    }    

    @Override
    public List<Contato> findAll() {

        List<Contato> list = new LinkedList<>();        

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM contato")) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while(resultSet.next()) {

                    list
                        .add(new Contato(resultSet.getInt(1), 
                                         resultSet.getString(2), 
                                         resultSet.getString(3), 
                                         resultSet.getString(4),
                                         resultSet.getString(5),
                                         resultSet.getString(6),
                                         resultSet.getString(7)));
                }

            }

            return list;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
        
    }

    @Override
    public Optional<Contato> findById(Integer id) {

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM contato WHERE id = ?")) {

            preparedStatement.setObject(1, id);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while(resultSet.next()) {
                    
                    return Optional.of(new Contato(resultSet.getInt(1), 
                                                   resultSet.getString(2), 
                                                   resultSet.getString(3), 
                                                   resultSet.getString(4)));
                }

            }

            return empty();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
        
    }

    @Override
    public Optional<Contato> getReferenceById(Integer id) {

        return findById(id);

    }

    @Override
    public boolean existsByNome(String nome) {
        
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT EXISTS (SELECT * FROM contato WHERE nome = ?)")) {

            preparedStatement.setString(1, nome);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while(resultSet.next()) {
                    
                    return resultSet.getBoolean(1);
                }

            }

            return false;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
        
    }

    @Override
    public void remove(Contato contato) {

        try {

            connection.setAutoCommit(false);

            try (PreparedStatement pstm = connection.prepareStatement("DELETE FROM contato WHERE id = ?")) {

                pstm.setInt(1, contato.getId());
                pstm.executeUpdate();
                connection.commit();

            }

        } catch (SQLException e) { 

            try {

                connection.rollback();
                throw new RuntimeException(e);

            } catch (SQLException e1) { throw new RuntimeException(e); }

        }

    }

    @Override
    public List<Contato> findByEstado(String estado) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Contato> findByCidadeAndEstado(String cidade, String estado) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Contato> findByBairroAndCidadeAndEstado(String bairro, String cidade, String estado) {
        // TODO Auto-generated method stub
        return null;
    }

}
