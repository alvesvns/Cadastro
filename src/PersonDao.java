import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
        
public class PersonDao {
    public void insert(RegistrationDto registrationDto) throws Exception {
        String sql = "INSERT INTO person "
                + "(name, cpf, birth, cep, rua, bairro, cidade, uf) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Connect.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            
            RegistrationData data = registrationDto.getRegistrationData();
            RegistrationAddress address = registrationDto.getRegistrationAddress();
            
            preparedStatement.setString(1, data.getName());
            preparedStatement.setString(2, data.getCpf());
            preparedStatement.setDate(3, Date.valueOf(data.getBirth()));
            preparedStatement.setString(4, address.getCep());
            preparedStatement.setString(5, address.getRua());
            preparedStatement.setString(6, address.getBairro());
            preparedStatement.setString(7, address.getCidade());
            preparedStatement.setString(8, address.getUf());
            
            preparedStatement.executeUpdate();
        }
    }
    
    public void save(RegistrationDto registrationDto) throws Exception {
        Integer id = registrationDto.getRegistrationData().getId();

        if (id == null) {
            insert(registrationDto);
        } else {
            update(registrationDto);
        }
    }

    public void update(RegistrationDto registrationDto) throws Exception {
        String sql = "UPDATE person SET name=?, cpf=?, birth=?, cep=?, rua=?, bairro=?, cidade=?, uf=? WHERE id=?";

        RegistrationData data = registrationDto.getRegistrationData();
        RegistrationAddress address = registrationDto.getRegistrationAddress();
        
        if (data.getId() == null) {
            throw new Exception("ID não encontrado para atualizar.");
        }    
        if (existsByCpfAndNotId(data.getCpf(), data.getId())) {
            throw new Exception("CPF já cadastrado.");
        }
        try (Connection conn = Connect.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, data.getName());
            preparedStatement.setString(2, data.getCpf());
            preparedStatement.setDate(3, Date.valueOf(data.getBirth()));
            preparedStatement.setString(4, address.getCep());
            preparedStatement.setString(5, address.getRua());
            preparedStatement.setString(6, address.getBairro());
            preparedStatement.setString(7, address.getCidade());
            preparedStatement.setString(8, address.getUf());
            preparedStatement.setInt(9, data.getId());

            preparedStatement.executeUpdate();
        } 
    }

    
    public List<RegistrationDto> findAll() throws Exception {
        String sql = "SELECT id, name, cpf, birth, cep, rua, bairro, cidade, uf FROM person ORDER BY id DESC";
        
        List<RegistrationDto> list = new ArrayList<>();
        
        try (Connection conn = Connect.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            while (resultSet.next()) {
                
                RegistrationData data = new RegistrationData();
                data.setId(resultSet.getInt("id"));

                data.setName(resultSet.getString("name"));
                data.setCpf(resultSet.getString("cpf"));
                data.setBirth(resultSet.getDate("birth").toLocalDate());
                
                RegistrationAddress address = new RegistrationAddress();
                address.setCep(resultSet.getString("cep"));
                address.setRua(resultSet.getString("rua"));
                address.setBairro(resultSet.getString("bairro"));
                address.setCidade(resultSet.getString("cidade"));
                address.setUf(resultSet.getString("uf"));
                
                RegistrationDto registrationDto = new RegistrationDto();
                registrationDto.setRegistrationData(data);
                registrationDto.setRegistrationAddress(address);
                
                list.add(registrationDto);
            }
        }
        
        return list;
    }
    
    public void deleteById(int id) throws Exception {
        String sql = "DELETE FROM person WHERE id = ?";

        try (Connection conn = Connect.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
        }
    }
    
    public RegistrationDto findById(int id) throws Exception {
        String sql = "SELECT id, name, cpf, birth, cep, rua, bairro, cidade, uf " +
                 "FROM person WHERE id = ?";

        try (Connection conn = Connect.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (java.sql.ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) return null;

                RegistrationData data = new RegistrationData();
                data.setId(resultSet.getInt("id"));
                data.setName(resultSet.getString("name"));
                data.setCpf(resultSet.getString("cpf"));

                java.sql.Date birthSql = resultSet.getDate("birth");
                if (birthSql != null) {
                    data.setBirth(birthSql.toLocalDate());   // precisa existir no RegistrationData
                }

                RegistrationAddress address = new RegistrationAddress();
                address.setCep(resultSet.getString("cep"));
                address.setRua(resultSet.getString("rua"));
                address.setBairro(resultSet.getString("bairro"));
                address.setCidade(resultSet.getString("cidade"));
                address.setUf(resultSet.getString("uf"));

                RegistrationDto registrationDto = new RegistrationDto();
                registrationDto.setRegistrationData(data);
                registrationDto.setRegistrationAddress(address);

                return registrationDto;
            }
        }
    }
    public boolean existsByCpf(String cpf) throws Exception {
        String sql = "SELECT 1 FROM person WHERE cpf = ? LIMIT 1";

        try (Connection conn = Connect.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, cpf);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                return rs.next();
            }
        }
    }

    public boolean existsByCpfAndNotId(String cpf, Integer id) throws Exception {
        String sql = "SELECT 1 FROM person WHERE cpf = ? AND id <> ? LIMIT 1";

        try (Connection conn = Connect.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, cpf);
            preparedStatement.setInt(2, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                return rs.next();
            }
        }
    }
}