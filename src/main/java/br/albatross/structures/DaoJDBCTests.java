package br.albatross.structures;

import java.sql.Connection;
import java.sql.DriverManager;

import br.albatross.structures.dao.ContatoJDBCRepository;

public class DaoJDBCTests {

    public static void main(String[] args) throws Exception {

//        Contato c1 = new Contato("Breno Yuri", "85993321234", "Rua XPTO 365");
//        Contato c2 = new Contato("Amanda Blacer", "73211124321", "Rua Messejana City");
//        Contato c3 = new Contato("Thyaga Silva", "7311112232", "Rua da Serrinha");
//        Contato c4 = new Contato("Afonso Sales", "8533214332", "Avenida da Abolição");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "Bl@ck0511")) {

            ContatoJDBCRepository dao = new ContatoJDBCRepository(connection);
            dao.findById(6).ifPresent(System.out::println);

            System.out.println(dao.existsByNome("Breno Yuri"));
        }


    }

}
