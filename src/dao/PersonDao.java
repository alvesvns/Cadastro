package dao;

import infra.Connect;
import entity.Person;
import entity.Address;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {

    public Integer insert(Person person) throws Exception {
        if (person.getAddress() == null || person.getAddress().getId() == null) throw new Exception("id_address não informado na pessoa.");

        String sql = "INSERT INTO person (name, cpf, birth, id_address) VALUES (?, ?, ?, ?)";

        try (Connection conn = Connect.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getCpf());
            preparedStatement.setDate(3, Date.valueOf(person.getBirth()));
            preparedStatement.setInt(4, person.getAddress().getId());

            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) return resultSet.getInt(1);
            }
        }

        throw new Exception("Falha ao obter ID da pessoa inserida.");
    }

    public void update(Person person) throws Exception {
        if (person.getId() == null) throw new Exception("ID da pessoa não informado.");
        if (person.getAddress().getId() == null) throw new Exception("id_address não informado na pessoa.");

        String sql = "UPDATE person SET name=?, cpf=?, birth=?, id_address=? WHERE id=?";

        try (Connection conn = Connect.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getCpf());
            preparedStatement.setDate(3, Date.valueOf(person.getBirth()));
            preparedStatement.setInt(4, person.getAddress().getId());
            preparedStatement.setInt(5, person.getId());

            preparedStatement.executeUpdate();
        }
    }

    public void deleteById(int id) throws Exception {
        String sql = "DELETE FROM person WHERE id=?";

        try (Connection conn = Connect.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public Person findById(int id) throws Exception {
        String sql = "SELECT p.id, p.name, p.cpf, p.birth, " +
                 "a.id AS a_id, a.rua, a.bairro, a.cidade, a.uf, a.cep " +
                 "FROM person p " +
                 "LEFT JOIN address a ON a.id = p.id_address " +
                 "WHERE p.id = ?";

        try (Connection conn = Connect.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) return null;

                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setCpf(resultSet.getString("cpf"));

                Date date = resultSet.getDate("birth");
                if (date != null) person.setBirth(date.toLocalDate());

                int addressId = resultSet.getInt("a_id");

                if (!resultSet.wasNull()) {
                    Address address = new Address();
                    address.setId(addressId);
                    address.setCep(resultSet.getString("cep"));
                    address.setRua(resultSet.getString("rua"));
                    address.setBairro(resultSet.getString("bairro"));
                    address.setCidade(resultSet.getString("cidade"));
                    address.setUf(resultSet.getString("uf"));

                    person.setAddress(address);
                } else {
                    person.setAddress(null);
                }
                return person;
            }
        }
    }

    public List<Person> findAll() throws Exception {
        String sql = "SELECT p.id, p.name, p.cpf, p.birth, " +
                 "a.id AS a_id, a.rua, a.bairro, a.cidade, a.uf, a.cep " +
                 "FROM person p " +
                 "LEFT JOIN address a ON a.id = p.id_address " +
                 "ORDER BY p.id DESC";

        List<Person> list = new ArrayList<>();

        try (Connection conn = Connect.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setCpf(resultSet.getString("cpf"));

                Date date = resultSet.getDate("birth");
                if (date != null) person.setBirth(date.toLocalDate());

                int addressId = resultSet.getInt("a_id");

                if (!resultSet.wasNull()) {
                    Address address = new Address();
                    address.setId(addressId);
                    address.setRua(resultSet.getString("rua"));
                    address.setBairro(resultSet.getString("bairro"));
                    address.setCidade(resultSet.getString("cidade"));
                    address.setUf(resultSet.getString("uf"));
                    address.setCep(resultSet.getString("cep"));

                    person.setAddress(address);
                } else {
                    person.setAddress(null);
                }
                list.add(person);
            }
        }
        return list;
    }

    public boolean existsByCpf(String cpf) throws Exception {
        String sql = "SELECT 1 FROM person WHERE cpf=? LIMIT 1";

        try (Connection conn = Connect.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, cpf);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    public boolean existsByCpfAndNotId(String cpf, int id) throws Exception {
        String sql = "SELECT 1 FROM person WHERE cpf=? AND id<>? LIMIT 1";

        try (Connection conn = Connect.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, cpf);
            preparedStatement.setInt(2, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }
}