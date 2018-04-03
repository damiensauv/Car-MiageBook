package Util;

import Domain.Interface.IUser;
import Persistance.DataMapper.UserMapper;

public class Committer extends Visitor {

    public void visiter(IUser o) {

        UserMapper.getInstance().update(o);

    }
}
