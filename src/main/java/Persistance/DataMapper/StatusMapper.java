package Persistance.DataMapper;

import Domain.Commentaire;
import Domain.Status;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StatusMapper extends DataMapper {

    private static StatusMapper instance = null;
    private static UserMapper userMapper;

    public static StatusMapper getInstance() {
        if (instance == null) {
            instance = new StatusMapper();
        }
        return instance;
    }

    private StatusMapper() {
        userMapper = UserMapper.getInstance();
    }


    public void insert(Status status) throws SQLException {

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String query = "INSERT INTO Status (Title,Text, Date, Id_User) VALUES (?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, status.getTitle());
        preparedStatement.setString(2, status.getText());
        preparedStatement.setString(3, formatter.format(status.getDate()));
        preparedStatement.setInt(4, status.getOwner().getId());
        preparedStatement.executeUpdate();

    }

    public Status createStatus(ResultSet rs) throws SQLException, ParseException {

        Status status = new Status();

        status.setId(rs.getInt("Id_Status"));
        status.setTitle(rs.getString("Title"));
        status.setText(rs.getString("Text"));
        status.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("Date")));
        status.setOwner(userMapper.find(rs.getInt("Id_User")));
        status.setImage(null);

        return status;
    }

    public List<Status> getStatusUser(Integer id) {

        String req = "SELECT * FROM Status WHERE Id_User=?";
        List<Status> status = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("get status not in bd " + id);
                return null;
            }
            rs.beforeFirst();

            while (rs.next()) {
                status.add(createStatus(rs));
            }
            return status;
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Status find(Integer id) {
        String req = "SELECT * FROM Status WHERE Id_Status=?";

        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("get status not in bd " + id);
                return null;
            }
            //rs.beforeFirst();
            return createStatus(rs);
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertCommentaire(Commentaire commentaire) throws SQLException {

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String query = "INSERT INTO Comments (Id_Status, Id_User, Date, Text) VALUES (?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, commentaire.getIdStatus());
        preparedStatement.setInt(2, commentaire.getOwner().getId());
        preparedStatement.setString(3, formatter.format(commentaire.getDate()));
        preparedStatement.setString(4, commentaire.getText());
        preparedStatement.executeUpdate();

    }

    public List<Commentaire> findComs(Integer id) {

        String req = "SELECT * FROM Comments WHERE Id_Status=?";
        List<Commentaire> commentaires = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("get commentaire not in bd " + id);
                return null;
            }
            rs.beforeFirst();

            while (rs.next()) {
                commentaires.add(createComm(rs));
            }
            return commentaires;
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    private Commentaire createComm(ResultSet rs) throws SQLException, ParseException {

        Commentaire commentaire = new Commentaire();

        commentaire.setId(rs.getInt("Id_Comment"));
        commentaire.setIdStatus(rs.getInt("Id_Status"));
        commentaire.setText(rs.getString("Text"));
        commentaire.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("Date")));
        commentaire.setOwner(userMapper.find(rs.getInt("Id_User")));

        return commentaire;
    }
}
