package Persistance.DataMapper;

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
}
