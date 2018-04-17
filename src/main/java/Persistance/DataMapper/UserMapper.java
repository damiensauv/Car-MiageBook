package Persistance.DataMapper;

import Domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserMapper extends DataMapper {

    private static UserMapper instance = null;

    public static UserMapper getInstance() {
        if (instance == null) {
            instance = new UserMapper();
        }
        return instance;
    }

    private UserMapper() {
    }


    public User find(Integer id) {

        // mettre tout les champs
        String req = "SELECT * FROM Users WHERE Id_User=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("User not in bd " + id);
                return null;
            }
            // create User
            User u = new User();
            u.setId(rs.getInt("Id_User"));
            u.setPseudo(rs.getString("Pseudo"));
            u.setMail(rs.getString("Mail"));
            u.setNom(rs.getString("Nom"));
            u.setPrenom(rs.getString("Prenom"));
            u.setPassword(rs.getString("Password"));

            return u;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer insert(User o) throws SQLException {
        String query = "INSERT INTO Users(Mail, Nom, Prenom, Pseudo, Password) VALUES (?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, o.getMail());
        preparedStatement.setString(2, o.getNom());
        preparedStatement.setString(3, o.getPrenom());
        preparedStatement.setString(4, o.getPseudo());
        preparedStatement.setString(5, o.getPassword());
        preparedStatement.executeUpdate();

        return 0;
    }

    public User findByEmail(String email) {
        return null;
    }

    public User findByPseudo(String pseudo) {
        return null;
    }

    public List<User> findAll() {
        String req = "SELECT * FROM Users";
        try {
            PreparedStatement ps = connection.prepareStatement(req);

            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Empty Table Users");
                return null;
            }

            // create User TODO => faire une fct pour
            User u = new User();
            u.setId(rs.getInt("Id_User"));
            u.setPseudo(rs.getString("Pseudo"));
            u.setMail(rs.getString("Mail"));
            u.setNom(rs.getString("Nom"));
            u.setPrenom(rs.getString("Prenom"));
            u.setPassword(rs.getString("Password"));

            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }



    }
}
