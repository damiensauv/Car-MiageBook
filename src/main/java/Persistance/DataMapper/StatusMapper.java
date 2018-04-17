package Persistance.DataMapper;

import Domain.Status;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatusMapper extends DataMapper {

    private static StatusMapper instance = null;

    public static StatusMapper getInstance() {
        if (instance == null) {
            instance = new StatusMapper();
        }
        return instance;
    }

    private StatusMapper() {
    }


    public void insert(Status status) throws SQLException {


        String query = "INSERT INTO Status (Text,Id_User) VALUES (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, status.getText());
        preparedStatement.setInt(2, status.getOwner().getId());
        preparedStatement.executeUpdate();

    }
}
