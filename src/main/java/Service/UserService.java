package Service;

import Domain.User;
import Persistance.DataMapper.UserMapper;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private static UserService instance = null;
    private UserMapper userMapper;

    private UserService() {
        this.userMapper = UserMapper.getInstance();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public boolean checkUserExistEmail(String email) {
        return this.userMapper.findByEmail(email) == null;
    }

    public boolean checkUserExistPseudo(String pseudo) {
        return this.userMapper.findByPseudo(pseudo) == null;
    }


    public boolean checkLogin(String email, String password) {

        return true;
    }

    public void getAllUsersWithout(Integer id) {

        UserMapper um = UserMapper.getInstance();
        List<User> users = um.findAll();

        // TODO => supprimer la personne ID

    }

    public boolean signup(User user) {

        if (!checkUserExistEmail(user.getMail()))
            return false;
        if (!checkUserExistPseudo(user.getPseudo()))
            return false;

        try {
            userMapper.insert(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
