package Service;

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


}
