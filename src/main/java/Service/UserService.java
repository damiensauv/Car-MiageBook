package Service;

import Domain.User;
import Persistance.DataMapper.UserMapper;

import java.util.List;

public class UserService {

    private static UserService instance = null;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public boolean checkUserExistEmail(String email) {
/*
        UserMapper um = UserMapper.getInstance();
        um.findByEmail(email);
*/
        return true;
    }

    public boolean checkUserExistPseudo(String pseudo) {
/*
        UserMapper um = UserMapper.getInstance();
        um.findByPseudo(pseudo);
*/
        return true;
    }


    public boolean checkLogin(String email, String password) {

        return true;
    }

    public void getAllUsersWithout(Integer id) {

        UserMapper um = UserMapper.getInstance();
        List<User> users = um.findAll();

        // TODO => supprimer la personne ID

    }
}
