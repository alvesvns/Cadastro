package dao;

import infra.Connect;
import entity.Person;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {

    public Integer insert(Person person) throws Exception {
        if (person.getAddressId() == null) throw new Exception("id_address não informado na pessoa.");

        String sql = "INSERT INTO person (name, cpf, birth, id_address) VALUES (?, ?, ?, ?)";

        try (Connection conn = Connect.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getCpf());
            preparedStatement.setDate(3, Date.valueOf(person.getBirth()));
            preparedStatement.setInt(4, person.getAddressId());

            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) return resultSet.getInt(1);
            }
        }

        throw new Exception("Falha ao obter ID da pessoa inserida.");
    }

    public void update(Person person) throws Exception {
        if (person.getId() == null) throw new Exception("ID da pessoa não informado.");
        if (person.getAddressId() == null) throw new Exception("id_address não informado na pessoa.");

        String sql = "UPDATE person SET name=?, cpf=?, birth=?, id_address=? WHERE id=?";

        try (Connection conn = Connect.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getCpf());
            preparedStatement.setDate(3, Date.valueOf(person.getBirth()));
            preparedStatement.setInt(4, person.getAddressId());
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
        String sql = "SELECT id, name, cpf, birth, id_address FROM person WHERE id=?";

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

                person.setAddressId(resultSet.getInt("id_address"));
                return person;
            }
        }
    }

    public List<Person> findAll() throws Exception {
        String sql = "SELECT id, name, cpf, birth, id_address FROM person ORDER BY id DESC";
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

                person.setAddressId(resultSet.getInt("id_address"));
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