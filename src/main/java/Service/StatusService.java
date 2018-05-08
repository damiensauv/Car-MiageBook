package Service;

import Domain.Status;
import Persistance.DataMapper.StatusMapper;

import java.sql.SQLException;
import java.util.List;

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

    public List<Status> getStatusUser(Integer id) {

        List<Status> status = statusMapper.getStatusUser(id);


        return status;
    }

    public Status find(Integer id) {
        return statusMapper.find(id);
    }
}
