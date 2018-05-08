package Service;

import Domain.Status;
import Persistance.DataMapper.StatusMapper;

import java.sql.SQLException;

public class StatusService {

    private static StatusService instance = null;
    private StatusMapper statusMapper;

    private StatusService() {
        this.statusMapper = StatusMapper.getInstance();
    }

    public static StatusService getInstance() {
        if (instance == null) {
            instance = new StatusService();
        }
        return instance;
    }

    public void insert(Status status) {
        try {
            statusMapper.insert(status);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
