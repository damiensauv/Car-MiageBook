package Service;

import Domain.Commentaire;
import Domain.Status;
import Domain.User;
import Persistance.DataMapper.StatusMapper;

import java.sql.SQLException;
import java.util.ArrayList;
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

        User user = UserService.getInstance().getUser(id);
        List<Status> status = new ArrayList<>();

        List<Status> t = statusMapper.getStatusUser(id);
        if (t != null)
            status.addAll(t);

        for (Integer u : user.getFriends()) {

            List<Status> tmp = statusMapper.getStatusUser(u);
            if (tmp != null)
                status.addAll(tmp);
        }

        return status;
    }

    public Status find(Integer id) {
        return statusMapper.find(id);
    }

    public void insertCommentaire(Commentaire commentaire) {

        try {
            statusMapper.insertCommentaire(commentaire);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public List<Commentaire> findComs(Integer id) {
        return statusMapper.findComs(id);
    }
}
