package dao;

import infra.Connect;
import entity.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressDao {

    public Integer insert(Address address) throws Exception {
        String sql = "INSERT INTO address (cep, rua, bairro, cidade, uf) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Connect.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, address.getCep());
            preparedStatement.setString(2, address.getRua());
            preparedStatement.setString(3, address.getBairro());
            preparedStatement.setString(4, address.getCidade());
            preparedStatement.setString(5, address.getUf());

            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) return resultSet.getInt(1);
            }
        }

        throw new Exception("Falha ao obter ID do endereço inserido.");
    }

    public void update(Address address) throws Exception {
        if (address.getId() == null) throw new Exception("ID do endereço não informado.");

        String sql = "UPDATE address SET cep=?, rua=?, bairro=?, cidade=?, uf=? WHERE id=?";

        try (Connection conn = Connect.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, address.getCep());
            preparedStatement.setString(2, address.getRua());
            preparedStatement.setString(3, address.getBairro());
            preparedStatement.setString(4, address.getCidade());
            preparedStatement.setString(5, address.getUf());
            preparedStatement.setInt(6, address.getId());

            preparedStatement.executeUpdate();
        }
    }

    public void deleteById(int id) throws Exception {
        String sql = "DELETE FROM address WHERE id=?";

        try (Connection conn = Connect.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
