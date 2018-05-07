package Persistance.DataMapper;

import Domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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


    private User createUser(ResultSet rs) throws SQLException {
        User u = new User();
        u.setId(rs.getInt("Id_User"));
        u.setPseudo(rs.getString("Pseudo"));
        u.setMail(rs.getString("Mail"));
        u.setNom(rs.getString("Nom"));
        u.setPrenom(rs.getString("Prenom"));
        u.setPassword(rs.getString("Password"));
        return u;
    }

    private List<User> getFriend(Integer id) {
        String req = "SELECT * FROM Friends WHERE Id_User=?";
        List<User> users = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("getFriend User not in bd " + id);
                return null;
            }

            while (rs.next()) {
                User u = this.createUser(rs);
                users.add(u);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    public User find(Integer id) {

        // mettre tout les champs
        String req = "SELECT * FROM Users WHERE Id_User=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Find User not in bd " + id);
                return null;
            }

            User u = this.createUser(rs);
            u.setFriends(this.getFriend(id));

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

    @SuppressWarnings("Duplicates")
    public User findByEmail(String email) {
        String req = "SELECT * FROM Users WHERE Mail=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Email User not in bd " + email);
                return null;
            }
            // create User
            User u = this.createUser(rs);
            u.setFriends(this.getFriend(u.getId()));
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("Duplicates")
    public User findByPseudo(String pseudo) {
        String req = "SELECT * FROM Users WHERE Pseudo=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, pseudo);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Pseudo User not in bd " + pseudo);
                return null;
            }
            // create User
            User u = this.createUser(rs);
            u.setFriends(this.getFriend(u.getId()));
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> findAll() {
        String req = "SELECT * FROM Users";
        List<User> users = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User u = this.createUser(rs);
                users.add(u);
            }

            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }
}
