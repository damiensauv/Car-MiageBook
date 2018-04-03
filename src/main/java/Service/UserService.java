package Service;

import Persistance.DataMapper.UserMapper;

public class UserService {


    public boolean checkUserExistEmail(String email){
        UserMapper um = UserMapper.getInstance();

        um.findByEmail(email);

        return true;
    }

    public boolean checkUserExistPseudo(String pseudo){
        UserMapper um = UserMapper.getInstance();

        um.findByPseudo(pseudo);

        return true;
    }


}
